package io.github.buzzxu.shyexcel.objects;

import lombok.*;

/**
 * @author xux
 *  2023年10月13日 23:16:13
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Column {
    private String name;
    private String title;
    private DataType type;
    private Boolean merge;
    private Font font;
    private Float width;
    private Column[] columns;
}
