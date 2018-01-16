package HttpRequest;

import java.util.HashMap;

public class RequestContextBuilder {
    private RequestContext requestContext=new RequestContext();
    public RequestContextBuilder url(String url){
        requestContext.setRequestURL(url);
        return this;
    }
    public RequestContextBuilder charset(String charset){
        requestContext.setCharset(charset);
        if (requestContext.getResponseCharset()==null){
            requestContext.setResponseCharset(charset);
        }
        return this;
    }
    public RequestContextBuilder setProxy(String addr,String port){
        requestContext.setProxyAddr(addr);
        requestContext.setProxyPort(port);
        return this;
    }
    public RequestContextBuilder method(String method){
        if (method.equals("GET")){
            requestContext.setRequestMethod(method);
        }
        else if (method.equals("POST")){
            requestContext.setRequestMethod(method);
        }
        else {
            requestContext.setRequestMethod("GET");
        }
        return this;
    }
    public RequestContextBuilder queryParam(String name,String value){
        if (requestContext.getQueryParam()==null){
            requestContext.setQueryParam(new HashMap<>());
        }
        requestContext.getQueryForm().put(name,value);
        return this;
    }
    public RequestContextBuilder queryForm(String name,String value){
        if (requestContext.getQueryForm()==null){
            requestContext.setQueryForm(new HashMap<>());
        }
        requestContext.getQueryForm().put(name,value);
        return this;
    }
    public RequestContextBuilder header(String name,String value){
        if (requestContext.getExtraHeaders()==null){
            requestContext.setExtraHeaders(new HashMap<>());
        }
        requestContext.getExtraHeaders().put(name,value);
        return this;
    }
    public RequestContextBuilder upload(){
        requestContext.setUpload(true);
        return this;
    }
    public RequestContextBuilder clearCookie(){
        requestContext.setClear(true);
        return this;
    }
    public RequestContext build(){
        return requestContext;
    }
}
