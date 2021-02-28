import units.Unitizer;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author kuhnke98
 */
public class UnitTransformer {

    public static final String COULD_NOT_FIND_UNITS_WITH_SAME_TYPE = "could not find units with same type between following two enums %s -> %s";

    /**
     * converts Value from one to another and formats this value
     *
     * @param value      - value to transform
     * @param unit       - unit from value
     * @param targetUnit - unit to transform
     * @param pattern    - format from {@link DecimalFormat}
     * @return String
     */
    public static String transform(double value, Enum<?> unit, Enum<?> targetUnit, String pattern) {
        return new DecimalFormat(pattern).format(transform(value, unit, targetUnit));
    }

    /**
     * converts Value from one to another
     *
     * @param value      - value to transform
     * @param unit       - unit from value
     * @param targetUnit - unit to transform
     * @return double
     */
    public static double transform(double value, Enum<?> unit, Enum<?> targetUnit) {
        if (!unit.getClass().equals(targetUnit.getClass())) {
            Enum<?> matchedUnit = getCommonUnit(unit, targetUnit);
            return transformMatchingUnit(value, matchedUnit, unit, targetUnit);
        }

        int unitOrdinal = unit.ordinal();
        int targetUnitOrdinal = targetUnit.ordinal();
        return targetUnitOrdinal < unitOrdinal ? transformLowerUnit(value, unit, targetUnit) : transformHigherUnit(value, unit, targetUnit);
    }

    private static Enum<?> getCommonUnit(Enum<?> unit, Enum<?> targetUnit) {
        return Arrays.stream(unit.getDeclaringClass().getEnumConstants())
                .filter(thisUnit -> isMatchUnit(targetUnit.getDeclaringClass().getEnumConstants(), thisUnit))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(COULD_NOT_FIND_UNITS_WITH_SAME_TYPE, targetUnit.getClass(), targetUnit.getClass())));
    }

    private static boolean isMatchUnit(Enum<?>[] targetEnumConstants, Enum<?> enumConstant) {
        return Arrays.stream(targetEnumConstants).anyMatch(targetEnumConstant -> targetEnumConstant.name().equals(enumConstant.name()));
    }

    private static double transformMatchingUnit(double value, Enum<?> matchedUnit, Enum<?> unit, Enum<?> targetUnit) {
        value = !matchedUnit.equals(unit) ? transform(value, unit, matchedUnit) : value;
        Enum<?> targetMatchingUnit = getTargetMatchingUnit(matchedUnit, targetUnit);
        return !targetMatchingUnit.equals(targetUnit) ? transform(value, targetMatchingUnit, targetUnit) : value;
    }

    private static Enum<?> getTargetMatchingUnit(Enum<?> matchedUnit, Enum<?> targetUnit) {
        Enum<?>[] targetEnumConstants = targetUnit.getDeclaringClass().getEnumConstants();
        return Arrays.stream(targetEnumConstants)
                .filter(targetEnum -> targetEnum.name().equals(matchedUnit.name()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(COULD_NOT_FIND_UNITS_WITH_SAME_TYPE, targetUnit.getClass(), matchedUnit.getClass())));
    }

    private static double transformHigherUnit(double value, Enum<?> unit, Enum<?> targetUnit) {
        Enum<?>[] targetEnum = unit.getDeclaringClass().getEnumConstants();
        while (targetUnit.ordinal() > unit.ordinal()) {
            value = value / ((Unitizer) unit).getMultiplier();
            unit = targetEnum[unit.ordinal() + 1];
        }
        return value;
    }

    private static double transformLowerUnit(double value, Enum<?> unit, Enum<?> targetUnit) {
        Enum<?>[] targetEnum = unit.getDeclaringClass().getEnumConstants();
        while (targetUnit.ordinal() < unit.ordinal()) {
            unit = targetEnum[unit.ordinal() - 1];
            value = value * ((Unitizer) unit).getMultiplier();
        }
        return value;
    }
}