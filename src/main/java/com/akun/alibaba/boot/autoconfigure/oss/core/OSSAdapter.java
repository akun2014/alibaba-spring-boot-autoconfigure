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
public abstract class OSSAdapter {

    OSS ossClient;

    public abstract PutObjectResult putObject(String bucketName, String key, InputStream input) throws OSSException, ClientException;

    public abstract OSSObject getObject(String bucketName, String key) throws OSSException, ClientException;
}