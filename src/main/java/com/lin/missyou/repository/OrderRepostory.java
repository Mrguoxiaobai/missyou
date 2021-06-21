package com.lin.missyou.repository;

import com.lin.missyou.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Order repostory.
 *
 * @ClassName: OrderRepostory
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 /6/2117:17
 * @Version: 1.0
 */
public interface OrderRepostory extends JpaRepository<Order,Long> {
}
