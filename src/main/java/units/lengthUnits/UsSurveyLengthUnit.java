package units.lengthUnits;

import lombok.AllArgsConstructor;
import lombok.Getter;
import units.Unitizer;

/**
 * @author kuhnke98
 */
@Getter
@AllArgsConstructor
public enum UsSurveyLengthUnit implements Unitizer {

    LINK("li", 1.5151545454545d),
    FOOT("ft", 16.499999808399),
    ROD("rd", 3.9999920464646),
    CHAIN("ch", 10.000019883878),
    FURLONG("fur", 8.0000000944482),
    MILE("mi", 3.0000002131299),
    LEAGUE("lea", null);

    private final String unit;
    private final Double multiplier;
}