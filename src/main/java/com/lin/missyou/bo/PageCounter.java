package com.lin.missyou.bo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName: com.lin.missyou.bo
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021/6/16
 * @Version: 1.0
 */
@Builder
@Setter
@Getter
public class PageCounter {
    Integer pageNum;
    Integer size;

}
