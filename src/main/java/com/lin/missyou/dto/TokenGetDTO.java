package com.lin.missyou.dto;

import com.lin.missyou.core.enumeration.LoginType;
import com.lin.missyou.dto.validators.TokenPassword;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;


/**
 * The type Token get dto.
 *
 * @ClassName: TokenGetDTO
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 -06-17 10:56
 * @Version: 1.0
 */
@Getter
@Setter
public class TokenGetDTO {
    @NotBlank(message = "account不允许为空")
    private String account;
    @TokenPassword(max=30,message="{token.password}")
    private String password;

    private LoginType loginType;
}
