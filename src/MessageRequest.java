public class MessageRequest {
    private String message;
    private String hmac;

    public MessageRequest() {
    }

    public MessageRequest(String message, String hmac) {
        this.message = message;
        this.hmac = hmac;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHmac() {
        return hmac;
    }

    public void setHmac(String hmac) {
        this.hmac = hmac;
    }
}