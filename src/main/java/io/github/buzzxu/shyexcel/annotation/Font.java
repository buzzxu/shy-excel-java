package io.github.buzzxu.shyexcel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xux
 *  2023年10月14日 11:47:57
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Font {

    boolean bold() default false;
    boolean italic() default false;

    String underline() default "";

    String family() default "";

    float size() default 0f;

    boolean strike() default false;

    String color() default "";

    int colorIndexed() default 0;

    int colorTheme() default 0;

    float colorTint() default 0f;

    String vertAlign() default "";
}
