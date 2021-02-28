package units;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author kuhnke98
 */
@Getter
@AllArgsConstructor
public enum SIDataByteUnit implements Unitizer {

    BIT("bit", 8d),
    BYTE("B", 1000d),
    KILOBYTE("kB", 1000d),
    MEGABYTE("MB", 1000d),
    GIGABYTE("GB", 1000d),
    TERABYTE("TB", 1000d),
    PETABYTE("PB", 1000d),
    EXABYTE("EB", 1000d),
    ZETTABYTE("ZB", 1000d),
    YOTTABYTE("YB", null);

    private final String unit;
    private final Double multiplier;
}