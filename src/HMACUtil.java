import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class HMACUtil {

    public static String generateHMAC(String message, String key) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "HmacSHA256");
        mac.init(secretKeySpec);

        byte[] rawHmac = mac.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(rawHmac);
    }
}