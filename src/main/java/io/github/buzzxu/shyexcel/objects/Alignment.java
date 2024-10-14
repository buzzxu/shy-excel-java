package io.github.buzzxu.shyexcel.objects;

import lombok.Getter;
import lombok.Setter;

/**
 * @author xux
 * 2024年10月13日 18:35:58
 */
@Getter @Setter
public class Alignment {

    private boolean wrap;
    private String vertical;
    private String horizontal;
    private int indent;
    private int rotation;
    private boolean justifyLastLine;
    private boolean shrinkToFit;
}
