package com.lin.missyou.core.annotations;

/**
 * @ClassName: com.lin.missyou.core.annotations
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021/6/17
 * @Version: 1.0
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The interface Scope level.
 * @author GM
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ScopeLevel {
    /**
     * Value int.
     *
     * @return the int
     */
    int value() default 4;
}