import units.DataUnitBit;
import units.DataUnitByte;
import units.LengthUnit;

public class Main {

    public static void main(String[] args) {

//        System.out.println(UnitTransformer.transform(1, DataUnitBit.BIT, DataUnitByte.BYTE, "#.##"));
//        System.out.println(UnitTransformer.transform(1000, DataUnitBit.BIT, DataUnitByte.BYTE));
//        System.out.println(UnitTransformer.transform(1, LengthUnit.MILLIMETER, LengthUnit.MICROMETER));

        System.out.println(UnitTransformer.transform(1, LengthUnit.ZOLL, LengthUnit.CENTIMETER));
        System.out.println(UnitTransformer.transform(1, LengthUnit.DECIMETER, LengthUnit.ZOLL));
        System.out.println(UnitTransformer.transform(1, LengthUnit.DECIMETER, LengthUnit.CENTIMETER));
        System.out.println(UnitTransformer.transform(1, LengthUnit.ZOLL, LengthUnit.DECIMETER));


//        Calculator calculator4 = new Calculator();
//        double test = calculator4.convert(50, DataUnitBit.TERABYTE, DataUnitBit.BIT);
//        System.out.println(test);
//
//        Calculator calculator3 = new Calculator();
//        double convert = calculator3.convert(test, DataUnitByte.BIT, DataUnitByte.TEBIBYTE);
//        System.out.println(convert);
//
//        Calculator calculator6 = new Calculator();
//        double convert6 = calculator6.convert(convert, DataUnitByte.TEBIBYTE, DataUnitByte.BIT);
//        System.out.println(convert6);
//
//        Calculator calculator5 = new Calculator();
//        System.out.println(calculator5.convert(convert6, DataUnitBit.BIT, DataUnitBit.TERABYTE));


    }
}