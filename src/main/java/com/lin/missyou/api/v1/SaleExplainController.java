package com.lin.missyou.api.v1;

import com.lin.missyou.exception.http.NotFoundExecption;
import com.lin.missyou.model.SaleExplain;
import com.lin.missyou.service.SaleExplainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: SaleExplainController
 * @Author: Mrguo
 * @Description:
 * @Date: 2021/6/2518:41
 * @Version: 1.0
 */
@RequestMapping("sale_explain")
@RestController
public class SaleExplainController {
    @Resource
    private SaleExplainService saleExplainService;


    @GetMapping("/fixed")
    public List<SaleExplain> getFixed() {
        List<SaleExplain> saleExplains = saleExplainService.getSaleExplainFixedList();
        if (saleExplains.isEmpty()) {
            throw new NotFoundExecption(30011);
        }
        return saleExplains;
    }
}
