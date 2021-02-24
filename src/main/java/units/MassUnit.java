package units;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author kuhnke98
 */
@Getter
@AllArgsConstructor
public enum MassUnit implements Unitizer {

    CARAT("ct", 1000d),
    MILLIGRAM("mg", 1000d),
    GRAM("g", 1000d),
    KILOGRAM("kg", 1000d);

    private String unit;
    private Double multiplier;
}