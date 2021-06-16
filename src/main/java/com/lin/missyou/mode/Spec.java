package com.lin.missyou.mode;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName: com.lin.missyou.mode
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021/6/16
 * @Version: 1.0
 */
@Getter
@Setter
public class Spec {
    @JsonProperty("key_id")
    private Long keyId;
    private String key;
    @JsonProperty("value_id")
    private Long valueId;
    private String value;
}
