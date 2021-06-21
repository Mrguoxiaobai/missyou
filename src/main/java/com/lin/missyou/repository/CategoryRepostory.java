package com.lin.missyou.repository;

import com.lin.missyou.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Category repostory.
 *
 * @ClassName: CategoryRepostory
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 -06-17 8:12
 * @Version: 1.0
 */
public interface CategoryRepostory extends JpaRepository<Category,Long> {
     /**
      * Find all by is root order by index desc list.
      *
      * @param isRoot the is root
      * @return the list
      */
     public List<Category> findAllByIsRootOrderByIndexDesc(Integer isRoot);
}
