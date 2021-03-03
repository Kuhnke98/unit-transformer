package units.lengthUnits;

import lombok.AllArgsConstructor;
import lombok.Getter;
import units.Unitizer;

/**
 * @author kuhnke98
 */
@Getter
@AllArgsConstructor
public enum AstronomicalLengthUnit implements Unitizer {

    MILE("mi", 92955621.343762),
    ASTRONOMICAL_UNIT("au", 206264.80621425),
    PARSEC("pc", 0.30661012862316),
    LIGHT_YEAR("ly", null);

    private final String unit;
    private final Double multiplier;
}