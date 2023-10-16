package com.github.buzzxu.shyexcel.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

/**
 * @author xux
 * @date 2023年10月13日 23:08:02
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Header {
    private String title;
    private int freezeCol;
    private Column[] columns;
    private Float height;
    private Style style;
    @JsonProperty("font_title_size")
    private Float titleSize;
    @JsonProperty("font_column_size")
    private Float columnSize;
    @JsonProperty("font_header_size")
    private Float headerSize;
    @JsonProperty("font_family")
    private String fontFamily;
    @JsonProperty("auto_filter")
    private Boolean autoFilter;
}
