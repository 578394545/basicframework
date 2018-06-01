package com.jingji.insurance.utils;


import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;


/**
 * 封装了采用HttpClient发送HTTP请求的方法
 * @author Soar
 * @date 2018/5/31
 *
 */
public class HttpClientUtil {
    private final static Logger log = LoggerFactory.getLogger(HttpClientUtil.class);

    /**
     * 发送HTTP_GET请求
     *
     * @return 远程主机响应正文
     */
    public static String sendGetRequest(String reqURL) {
        String respContent = "";
        HttpClient httpClient = new DefaultHttpClient();
        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);
        httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 20000);
        HttpGet httpGet = new HttpGet(reqURL);
        try {
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (null != entity) {
                Charset respCharset = ContentType.getOrDefault(entity).getCharset();
                respContent = EntityUtils.toString(entity, respCharset);
                EntityUtils.consume(entity);
            }
            StringBuilder respHeaderDatas = new StringBuilder();
            for (Header header : response.getAllHeaders()) {
                respHeaderDatas.append(header.toString()).append("\r\n");
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return respContent;
    }

    public static byte[] htppGetTobytes(String reqURL) {
        byte[] respContent = null;
        HttpClient httpClient = new DefaultHttpClient();
        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);
        httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 20000);
        HttpGet httpGet = new HttpGet(reqURL);
        try {
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (null != entity) {
                respContent = EntityUtils.toByteArray(entity);
                EntityUtils.consume(entity);
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return respContent;
    }

    /**
     * 发送HTTP_POST请求
     *
     * @param reqURL        请求地址
     * @param reqData       请求参数,若有多个参数则应拼接为param11=value11&22=value22&33=value33的形式
     * @param encodeCharset 编码字符集,编码请求数据时用之,此参数为必填项(不能为""或null)
     * @return 远程主机响应正文
     */
    public static String sendPostRequest(String reqURL, String reqData, String encodeCharset) {

        String reseContent = "";
        HttpClient httpClient = new DefaultHttpClient();
        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);
        httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 20000);
        HttpPost httpPost = new HttpPost(reqURL);
        httpPost.setHeader(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=" + encodeCharset);
        try {
            httpPost.setEntity(new StringEntity(reqData == null ? "" : reqData, encodeCharset));
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (null != entity) {
                reseContent = EntityUtils.toString(entity, ContentType.getOrDefault(entity).getCharset());
                EntityUtils.consume(entity);
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return reseContent;
    }
}