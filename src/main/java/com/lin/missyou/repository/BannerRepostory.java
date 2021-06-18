package com.lin.missyou.repository;

import com.lin.missyou.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Mrguo
 * @create 2021-06-16 10:55
 */
public interface BannerRepostory extends JpaRepository<Banner,Long> {
    Optional<Banner> findByName(String name);
}
