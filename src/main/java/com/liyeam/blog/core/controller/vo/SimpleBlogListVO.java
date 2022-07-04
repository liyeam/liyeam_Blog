package com.liyeam.blog.core.controller.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liyeam
 */
@Data
public class SimpleBlogListVO implements Serializable {

    private Long blogId;

    private String blogTitle;

}
