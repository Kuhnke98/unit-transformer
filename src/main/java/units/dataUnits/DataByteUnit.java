package units.dataUnits;

import lombok.AllArgsConstructor;
import lombok.Getter;
import units.Unitizer;

/**
 * @author kuhnke98
 */
@Getter
@AllArgsConstructor
public enum DataByteUnit implements Unitizer {

    BIT("bit", 8d),
    BYTE("B", 1024d),
    KIBIBYTE("KiB", 1024d),
    MEBIBYTE("MiB", 1024d),
    GIBIBYTE("GiB", 1024d),
    TEBIBYTE("TiB", 1024d),
    PEBIBYTE("PiB", 1024d),
    EXBIBYTE("EiB", 1024d),
    ZEBIBYTE("ZiB", 1024d),
    YOBIBYTE("YiB", null);

    private final String unit;
    private final Double multiplier;
}