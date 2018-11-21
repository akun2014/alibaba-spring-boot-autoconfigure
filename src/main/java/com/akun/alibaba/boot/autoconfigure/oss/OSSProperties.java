package com.akun.alibaba.boot.autoconfigure.oss;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by akun on 2018/11/11.
 */
@Data
@ConfigurationProperties(prefix = "aliyun.ram.oss")
public class OSSProperties {
    private String accessKeyId;

    private String accessKeySecret;

    private int maxConnections = 200;

    private long readTimeOut = 6;

    private String endpoint;

    private String bucketName;
}
