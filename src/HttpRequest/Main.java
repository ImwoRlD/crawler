package HttpRequest;

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
        CloseableHttpClient httpClient= HttpClients.createDefault();
        HttpGet httpGet=new HttpGet("http://www.baidu.com");
        HttpHost proxy=new HttpHost("127.0.0.1",9999);
        RequestConfig requestConfig=RequestConfig.custom().setProxy(proxy).build();
        httpGet.setConfig(requestConfig);
        try {
            CloseableHttpResponse response=httpClient.execute(httpGet);
            System.out.print(EntityUtils.toString(response.getEntity()));
            response.close();
            httpClient.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
