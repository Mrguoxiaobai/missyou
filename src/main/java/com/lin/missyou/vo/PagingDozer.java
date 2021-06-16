package com.lin.missyou.vo;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.github.dozermapper.core.inject.DozerBeanContainer;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: com.lin.missyou.vo
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021/6/16
 * @Version: 1.0
 */

public class PagingDozer<T,K> extends Paging{
    public PagingDozer(Page<T> page,Class<K> kClass){
        this.initPageParamters(page);
        List<T> list = page.getContent();
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        List<K> listk = new ArrayList<>();
        list.forEach(t->{
            K vo=mapper.map(t,kClass);
            listk.add(vo);
        });
        this.setItems(listk);
    }
}
