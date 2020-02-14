package com.njwb.config;

import org.springframework.context.annotation.Bean;
import com.github.pagehelper.PageHelper;
import java.util.Properties;

public class PageHelperConfig {
	@Bean//加上该注解spring容器自动配置
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("dialect","mysql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
