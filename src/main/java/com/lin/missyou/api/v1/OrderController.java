package com.lin.missyou.api.v1;

import com.lin.missyou.core.LocalUser;
import com.lin.missyou.core.annotations.ScopeLevel;
import com.lin.missyou.dto.OrderDTO;
import com.lin.missyou.vo.OrderIdVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Order controller.
 *
 * @ClassName: OrderController
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 /6/2117:13
 * @Version: 1.0
 */
@RestController
@RequestMapping("/v1/order")
@Validated
public class OrderController {

    @PostMapping("")
    @ScopeLevel
    public OrderIdVO placeOrder(@RequestBody OrderDTO orderDTO){
        Long uid = LocalUser.getUser().getId();

        return null;
    }

}
