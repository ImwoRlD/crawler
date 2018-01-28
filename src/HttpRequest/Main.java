package HttpRequest;

import Uploader.ImageUploader;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Main {
    public static void main(String args[]){
        RequestContext context=new RequestContext();
        context.setResponseCharset("GB18030");
        context.url("http://202.194.48.15/validateCodeAction.do")
                .GET();
        HttpRequest request=new HttpRequest();
        request.setRequestContext(context);
        HttpResponse response=request.sendWithCookieStore();
        System.out.print(response.getBin());
        String result=ImageUploader.upload(response.getBin(),"abcderf");
        System.out.print(result);
    }
}
