import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import units.DataUnitBit;
import units.DataUnitByte;
import units.LengthUnit;

class UnitTransformerTest {

    private static final double TRANSFORM_VALUE = 100;

    @Test
    void transformSameUnitPass() {
        double resultValue = UnitTransformer.transform(TRANSFORM_VALUE, DataUnitByte.TEBIBYTE, DataUnitByte.TEBIBYTE);
        Assertions.assertEquals(TRANSFORM_VALUE, resultValue);
    }

    @Test
    void transformDifferentUnitTypesFail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> UnitTransformer.transform(TRANSFORM_VALUE, DataUnitByte.TEBIBYTE, LengthUnit.KILOMETER));
    }

    @Test
    void transformLengthUnitPass() {
        double resultValue = UnitTransformer.transform(TRANSFORM_VALUE, LengthUnit.MILE, LengthUnit.ATTOMETER);
        Assertions.assertEquals(1.6093439983584694E23, resultValue);
    }
}