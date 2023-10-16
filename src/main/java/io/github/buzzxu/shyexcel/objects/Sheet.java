package io.github.buzzxu.shyexcel.objects;

import lombok.*;

import java.util.List;

/**
 * @author xux
 * @date 2023年10月13日 22:26:03
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sheet<T> {
    private String name;
    private Header header;
    private Boolean active;
    private Boolean visible;
    private PageLayout layout;
    private PageMargins margins;
    private List<T> data;
}
