package io.github.buzzxu.shyexcel.objects;

import lombok.*;

/**
 * @author xux
 *  2023年10月13日 23:11:15
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageMargins {
    private Float bottom;
    private Float footer;
    private Float header;
    private Float left;
    private Float right;
    private Float top;
    private Boolean horizontally;
    private Boolean vertically;
}
