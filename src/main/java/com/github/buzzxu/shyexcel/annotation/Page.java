package com.github.buzzxu.shyexcel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xux
 * @date 2023年10月14日 11:50:40
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Page {
    Layout layout() default @Layout;
    Margins margins() default @Margins;
}
