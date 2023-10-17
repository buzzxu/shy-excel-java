package io.github.buzzxu.shyexcel.annotation;

import java.lang.annotation.*;

/**
 * @author xux
 *  2023年10月14日 11:47:02
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface Sheet {

    String name() default "Sheet1";

    Header header() default @Header;
    boolean active() default false;

    boolean visible() default false;

    Page page() default @Page;


}
