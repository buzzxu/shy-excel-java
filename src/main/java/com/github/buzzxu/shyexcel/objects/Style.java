package com.github.buzzxu.shyexcel.objects;

import lombok.*;

/**
 * @author xux
 * @date 2023年10月13日 23:24:16
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Style {
    private Border[] border;
    private Font font;
    private Fill fill;
}
