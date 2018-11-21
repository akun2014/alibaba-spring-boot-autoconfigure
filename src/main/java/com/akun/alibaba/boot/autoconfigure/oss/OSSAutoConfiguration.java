package com.akun.alibaba.boot.autoconfigure.oss;

import com.akun.alibaba.boot.autoconfigure.annotation.EnableOSSConfiguration;
import com.akun.alibaba.boot.autoconfigure.oss.core.OSSTemplate;
import com.aliyun.oss.OSSClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

/**
 * Created by akun on 2018/11/11.
 */
@Configuration
@ConditionalOnClass(OSSClient.class)
@EnableConfigurationProperties(OSSProperties.class)
@ConditionalOnBean(annotation = EnableOSSConfiguration.class)
@Slf4j
public class OSSAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public OSSTemplate ossTemplate(OSSProperties ossProperties) {
        log.info("======== ossTemplate init bucketName:{} with accessKeyId:{} ============", ossProperties.getBucketName(), ossProperties.getAccessKeyId());
        OSSClient ossClient = createOssClient(ossProperties);
        URI endpoint = ossClient.getEndpoint();
        OSSTemplate ossTemplate = new OSSTemplate(ossClient);
        log.info("======== ossTemplate init finished endpoint:{} ============", endpoint.toString());
        return ossTemplate;
    }

    private OSSClient createOssClient(OSSProperties ossProperties) {
        String endpoint = ossProperties.getEndpoint();
        String accessKeyId = ossProperties.getAccessKeyId();
        String accessKeySecret = ossProperties.getAccessKeySecret();

        return new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }
}
