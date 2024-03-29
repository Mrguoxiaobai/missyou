package com.lin.missyou.api.v1;

import com.lin.missyou.exception.http.NotFoundExecption;
import com.lin.missyou.model.Banner;
import com.lin.missyou.service.BannerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

/**
 * The type Banner controller.
 * @author Administrator
 */
@RestController
@RequestMapping("/v1/banner")
public class BannerController {
    @Resource
    private BannerService bannerService;

    /**
     * Gets banner
     * @param name the name
     * @return the banner
     */
    @GetMapping("/name/{name}")
    public Banner getBanner(@PathVariable @NotBlank String name) {
        Optional<Banner> banner = bannerService.getByName(name);
        return banner.orElseThrow(()->new NotFoundExecption(30005));
    }
}
