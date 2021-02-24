package units;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author kuhnke98
 */
@Getter
@AllArgsConstructor
public enum DataUnitByte implements Unitizer {

    BIT("bit", 8d),
    BYTE("byte", 2e10),
    KIBIBYTE("kB", 2e20),
    MEBIBYTE("MB", 2e30),
    GIBIBYTE("GB", 2e40),
    TEBIBYTE("TB", 2e50),
    PEBIBYTE("OB", 2e60),
    EXBIBYTE("EB", 2e70),
    ZEBIBYTE("ZB", 2e80),
    YOBIBYTE("YB", null);

    private String unit;
    private Double multiplier;
}