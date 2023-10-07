package com.ioiox.dei.duc.admin.cfg.cors;

import com.ioiox.dei.core.utils.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DUCCorsConfig implements WebMvcConfigurer {
    private static final Logger log = LoggerFactory.getLogger(DUCCorsConfig.class);

    @Value("${com.ioiox.dei.duc.admin.allow-credentials:false}")
    private boolean allowCredentials;

    @Value("${com.ioiox.dei.duc.admin.allowed-origins:}")
    private String allowedOrigins;

    @Value("${com.ioiox.dei.duc.admin.allowed-methods:}")
    private String allowedMethods;

    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        final String [] allowedOrigins =
                StringUtils.isBlank(this.allowedOrigins) ? new String [] {"*"} : StringUtils.split(this.allowedOrigins, ",");
        final String [] allowedMethods =
                StringUtils.isBlank(this.allowedMethods) ? new String [] {"*"} : StringUtils.split(this.allowedMethods, ",");
        if (log.isInfoEnabled()) {
            log.info(String.format("prepare to config CORS =====> allowCredentials: %s, allowedOrigins: %s, allowedMethods: %s",
                    allowCredentials, JsonUtil.toJsonStr(allowedOrigins), JsonUtil.toJsonStr(allowedMethods)));
        }
        registry.addMapping("/**")
                .allowCredentials(allowCredentials)
                .allowedOrigins(allowedOrigins)
                .allowedMethods(allowedMethods)
                .allowedHeaders("*")
                .exposedHeaders("*");
    }
}
