package com.lin.missyou.api.v1;

import com.lin.missyou.bo.PageCounter;
import com.lin.missyou.core.LocalUser;
import com.lin.missyou.core.annotations.ScopeLevel;
import com.lin.missyou.dto.OrderDTO;
import com.lin.missyou.exception.http.NotFoundExecption;
import com.lin.missyou.logic.OrderChecker;
import com.lin.missyou.model.Order;
import com.lin.missyou.service.OrderService;
import com.lin.missyou.utils.CommonUtil;
import com.lin.missyou.vo.OrderIdVO;
import com.lin.missyou.vo.OrderPureVO;
import com.lin.missyou.vo.OrderSimplifyVO;
import com.lin.missyou.vo.PagingDozer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

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

    @Value("${missyou.order.pay-time-limit}")
    private Long payTimeLimit;
    @Resource
    private OrderService orderService;
    @PostMapping("")
    @ScopeLevel
    public OrderIdVO placeOrder(@RequestBody OrderDTO orderDTO){
        Long uid = LocalUser.getUser().getId();
        OrderChecker orderChecker = orderService.isOK(uid, orderDTO);
        Long oid= orderService.placeOrder(uid,orderDTO,orderChecker);
        return new OrderIdVO(oid);
    }
    @GetMapping("by/status/{status}")
    @ScopeLevel
    public PagingDozer getByStatus(@PathVariable Integer status,
                                   @RequestParam(defaultValue ="0")  Integer start,
                                   @RequestParam(defaultValue ="10") Integer count){
        PageCounter page = CommonUtil.convertToPageParameter(start, count);
        Page<Order> paging=this.orderService.getByStatus(status,page.getPageNum(),page.getSize());
        PagingDozer<Order, OrderSimplifyVO> pagingDozer = new PagingDozer<>(paging, OrderSimplifyVO.class);
        pagingDozer.getItems().forEach(o->((OrderSimplifyVO)o).setPeriod(this.payTimeLimit));
        return pagingDozer;
    }
    @GetMapping("/status/unpaid")
    @ScopeLevel
    public  PagingDozer getUnpaid(@RequestParam(defaultValue ="0")  Integer start,
                                  @RequestParam(defaultValue ="10") Integer count){
        PageCounter page = CommonUtil.convertToPageParameter(start, count);
       Page<Order> orderPage= this.orderService.getUnpaid(page.getPageNum(),page.getSize());
        PagingDozer pagingDozer = new PagingDozer<>(orderPage, OrderSimplifyVO.class);
        pagingDozer.getItems().forEach((o) -> ((OrderSimplifyVO) o).setPeriod(this.payTimeLimit));
        return pagingDozer;
    }
    @ScopeLevel
    @GetMapping("/detail/{id}")
    public OrderPureVO getOrderDetail(@PathVariable(name = "id") Long oid) {
        Optional<Order> orderOptional = this.orderService.getOrderDetail(oid);
        return orderOptional.map((o) -> new OrderPureVO(o, payTimeLimit))
                .orElseThrow(() -> new NotFoundExecption(50009));
    }


}
