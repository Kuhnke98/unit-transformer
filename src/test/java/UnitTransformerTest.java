import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static units.dataUnits.DataBinaryUnit.YOBIBIT;
import static units.dataUnits.DataByteUnit.TEBIBYTE;
import static units.dataUnits.DataByteUnit.YOBIBYTE;
import static units.dataUnits.SIDataBinaryUnit.YOTTABIT;
import static units.dataUnits.SIDataByteUnit.YOTTABYTE;
import static units.lengthUnits.AstronomicalLengthUnit.LIGHT_YEAR;
import static units.lengthUnits.InternationalLengthUnit.MILE;
import static units.lengthUnits.LengthUnit.*;
import static units.lengthUnits.UsSurveyLengthUnit.LEAGUE;
import static units.massUnits.BrittishMassUnit.UNZE;
import static units.massUnits.BrittishMassUnit.ZENTNER;
import static units.massUnits.MassUnit.*;

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
        double resultValue = UnitTransformer.transform(TRANSFORM_VALUE, TEBIBYTE, TEBIBYTE);
        Assertions.assertEquals(TRANSFORM_VALUE, resultValue);
    }

    @Test
    void transformDifferentUnitTypesFail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> UnitTransformer.transform(TRANSFORM_VALUE, TEBIBYTE, KILOMETER));
    }


    /**
     * LengthUnit Test
     */

    @Test
    void transformLengthUnitPass() {
        double resultValue = UnitTransformer.transform(TRANSFORM_VALUE, MILE, ATTOMETER);
        Assertions.assertEquals(1.609347219E23, resultValue);
    }

    @Test
    void transformMulitpleDifferentLengthUnitPass() {
        double resultValue = UnitTransformer.transform(TRANSFORM_VALUE, GIGAMETER, LEAGUE);
        Assertions.assertEquals(2.0712330174426716E7, resultValue);
    }

    @Test
    void transformMileToLightYearLengthUnitPass() {
        double resultValue = UnitTransformer.transform(TRANSFORM_VALUE, MILE, LIGHT_YEAR);
        Assertions.assertEquals(1.7010328918718746E-11, resultValue);
    }

    /**
     * MassUnit Test
     */

    @Test
    void transformMassUnitPass() {
        double resultValue = UnitTransformer.transform(TRANSFORM_VALUE, KILOTONNE, MILLIGRAM);
        Assertions.assertEquals(1.000000000000018E14, resultValue);
    }

    @Test
    void transformBritishMassUnitPass() {
        String resultValue = UnitTransformer.transform(TRANSFORM_VALUE, ZENTNER, UNZE, "#.##");
        Assertions.assertEquals("179200", resultValue);
    }

    @Test
    void transformBritishMassUnitToMassUnitPass() {
        double resultValue = UnitTransformer.transform(TRANSFORM_VALUE, ZENTNER, KILOGRAM);
        Assertions.assertEquals(5080.234543999862, resultValue);
    }


    /**
     * MergingUnits Test
     */

    @Test
    void transformSIDataByteUnitToDataByteUnitFormattedPass() {
        String resultValue = UnitTransformer.transform(TRANSFORM_VALUE, YOTTABYTE, YOBIBYTE, "#.##");
        Assertions.assertEquals("82,72", resultValue);
    }

    @Test
    void transformDataByteUnitToDataBinaryUnitFormattedPass() {
        double resultValue = UnitTransformer.transform(TRANSFORM_VALUE, YOBIBYTE, YOBIBIT);
        Assertions.assertEquals(800, resultValue);
    }

    @Test
    void transformDataBinaryUnitToSIDataBinaryUnitFormattedPass() {
        String resultValue = UnitTransformer.transform(TRANSFORM_VALUE, YOBIBIT, YOTTABIT, "#.##");
        Assertions.assertEquals("120,89", resultValue);
    }

    @Test
    void transformSIDataBinaryUnitToSIDataByteUnitFormattedPass() {
        String resultValue = UnitTransformer.transform(TRANSFORM_VALUE, YOTTABIT, YOTTABYTE, "#.##");
        Assertions.assertEquals("12,5", resultValue);
    }
}