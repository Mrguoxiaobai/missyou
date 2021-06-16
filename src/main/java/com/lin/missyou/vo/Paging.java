package com.lin.missyou.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @ClassName: com.lin.missyou.vo
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021/6/16
 * @Version: 1.0
 */
@Setter
@Getter
@NoArgsConstructor
public class Paging <T>{
    private Long total;
    private Integer count;
    private Integer page;
    private Integer countPage;
    private List<T> items;
    public Paging(Page<T> page) {
        this.initPageParamters(page);
        this.items=page.getContent();
    }

    public void initPageParamters(Page<T> page){
         this.total=page.getTotalElements();
         this.count=page.getSize();
         this.page=page.getNumber();
         this.countPage=page.getTotalPages();
    }
}
