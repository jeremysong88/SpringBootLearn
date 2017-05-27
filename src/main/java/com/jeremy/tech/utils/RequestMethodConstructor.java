package com.jeremy.tech.utils;

import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by jeremysong on 5/24/2017.
 */
public class RequestMethodConstructor {

    private CloseableHttpClient client = HttpClients.createDefault();

    private HttpRequestBase request;

    private CloseableHttpResponse response;

    /**
     * 指定使用GET方法请求目标URI
     *
     * @param uri 目标URI
     */
    public void createGetMethod(String uri) {
        this.request = new HttpGet(uri);
    }

    /**
     * 指定使用POST方法请求目标URI
     *
     * @param uri 目标URI
     */
    public void createPostMethod(String uri) {
        this.request = new HttpPost(uri);
    }

    /**
     * 给请求添加参数，此方法在对同一个实例重复调用时必须再次使用{@link #createGetMethod(String)}，
     * 或{@link #createPostMethod(String)}方法重新生成Http请求对象。
     *
     * @param pairs 待添加的键值对参数
     * @throws UnsupportedEncodingException
     * @see #createGetMethod(String)
     * @see #createPostMethod(String)
     */
    public void setParameters(List<NameValuePair> pairs) throws UnsupportedEncodingException {
        if (request instanceof HttpGet) {
            String oldUri = request.getURI().toString();
            String params = buildGetRequestParamString(pairs);
            request = new HttpGet(oldUri + "?" + params);
        } else if (request instanceof HttpPost) {
            HttpPost post = (HttpPost) request;
            post.setEntity(new UrlEncodedFormEntity(pairs));
        } else {
            throw new IllegalArgumentException("This method required a HttpPost instance.");
        }
    }

    /**
     * 以key=value的方式用&拼接GET请求参数
     *
     * @param pairs
     * @return
     */
    private String buildGetRequestParamString(List<NameValuePair> pairs) {
        StringBuffer sb = new StringBuffer();
        if (pairs != null && pairs.size() > 0) {
            for (NameValuePair pair : pairs) {
                sb.append(pair.getName()).append("=").append(pair.getValue()).append("&");
            }
        }
        sb.deleteCharAt(sb.lastIndexOf("&"));
        return sb.toString();
    }

    public void setHeader(Header header) {
        request.setHeader(header);
    }

    public void setHeader(String name, String value) {
        request.setHeader(name, value);
    }

    public void setHeader(Header[] headers) {
        request.setHeaders(headers);
    }

    /**
     * 执行Http请求
     *
     * @throws IOException
     */
    public void execute() throws IOException {
        response = client.execute(request);
    }

    /**
     * 返回Http请求执行后的相应对象，此方法在没有执行{@link #execute()}之前返回为null
     *
     * @return 请求响应
     * @see #execute()
     */
    public CloseableHttpResponse getResponse() {
        return response;
    }

    /**
     * 获取通过{@link #createGetMethod(String)}方法创建的HttpGet对象
     *
     * @return
     * @see #createGetMethod(String)
     */
    public HttpGet getHttpGet() {
        if (request instanceof HttpGet) {
            return (HttpGet) request;
        }
        return null;
    }

    /**
     * 获取通过{@link #createPostMethod(String)}方法创建的HttpPost对象
     *
     * @return
     * @see #createPostMethod(String)
     */
    public HttpPost getHttpPost() {
        if (request instanceof HttpPost) {
            return (HttpPost) request;
        }
        return null;
    }

    /**
     * 以字符串的形式获取相应结果，此方法在{@link #execute()}执行前调用返回空字符串
     *
     * @return
     * @throws IOException
     * @see #execute()
     */
    public String getResponseAsString() throws IOException {
        if (response != null) {
            return EntityUtils.toString(response.getEntity());
        }
        return "";
    }
}
