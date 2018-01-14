package HttpRequest;

public class Main {
    public static void main(String args[]){
        RequestContextBuilder builder=new RequestContextBuilder();
        RequestContext requestContext=builder.url("www.baidu.com").method("GET").build();
        HttpRequest httpRequest=new HttpRequest(requestContext);
        HttpResponse response=httpRequest.sendWithoutCookieStore();
        String result=response.string();
    }
}
