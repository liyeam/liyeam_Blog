package com.liyeam.blog.core.dao;

import com.liyeam.blog.core.entity.BlogConfig;

import java.util.List;

/**
 * @author liyeam
 */
public interface BlogConfigMapper {
    List<BlogConfig> selectAll();

    BlogConfig selectByPrimaryKey(String configName);

    int updateByPrimaryKeySelective(BlogConfig record);

}