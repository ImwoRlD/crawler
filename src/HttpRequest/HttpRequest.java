package HttpRequest;

import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private HttpRequestBase requestBase;
    private RequestContext requestContext;
    public HttpRequest(RequestContext requestContext){
        this.requestContext=requestContext;
    }
    public void init(){
        switch (requestContext.getRequestMethod()){
            case "GET":
                requestBase=new HttpGet(getRequestUrl());
                break;
            case "POST":
                requestBase=new HttpPost(getRequestUrl());
                break;
            default:
                requestBase=new HttpGet(getRequestUrl());
                break;
        }
    }
    public HttpResponse sendWithoutCookieStore(){
        HttpResponse httpResponse=new HttpResponse();
        CloseableHttpClient httpClient=HttpClients.createDefault();
        this.init();
        this.addRequestHeaders();
        try {
            CloseableHttpResponse response=httpClient.execute(this.requestBase);
            httpResponse.setCode(response.getStatusLine().getStatusCode());
            httpResponse.setBin(EntityUtils.toByteArray(response.getEntity()));
            httpResponse.setHeaders(new HashMap<String, String>());
            for (Header header:response.getAllHeaders()){
                httpResponse.getHeaders().put(header.getName(),header.getValue());
            }
            response.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return httpResponse;
    }
    public String getRequestUrl(){
        StringBuilder baseUrl=new StringBuilder(requestContext.getRequestURL());
        if (requestContext.getQueryParam()!=null){
            baseUrl=baseUrl.append("?");
            Map<String,String> queryMap=requestContext.getQueryForm();
            for (String name:queryMap.keySet()){
                try {
                    baseUrl.append(URLEncoder.encode(name,requestContext.getCharset()))
                            .append("=")
                            .append(URLEncoder.encode(queryMap.get(name),requestContext.getCharset()))
                            .append("&");
                }catch (UnsupportedEncodingException e){
                    e.printStackTrace();
                }
            }
        }
        return baseUrl.toString();
    }
    public void addRequestHeaders(){
        if (requestContext.getQueryForm()!=null){
            for (String key:requestContext.getQueryForm().keySet()){
                requestBase.addHeader(key,requestContext.getQueryForm().get(key));
            }
        }
    }
    public HttpResponse sendByProxy(){
        return null;
    }
}
