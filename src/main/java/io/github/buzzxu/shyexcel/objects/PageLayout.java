package io.github.buzzxu.shyexcel.objects;

import lombok.*;

/**
 * @author xux
 *  2023年10月13日 23:09:03
 */
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class PageLayout {
    private Integer size;
    private String orientation;

    private Integer firstPageNumber;
    private Integer adjustTo;

    private Integer fitToHeight;
    private Integer fitToWidth;

    private Boolean blackAndWhite;

    public static PageLayout NULL = new PageLayout();
}
