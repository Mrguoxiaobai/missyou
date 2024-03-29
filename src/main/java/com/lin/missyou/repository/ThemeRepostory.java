package com.lin.missyou.repository;

import com.lin.missyou.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * The interface Theme repostory.
 *
 * @ClassName: ThemeRepostory
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 -06-17 9:32
 * @Version: 1.0
 */
public interface ThemeRepostory extends JpaRepository<Theme,Long> {
    /**
     * Find by names list.
     *
     * @param names the names
     * @return the list
     */
    @Query("select t from Theme t where t.name in (:names)")
    List<Theme> findByNames(List<String> names);

    /**
     * Find by name optional.
     *
     * @param name the name
     * @return the optional
     */
    Optional<Theme> findByName(String name);
}
