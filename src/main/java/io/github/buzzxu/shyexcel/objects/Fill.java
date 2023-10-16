package io.github.buzzxu.shyexcel.objects;

import lombok.*;

/**
 * @author xux
 * @date 2023年10月13日 23:25:01
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Fill {
    private String type;
    private String pattern;
    private String[] color;
    private Integer shading;
}
