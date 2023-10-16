package com.github.buzzxu.shyexcel.objects;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author xux
 * @date 2023年10月13日 23:17:50
 */
public enum DataType {
    INDEX("index"),
    STRING("string"),
    NUMERIC("numeric"),
    DATETIME("datetime"),
    BOOL("bool"),
    HYPERLINK("hyperLink"),
    IMAGE("image"),
    ;

    private final String type;

    DataType(String type) {
        this.type = type;
    }

    @JsonValue
    public String type() {
        return type;
    }
}
