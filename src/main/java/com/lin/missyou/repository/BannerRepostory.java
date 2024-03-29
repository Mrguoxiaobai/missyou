package com.lin.missyou.repository;

import com.lin.missyou.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The interface Banner repostory.
 *
 * @author Mrguo
 * @create 2021 -06-16 10:55
 */
public interface BannerRepostory extends JpaRepository<Banner,Long> {
    /**
     * Find by name optional.
     *
     * @param name the name
     * @return the optional
     */
    Optional<Banner> findByName(String name);
}
