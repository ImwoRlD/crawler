package HttpRequest;

import java.util.Map;

public class RequestContext {
    public String requestURL;
    public String RequestMethod;
    public String Charset;
    public boolean isUpload;
    public boolean isClear;
    public Map<String,String> extraHeaders;
    public Map<String,String> queryParam;
    public Map<String,String> queryForm;
    public String getRequestURL() {
        return requestURL;
    }

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public String getRequestMethod() {
        return RequestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        RequestMethod = requestMethod;
    }

    public String getCharset() {
        return Charset;
    }

    public void setCharset(String charset) {
        Charset = charset;
    }

    public boolean isUpload() {
        return isUpload;
    }

    public void setUpload(boolean upload) {
        isUpload = upload;
    }

    public boolean isClear() {
        return isClear;
    }

    public void setClear(boolean clear) {
        isClear = clear;
    }

    public Map<String, String> getExtraHeaders() {
        return extraHeaders;
    }

    public void setExtraHeaders(Map<String, String> extraHeaders) {
        this.extraHeaders = extraHeaders;
    }

    public Map<String, String> getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(Map<String, String> queryParam) {
        this.queryParam = queryParam;
    }

    public Map<String, String> getQueryForm() {
        return queryForm;
    }

    public void setQueryForm(Map<String, String> queryForm) {
        this.queryForm = queryForm;
    }

    @Override
    public String toString() {
        return "RequestContext{" +
                "requestURL='" + requestURL + '\'' +
                ", RequestMethod='" + RequestMethod + '\'' +
                ", Charset='" + Charset + '\'' +
                ", isUpload=" + isUpload +
                ", isClear=" + isClear +
                ", extraHeaders=" + extraHeaders +
                ", queryParam=" + queryParam +
                ", queryForm=" + queryForm +
                '}';
    }
}
