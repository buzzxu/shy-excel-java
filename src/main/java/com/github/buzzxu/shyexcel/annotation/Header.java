package com.github.buzzxu.shyexcel.annotation;

import java.lang.annotation.*;

/**
 * @author xux
 * @date 2023年10月14日 11:48:39
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
@Documented
public @interface Header {

    String title() default "";

    int freezeCol() default 0;

    float height() default 0f;

    float titleSize() default 0f;
    float columnSize() default 0f;
    float headerSize() default 0f;

    String fontFamily() default "";

    boolean autoFilter() default false;

}
