package com.liyeam.blog.core.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author liyeam
 */
@ToString
@Data
public class BlogTagRelation {
    private Long relationId;

    private Long blogId;

    private Integer tagId;

    private Date createTime;
}