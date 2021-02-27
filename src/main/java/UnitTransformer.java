import units.Unitizer;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * @author kuhnke98
 */
public class UnitTransformer {

    /**
     * converts Value from one to another and formats this value
     *
     * @param value      - value to transform
     * @param unit       - unit from value
     * @param targetUnit - unit to transform
     * @param pattern    - format from {@link DecimalFormat}
     * @return
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
            return merge(value, unit, targetUnit);
        }

        int unitOrdinal = unit.ordinal();
        int targetUnitOrdinal = targetUnit.ordinal();
        return targetUnitOrdinal < unitOrdinal ? transformLowerUnit(value, unit, targetUnit) : transformHigherUnit(value, unit, targetUnit);
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

    private static double merge(double value, Enum<?> unit, Enum<?> targetUnit) {
        Enum<?>[] enumConstants = unit.getDeclaringClass().getEnumConstants();
        Enum<?>[] targetEnumConstants = targetUnit.getDeclaringClass().getEnumConstants();

        Enum<?> matchUnit = Arrays.stream(enumConstants)
                .filter(thisUnit -> isMatchUnit(targetEnumConstants, thisUnit))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("could not find units with same type between following two enums %s -> %s", unit.getClass(), targetUnit.getClass())));

        value = !matchUnit.equals(unit) ? transform(value, unit, matchUnit) : value;
        Enum<?> targetMatchingUnit = Arrays.stream(targetEnumConstants).filter(anEnum -> anEnum.name().equals(matchUnit.name())).findFirst().get();
        return !targetMatchingUnit.equals(targetUnit) ? transform(value, targetMatchingUnit, targetUnit) : value;
    }

    private static boolean isMatchUnit(Enum<?>[] targetEnumConstants, Enum<?> enumConstant) {
        return Arrays.stream(targetEnumConstants).anyMatch(targetEnumConstant -> targetEnumConstant.name().equals(enumConstant.name()));
    }
}