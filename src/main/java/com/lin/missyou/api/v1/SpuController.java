package com.lin.missyou.api.v1;

import com.lin.missyou.bo.PageCounter;
import com.lin.missyou.exception.NotFoundExecption;
import com.lin.missyou.mode.SpuEntity;
import com.lin.missyou.service.SpuService;
import com.lin.missyou.utils.CommonUtil;
import com.lin.missyou.vo.PagingDozer;
import com.lin.missyou.vo.SpuSimplifyVO;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Positive;
import java.util.List;
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

    /**
     * 查询一个商品详细信息
     * @param id
     * @return
     */
    @GetMapping("/id/{id}/detail")
    public SpuEntity getSpu(@PathVariable @Positive Long id){
        Optional<SpuEntity> spu = spuService.getSpu(id);
        if(!spu.isPresent()){
            throw new NotFoundExecption(30002);
        }
        return spu.get();
    }
    @GetMapping("/latest")
    public PagingDozer<SpuEntity,SpuSimplifyVO> getLatestSpuList(@RequestParam(defaultValue ="0") @Positive Integer start,
                                            @RequestParam(defaultValue ="10")@Positive Integer count){
        PageCounter pageCounter = CommonUtil.convertToPageParameter(start, count);
        Page<SpuEntity> spus = spuService.getLatestPagingSpu(pageCounter.getPageNum(), pageCounter.getSize());
        PagingDozer<SpuEntity, SpuSimplifyVO> page = new PagingDozer<>(spus, SpuSimplifyVO.class);
        return page;
    }

}
