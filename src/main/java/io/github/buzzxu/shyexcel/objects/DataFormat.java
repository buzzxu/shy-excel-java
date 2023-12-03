package io.github.buzzxu.shyexcel.objects;

/**
 * @author xux
 *  2023年10月14日 23:44:36
 */
public enum DataFormat {
    JSON("application/json"),
    MESSAGEPACK("application/x-msgpack"),
    PROTOBUF("application/x-protobuf"),
    ;

    private String contentType;

    DataFormat(String contentType) {
        this.contentType = contentType;
    }

    public String contentType() {
        return contentType;
    }
}
