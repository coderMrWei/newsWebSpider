package com.merphy.common;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * httpclientUtils httpClient 处理类
 */
public class HttpClientUtil {

    //创建httpClient实例
    private static CloseableHttpClient httpClient = null;//HttpClients.createDefault();

    //创建LOG
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtil.class);

    //连接池管理器
    private static PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = null;

    private static RequestConfig requestConfig = null;

    static {
        //request请求配置
        requestConfig = RequestConfig.custom()
                                     .setSocketTimeout(5000)//读超时时间
                                     .setConnectTimeout(5000) //连接超时时间
                                     .setConnectionRequestTimeout(5000)//从连接池获取连接超时时间
                                     .build();
        //创建连接管理器，使用默认构造
        poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
        //设置最大连接数
        poolingHttpClientConnectionManager.setMaxTotal(10);
        //设置每个路由的最大连接数
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(5);
        //poolingHttpClientConnectionManager.setD
        //poolingHttpClientConnectionManager.setMaxPerRoute();
        httpClient = HttpClients.custom().setConnectionManager(poolingHttpClientConnectionManager).setDefaultRequestConfig(requestConfig)
                //.setProxy();
                .build();
    }


    //创建具体http实现方法
    private static String httpExecute(HttpUriRequest request,String charset) throws IOException{
        HttpEntity entity = null;
        try {
            HttpResponse response = httpClient.execute(request);
            StatusLine status = response.getStatusLine();
            entity = response.getEntity();
            if (status.getStatusCode() == HttpStatus.SC_OK) {//return 200
                String content = toString(entity, charset);
                entity = null;
                return content;
            } else {//非 200
                LOGGER.error("call httpClient fail,http code:{}",status.getStatusCode());
            }
        }finally {
            EntityUtils.consume(entity);
        }
        return null;
    }

    //处理Get请求
    public static String doGet(String url,Map<String,String> param) {
        try{
            StringBuilder sb = new StringBuilder();
            if(MapUtils.isNotEmpty(param)) {
                for (Map.Entry<String, String> entry : param.entrySet()) {
                    sb.append(entry.getKey() + "=" + entry.getValue() + "&");
                }
            }
            if (sb.toString().endsWith("&")) {
                sb.deleteCharAt(sb.length()-1);
            }
            String finalUrl = url+ (StringUtils.isBlank(sb.toString())?"":"?"+sb.toString());
            HttpGet httpGet = new HttpGet(finalUrl);

            return httpExecute(httpGet, Charset.defaultCharset().name());

        }catch (IOException e){
            LOGGER.error("call httpGet url:{},param:{} exception,e",url, JSON.toJSON(param),e);
        }
        return null;
    }

    public static String doPost(String url,Map<String,String> param){
        HttpPost post = new HttpPost(url);
        List<NameValuePair> valuePairs = buildEntity(param);
        try {
            post.setEntity(new UrlEncodedFormEntity(valuePairs, HTTP.UTF_8));
            return httpExecute(post,HTTP.UTF_8);
        } catch (IOException e){
            LOGGER.error("call httpPost url:{},param:{} exception,e",url, JSON.toJSON(param),e);
        }
        return null;
    }

    private static List<NameValuePair> buildEntity(Map<String,String> param){
        List<NameValuePair> pairs = Lists.newArrayList();
        if(MapUtils.isEmpty(param)){
            return pairs;
        }
        for (Map.Entry<String, String> entry : param.entrySet()) {
            NameValuePair pair = new BasicNameValuePair(entry.getKey(),entry.getValue());
            pairs.add(pair);
        }
        return pairs;
    }

    private static String toString(HttpEntity entity, String defaultCharset) throws IOException, ParseException {
        if (entity == null) {
            throw new IllegalArgumentException("HTTP entity may not be null");
        } else {
            InputStream instream = entity.getContent();
            if (instream == null) {
                return null;
            } else if (entity.getContentLength() > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
            } else {
                int i = (int)entity.getContentLength();
                if (i < 0) {
                    i = 4096;
                }

                String charset = EntityUtils.getContentCharSet(entity);
                if (charset == null) {
                    charset = defaultCharset != null?defaultCharset:"UTF-8";
                }

                return readFromHttp(instream, charset, i);
            }
        }
    }


    private static String readFromHttp(InputStream instream, String charset, int bufferLength) throws IOException {
        CharArrayBuffer buffer = new CharArrayBuffer(bufferLength);

        try (Reader reader = new InputStreamReader(instream, charset)) {
            char[] tmp = new char[1024];

            int l;
            while ((l = reader.read(tmp)) != -1) {
                buffer.append(tmp, 0, l);
            }
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        //测试PGET请求
        String url = "https://www.toutiao.com/ch/news_hot/";
        System.out.println(doGet(url,null));
        //测试POST请求
//        String url = "http://touch.piao.qunar.com/touch/weekend/productintroduction.json";
//        Map<String,String> param = Maps.newHashMap();
//
//        param.put("productId","3048100849");
//        param.put("page","sight_detail");
//
//        System.out.println(doPost(url,param));

    }
}
