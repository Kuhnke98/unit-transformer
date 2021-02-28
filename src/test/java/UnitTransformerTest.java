import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import units.*;


/**
 * @author kuhnke98
 *
 * This Tests test, if this Plugin is wroking and these calculations are correct
 * result got from https://www.unitjuggler.com
 */
class UnitTransformerTest {

    private static final double TRANSFORM_VALUE = 100;

    /**
     * Global mechanism
     */

    @Test
    void transformSameUnitPass() {
        double resultValue = UnitTransformer.transform(TRANSFORM_VALUE, DataByteUnit.TEBIBYTE, DataByteUnit.TEBIBYTE);
        Assertions.assertEquals(TRANSFORM_VALUE, resultValue);
    }

    @Test
    void transformDifferentUnitTypesFail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> UnitTransformer.transform(TRANSFORM_VALUE, DataByteUnit.TEBIBYTE, LengthUnit.KILOMETER));
    }


    /**
     * LengthUnit Test
     */

    @Test
    void transformLengthUnitPass() {
        double resultValue = UnitTransformer.transform(TRANSFORM_VALUE, LengthUnit.MILE, LengthUnit.ATTOMETER);
        Assertions.assertEquals(1.6093439983584694E23, resultValue);
    }


    /**
     * MergingUnits Test
     */

    @Test
    void transformSIDataByteUnitToDataByteUnitFormattedPass() {
        String resultValue = UnitTransformer.transform(TRANSFORM_VALUE, SIDataByteUnit.YOTTABYTE, DataByteUnit.YOBIBYTE, "#.##");
        Assertions.assertEquals("82,72", resultValue);
    }

    @Test
    void transformDataByteUnitToDataBinaryUnitFormattedPass() {
        double resultValue = UnitTransformer.transform(TRANSFORM_VALUE, DataByteUnit.YOBIBYTE, DataBinaryUnit.YOBIBIT);
        Assertions.assertEquals(800, resultValue);
    }

    @Test
    void transformDataBinaryUnitToSIDataBinaryUnitFormattedPass() {
        String resultValue = UnitTransformer.transform(TRANSFORM_VALUE, DataBinaryUnit.YOBIBIT, SIDataBinaryUnit.YOTTABIT, "#.##");
        Assertions.assertEquals("120,89", resultValue);
    }

    @Test
    void transformSIDataBinaryUnitToSIDataByteUnitFormattedPass() {
        String resultValue = UnitTransformer.transform(TRANSFORM_VALUE, SIDataBinaryUnit.YOTTABIT, SIDataByteUnit.YOTTABYTE, "#.##");
        Assertions.assertEquals("12,5", resultValue);
    }
}