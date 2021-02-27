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
    BYTE("byte", 1024d),
    KIBIBYTE("kB", 1024d),
    MEBIBYTE("MB", 1024d),
    GIBIBYTE("GB", 1024d),
    TEBIBYTE("TB", 1024d),
    PEBIBYTE("PB", 1024d),
    EXBIBYTE("EB", 1024d),
    ZEBIBYTE("ZB", 1024d),
    YOBIBYTE("YB", null);

    private final String unit;
    private final Double multiplier;
}