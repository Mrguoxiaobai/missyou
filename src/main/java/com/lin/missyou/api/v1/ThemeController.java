package com.lin.missyou.api.v1;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.lin.missyou.exception.http.NotFoundExecption;
import com.lin.missyou.model.Theme;
import com.lin.missyou.service.ThemeService;
import com.lin.missyou.vo.ThemePureVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * The type Theme controller.
 *
 * @ClassName: ThemeController
 * @Author: Mrguo
 * @Description: theme api
 * @Date: 2021 -06-17 7:30
 * @Version: 1.0
 */
@RestController
@RequestMapping("/v1/theme")
public class ThemeController {
    @Resource
    private ThemeService themeService;

    /**
     * Get theme group by names list.
     *
     * @param names the names
     * @return the list
     */
    @GetMapping("/by/names")
    public List<ThemePureVO> getThemeGroupByNames(@RequestParam String names){
        List<String> list = Arrays.asList(names.split(","));
        List<Theme> themes = themeService.getByNames(list);
        List<ThemePureVO> vos = new ArrayList<>();
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        themes.forEach(t->{
            ThemePureVO pureVO = mapper.map(t, ThemePureVO.class);
            vos.add(pureVO);
        });
        return vos;
    }

    /**
     * Get theme by name with spu theme.
     *
     * @param name the name
     * @return the theme
     */
    @GetMapping("/name/{name}/with_spu")
    public Theme getThemeByNameWithSpu(@PathVariable String name){
        Optional<Theme> theme = themeService.getByName(name);
        return theme.orElseThrow(()->new NotFoundExecption(30003));
    }


}
