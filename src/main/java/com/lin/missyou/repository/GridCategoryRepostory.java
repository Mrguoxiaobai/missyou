package com.lin.missyou.repository;

import com.lin.missyou.model.GridCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Grid category repostory.
 *
 * @ClassName: GridCategoryRepostory
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 -06-17 8:54
 * @Version: 1.0
 */
public interface GridCategoryRepostory extends JpaRepository<GridCategory,Long> {
}
