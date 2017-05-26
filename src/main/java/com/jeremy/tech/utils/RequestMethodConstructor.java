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

    public HttpGet createGetMethod(String uri) {
        this.request = new HttpGet(uri);
        return (HttpGet) request;
    }

    public HttpPost createPostMethod(String uri) {
        this.request = new HttpPost(uri);
        return (HttpPost) request;
    }

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

    public void execute() throws IOException {
        response = client.execute(request);
    }

    public CloseableHttpResponse getResponse() {
        return response;
    }

    public HttpGet getHttpGet() {
        if (request instanceof HttpGet) {
            return (HttpGet) request;
        }
        return null;
    }

    public HttpPost getHttpPost() {
        if (request instanceof HttpPost) {
            return (HttpPost) request;
        }
        return null;
    }

    public String getResponseAsString() throws IOException {
        if (response != null) {
            return EntityUtils.toString(response.getEntity());
        }
        return "";
    }
}
