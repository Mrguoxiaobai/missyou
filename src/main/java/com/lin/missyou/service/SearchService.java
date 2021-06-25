package com.lin.missyou.service;

import com.lin.missyou.model.Spu;
import com.lin.missyou.repository.SpuRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: SearchService
 * @Author: Mrguo
 * @Description:
 * @Date: 2021/6/2518:46
 * @Version: 1.0
 */
@Service
public class SearchService {

    @Resource
    private SpuRepository spuRepository;

    public Page<Spu> search(String q, Integer page, Integer count) {
        Pageable paging = PageRequest.of(page, count);
        String likeQ = "%" +q + "%";
        return spuRepository.findByTitleLikeOrSubtitleLike(likeQ,likeQ, paging);
    }
}
