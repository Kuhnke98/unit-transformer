package units.dataUnits;

import lombok.AllArgsConstructor;
import lombok.Getter;
import units.Unitizer;

/**
 * @author kuhnke98
 */
@Getter
@AllArgsConstructor
public enum SIDataBinaryUnit implements Unitizer {

    BIT("bit", 1000d),
    KILOBIT("kbit", 1000d),
    MEGABIT("Mbit", 1000d),
    GIGABIT("Gbit", 1000d),
    TERABIT("Tbit", 1000d),
    PETABIT("Pbit", 1000d),
    EXABIT("Ebit", 1000d),
    ZETTABIT("Zbit", 1000d),
    YOTTABIT("Ybit", null);

    private final String unit;
    private final Double multiplier;
}