package com.lin.missyou.service;

import com.lin.missyou.model.SaleExplain;
import com.lin.missyou.repository.SaleExplainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: SaleExplainService
 * @Author: Mrguo
 * @Description:
 * @Date: 2021/6/2518:42
 * @Version: 1.0
 */
@Service
public class SaleExplainService {
    @Resource
    private SaleExplainRepository saleExplainRepository;

    public List<SaleExplain> getSaleExplainFixedList() {
        return this.saleExplainRepository.findByFixedOrderByIndex(true);
    }
}
