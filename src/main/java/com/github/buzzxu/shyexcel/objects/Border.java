package com.github.buzzxu.shyexcel.objects;

import lombok.*;

/**
 * @author xux
 * @date 2023年10月13日 23:24:32
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Border {
    private String type;
    private String color;
    private Integer style;
}
