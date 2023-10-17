package io.github.buzzxu.shyexcel.annotation;

import io.github.buzzxu.shyexcel.objects.DataType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xux
 *  2023年10月14日 11:47:32
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {
    String title();

    DataType type() default DataType.STRING;

    boolean merge() default false;

    Font font() default @Font;

    float width()default 0f;

    boolean collection()default false;
}
