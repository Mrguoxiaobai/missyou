package com.lin.missyou.api.v1;

import com.lin.missyou.exception.NotFoundExecption;
import com.lin.missyou.mode.Banner;
import com.lin.missyou.service.BannerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

@RestController
@RequestMapping("/v1/banner")
public class BannerController {
    @Resource
    private BannerService bannerService;
    @GetMapping("banner/{name}")
    public Banner getBanner(@PathVariable @NotBlank String name) {
        Optional<Banner> banner = bannerService.getByName(name);
        if(!banner.isPresent()){
            throw new NotFoundExecption(30005);
        }
        return banner.get();
    }
}
