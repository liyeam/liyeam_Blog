package com.liyeam.blog.core.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author liyeam
 */
@Data
@ToString
public class BlogTagCount {
    private Integer tagId;

    private String tagName;

    private Integer tagCount;
}
