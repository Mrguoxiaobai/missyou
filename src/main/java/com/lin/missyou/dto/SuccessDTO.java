package com.lin.missyou.dto;

import com.lin.missyou.utils.HttpRequestProxy;
import lombok.*;

/**
 * @ClassName: SuccessDTO
 * @Author: Mrguo
 * @Description:
 * @Date: 2021/6/2518:54
 * @Version: 1.0
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SuccessDTO {
    private Integer code = 0;
    private String message = "ok";
    private String request = HttpRequestProxy.getRequestUrl();
}