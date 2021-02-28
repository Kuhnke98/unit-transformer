package units;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author kuhnke98
 */
@Getter
@AllArgsConstructor
public enum DataBinaryUnit implements Unitizer {

    BIT("bit", 1024d),
    KIBIBIT("kibit", 1024d),
    MEBIBIT("Mibit", 1024d),
    GIBIBIT("Gibit", 1024d),
    TEBIBIT("Tibit", 1024d),
    PEBIBIT("Pibit", 1024d),
    EXBIBIT("Eibit", 1024d),
    ZEBIBIT("Zibit", 1024d),
    YOBIBIT("Yibit", null);

    private final String unit;
    private final Double multiplier;
}