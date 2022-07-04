package com.liyeam.blog.core.service;

import com.liyeam.blog.core.entity.BlogTagCount;
import com.liyeam.blog.core.util.PageQueryUtil;
import com.liyeam.blog.core.util.PageResult;

import java.util.List;

/**
 * @author liyeam
 */
public interface TagService {

    /**
     * 查询标签的分页数据
     *
     * @param pageUtil
     * @return
     */
    PageResult getBlogTagPage(PageQueryUtil pageUtil);

    int getTotalTags();

    Boolean saveTag(String tagName);

    Boolean deleteBatch(Integer[] ids);

    List<BlogTagCount> getBlogTagCountForIndex();
}
