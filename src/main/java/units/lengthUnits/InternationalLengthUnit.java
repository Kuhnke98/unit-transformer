package units.lengthUnits;

import lombok.AllArgsConstructor;
import lombok.Getter;
import units.Unitizer;

/**
 * @author kuhnke98
 */
@Getter
@AllArgsConstructor
public enum InternationalLengthUnit implements Unitizer {

    INCH("ín", 12d),
    FOOT("ft", 3d),
    YARD("yd", 1760d),
    MILE("mi", null);

    private final String unit;
    private final Double multiplier;
}