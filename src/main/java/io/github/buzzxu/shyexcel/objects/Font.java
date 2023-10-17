package io.github.buzzxu.shyexcel.objects;

import lombok.*;

/**
 * @author xux
 *  2023年10月13日 23:20:40
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Font {
    private Boolean bold;
    private Boolean italic;
    private String underline;
    private String family;
    private Float size;
    private Boolean strike;
    private String color;
    private Integer colorIndexed;
    private Integer colorTheme;
    private Float colorTint;
    private String vertAlign;
}
