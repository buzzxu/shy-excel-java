package io.github.buzzxu.shyexcel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xux
 * @date 2024年10月13日 18:32:38
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Alignment {

    boolean wrap() default false;
    String vertical() default "";
    String horizontal() default "";
    int indent() default 0;
    int rotation() default 0;
    boolean justifyLastLine() default false;
    boolean shrinkToFit() default false;
}
