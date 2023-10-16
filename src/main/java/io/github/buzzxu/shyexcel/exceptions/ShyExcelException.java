package io.github.buzzxu.shyexcel.exceptions;

/**
 * @author xux
 * @date 2023年10月16日 13:16:59
 */
public class ShyExcelException extends Exception {
    public ShyExcelException(String message) {
        super(message);
    }

    public ShyExcelException(Throwable cause) {
        super(cause);
    }

    public ShyExcelException(String message, Throwable cause) {
        super(message, cause);
    }
}
