package units.massUnits;

import lombok.AllArgsConstructor;
import lombok.Getter;
import units.Unitizer;

/**
 * @author kuhnke98
 */
@Getter
@AllArgsConstructor
public enum MassUnit implements Unitizer {

    MILLIGRAM("mg", 10d),
    ZENITGRAM("cg", 10d),
    DECIGRAM("dg", 2d),
    CARAT("cd", 5d),
    GRAM("g", 10d),
    DECAGRAM("dag", 10d),
    HECTOGRAM("hg", 4.5359243),
    POUND("lb", 2.2046223302272),
    KILOGRAM("kg", 1d),
    MILLITONNE("mt", 10d),
    CENTITONNE("ct", 10d),
    DECITONNE("dt", 10d),
    TONNE("t", 10d),
    DECATONNE("dat", 10d),
    HECTATONNE("ht", 10d),
    KILOTONNE("kt", null);

    private final String unit;
    private final Double multiplier;
}