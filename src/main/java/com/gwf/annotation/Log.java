package com.gwf.annotation;

import java.lang.annotation.*;

/**
 * Created by gaowenfeng on 2017/3/31.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    String name();
}
