package com.lin.missyou.api.v1;

import com.lin.missyou.exception.NotFoundExecption;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/banner")
public class BannerController {
    @GetMapping("banner")
    public String test() throws Exception{
       throw  new NotFoundExecption(10001);
        /*return "test";*/
    }
}
