package com.lin.missyou.api.v1;

import com.lin.missyou.model.Sku;
import com.lin.missyou.service.SkuService;
import com.lin.missyou.service.SpuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: SkuController
 * @Author: Mrguo
 * @Description:
 * @Date: 2021/6/2518:49
 * @Version: 1.0
 */
@RequestMapping("sku")
@RestController
public class SkuController {
    @Resource
    private SkuService skuService;

    @Resource
    private SpuService spuService;

    @GetMapping("")
    public List<Sku> getSkuListInIds(@RequestParam(name = "ids", required = false) String ids) {
        if(ids==null || ids.isEmpty()){
            return Collections.emptyList();
        }
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(s -> Long.parseLong(s.trim()))
                .collect(Collectors.toList());
        List<Sku> skus = skuService.getSkuListByIds(idList);
        return skus;
    }
}
