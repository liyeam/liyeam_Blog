package com.liyeam.blog.core.service.impl;

import com.liyeam.blog.core.dao.BlogConfigMapper;
import com.liyeam.blog.core.service.ConfigService;
import com.liyeam.blog.core.entity.BlogConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liyeam
 */
@Service
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    private BlogConfigMapper configMapper;

    public static final String WEBSITE_NAME = "personal blog";
    public static final String WEBSITE_DESCRIPTION = "liyeam blog是SpringBoot2+Thymeleaf+Mybatis建造的个人博客网站";
    public static final String WEBSITE_LOGO = "/admin/dist/img/logo2.png";
    public static final String WEBSITE_ICON = "/admin/dist/img/favicon.png";

    public static final String YOUR_AVATAR = "/admin/dist/img/liyeam.png";
    public static final String YOUR_EMAIL = "liyeam@163.com";
    public static final String YOUR_NAME = "小绵羊";

    public static final String FOOTER_ABOUT = "your personal blog. have fun.";
    public static final String FOOTER_ICP = "粤ICP备 xxxxxx-x号";
    public static final String FOOTER_COPY_RIGHT = "@2021 小绵羊";
    public static final String FOOTER_POWERED_BY = "personal blog";
    public static final String FOOTER_POWERED_BY_URL = "##";

    @Override
    public int updateConfig(String configName, String configValue) {
        BlogConfig blogConfig = configMapper.selectByPrimaryKey(configName);
        if (blogConfig != null) {
            blogConfig.setConfigValue(configValue);
            blogConfig.setUpdateTime(new Date());
            return configMapper.updateByPrimaryKeySelective(blogConfig);
        }
        return 0;
    }

    @Override
    public Map<String, String> getAllConfigs() {
        //获取所有的map并封装为map
        List<BlogConfig> blogConfigs = configMapper.selectAll();
        Map<String, String> configMap = blogConfigs.stream().collect(Collectors.toMap(BlogConfig::getConfigName, BlogConfig::getConfigValue));
        for (Map.Entry<String, String> config : configMap.entrySet()) {
            if ("websiteName".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(WEBSITE_NAME);
            }
            if ("websiteDescription".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(WEBSITE_DESCRIPTION);
            }
            if ("websiteLogo".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(WEBSITE_LOGO);
            }
            if ("websiteIcon".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(WEBSITE_ICON);
            }
            if ("yourAvatar".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(YOUR_AVATAR);
            }
            if ("yourEmail".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(YOUR_EMAIL);
            }
            if ("yourName".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(YOUR_NAME);
            }
            if ("footerAbout".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(FOOTER_ABOUT);
            }
            if ("footerICP".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(FOOTER_ICP);
            }
            if ("footerCopyRight".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(FOOTER_COPY_RIGHT);
            }
            if ("footerPoweredBy".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(FOOTER_POWERED_BY);
            }
            if ("footerPoweredByURL".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(FOOTER_POWERED_BY_URL);
            }
        }
        return configMap;
    }
}
