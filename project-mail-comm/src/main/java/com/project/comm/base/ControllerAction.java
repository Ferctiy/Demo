package com.project.comm.base;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 路由控制
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ControllerAction {

    /**
     * 路由
     *
     * @return
     */
    @AliasFor("value")
    String route() default "";

    /**
     * 路由
     *
     * @return
     */
    @AliasFor("route")
    String value() default "";
}
