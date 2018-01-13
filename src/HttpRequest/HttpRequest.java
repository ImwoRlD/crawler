package HttpRequest;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClients;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class HttpRequest {
    private HttpRequestBase requestBase;
    private RequestContext requestContext;
    public HttpRequest(RequestContext requestContext){
        this.requestContext=requestContext;
    }
    public HttpRequestBase init(RequestContext requestContext){
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
        return requestBase;
    }
    public HttpResponse sendTest(){
        return null;
    }
    public String getRequestUrl(){
        StringBuilder baseUrl=new StringBuilder(requestContext.getRequestURL());
        if (requestContext.getQueryParam().size()>0){
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
    public HttpRequestBase addRequestHeaders(HttpRequestBase requestBase){
        if (requestContext.getQueryForm().size()>0){

        }
    }
    public HttpResponse sendByProxy(){}
}
