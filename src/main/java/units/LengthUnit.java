package units;

import lombok.AllArgsConstructor;
import lombok.Getter;

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
    CENTIMETER("cm", 2.54d),
    ZOLL("z", 3.93700787d),
    DECIMETER("dm", 10d),
    METER("m", 1000d),
    KILOMETER("km", 1.609344d),
    MILE("", null);

    private String unit;
    private Double multiplier;
}