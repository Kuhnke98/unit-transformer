package units;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author kuhnke98
 */
@Getter
@AllArgsConstructor
public enum DataUnitBit implements Unitizer {

    BIT("bit", 1e3),
    KILOBYTE("kB", 1e3),
    MEGABYTE("MB", 1e3),
    GIGABYTE("GB", 1e3),
    TERABYTE("TB", 1e3),
    PETABYTE("OB", 1e3),
    EXABYTE("EB", 1e3),
    ZETTABYTE("ZB", 1e3),
    YOTTABYTE("YB", null);

    private final String unit;
    private final Double multiplier;
}