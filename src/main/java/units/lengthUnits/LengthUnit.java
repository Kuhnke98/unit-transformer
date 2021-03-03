package units.lengthUnits;

import lombok.AllArgsConstructor;
import lombok.Getter;
import units.Unitizer;

/**
 * @author kuhnke98
 */
@Getter
@AllArgsConstructor
public enum LengthUnit implements Unitizer {

    ATTOMETER("am", 1000d),
    FEMTOMETER("fm", 1000d),
    PICOMETER("pm", 1000d),
    NANOMETER("nm", 1000d),
    MICROMETER("µm", 1000d),
    MILLIMETER("mm", 10d),
    CENTIMETER("cm", 10d),
    DECIMETER("dm", 10d),
    METER("m", 1000d),
    KILOMETER("km", 1.609347219),
    MILE("mi", 621.36994937697),
    MEGAMETER("Mm", 1000d),
    GIGAMETER("Gm", null);

    private final String unit;
    private final Double multiplier;
}