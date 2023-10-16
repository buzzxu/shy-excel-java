package io.github.buzzxu.shyexcel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xux
 * @date 2023年10月14日 23:20:44
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Style {

    Border[] border() default {};
    Font font() default @Font;
    Fill fill() default @Fill;

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.ANNOTATION_TYPE)
    public @interface Border {
        String type() default "";
        String color() default "";
        int style() default 0;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.ANNOTATION_TYPE)
    public @interface Fill {
        String type() default "";
        String pattern() default "";
        String color() default "";
        int style() default 0;
    }
}
