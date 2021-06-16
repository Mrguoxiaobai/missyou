package com.lin.missyou.repository;

import com.lin.missyou.mode.BannerEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Mrguo
 * @create 2021-06-16 10:55
 */
public interface BannerRepostory extends JpaRepository<BannerEntity,Long> {
    Optional<BannerEntity> findByName(String name);
}
