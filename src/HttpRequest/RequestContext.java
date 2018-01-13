package HttpRequest;

import java.util.Map;

public class RequestContext {
    public String requestURL;
    public String RequestMethod;
    public String Charset;
    public Map<String,String> extraHeaders;
    public Map<String,String> queryParam;
    public Map<String,String> queryForm;
}
