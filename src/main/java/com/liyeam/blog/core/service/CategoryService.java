package com.liyeam.blog.core.service;

import com.liyeam.blog.core.entity.BlogCategory;
import com.liyeam.blog.core.util.PageQueryUtil;
import com.liyeam.blog.core.util.PageResult;

import java.util.List;

/**
 * @author liyeam
 */
public interface CategoryService {

    /**
     * 查询分类的分页数据
     *
     * @param pageUtil
     * @return
     */
    PageResult getBlogCategoryPage(PageQueryUtil pageUtil);

    int getTotalCategories();

    /**
     * 添加分类数据
     *
     * @param categoryName
     * @param categoryIcon
     * @return
     */
    Boolean saveCategory(String categoryName,String categoryIcon);

    Boolean updateCategory(Integer categoryId, String categoryName, String categoryIcon);

    Boolean deleteBatch(Integer[] ids);

    List<BlogCategory> getAllCategories();
}
