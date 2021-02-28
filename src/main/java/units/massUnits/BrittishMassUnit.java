package units.massUnits;

import lombok.AllArgsConstructor;
import lombok.Getter;
import units.Unitizer;

/**
 * @author kuhnke98
 */
@Getter
@AllArgsConstructor
public enum BrittishMassUnit implements Unitizer {

    UNZE("oz", 16.000002116438),
    POUND("lb", 13.999998148117),
    STONE("st",  2.0000002582558),
    QUARTER("qtr",  3.9999994834885),
    ZENTNER("cwt",  null);

    private final String unit;
    private final Double multiplier;
}