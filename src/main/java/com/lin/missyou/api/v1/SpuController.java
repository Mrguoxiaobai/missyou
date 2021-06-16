package com.lin.missyou.api.v1;

import com.lin.missyou.exception.NotFoundExecption;
import com.lin.missyou.mode.SpuEntity;
import com.lin.missyou.service.SpuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.Positive;
import java.util.Optional;

/**
 * @ClassName: SpuController
 * @Author: Mrguo
 * @Description: spu API 接口
 * @Date: 2021-06-16 15:14
 * @Version: 1.0
 */
@RestController
@RequestMapping("/v1/spu")
public class SpuController {
    @Resource
    private SpuService spuService;
    @GetMapping("/id/{id}/detail")
    public SpuEntity getSpu(@PathVariable @Positive Long id){
        Optional<SpuEntity> spu = spuService.getSpu(id);
        if(!spu.isPresent()){
            throw new NotFoundExecption(30002);
        }
        return spu.get();
    }
}
