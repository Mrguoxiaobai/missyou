package com.lin.missyou.dto.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @ClassName: TokenPassword
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-17 11:11
 * @Version: 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Constraint(validatedBy = TokenPasswordValidator.class)
public @interface TokenPassword {
    String message() default "字段不符合要求";
    int min() default 6;

    int max() default 32;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
