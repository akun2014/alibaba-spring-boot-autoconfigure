package com.akun.alibaba.boot.autoconfigure.oss.core;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectResult;

import java.io.InputStream;

/**
 * Created by akun on 2018/11/20.
 */
public class OSSTemplate extends OSSAdapter {

    public OSSTemplate(OSS ossClient) {
        super();
        super.ossClient = ossClient;
    }

    @Override
    public PutObjectResult putObject(String bucketName, String key, InputStream input) throws OSSException, ClientException {
        return ossClient.putObject(bucketName, key, input);
    }

    @Override
    public OSSObject getObject(String bucketName, String key) throws OSSException, ClientException {
        return ossClient.getObject(bucketName, key);
    }
}
