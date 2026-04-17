/**
 * Project: Lab5
 * Purpose Details: Web Service and HMAC
 * Course : IST 242
 * Author: Emlety Huang
 * Date Developed: 4/15/26
 * Last Date Changed: 4/17/26
 * Revision: 4/17/26
 *
 */

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class HMACSender {
    public static void main(String[] args) throws Exception {
        String key = "secret_key";
        String message = "hello world";

        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "HmacSHA256");
        mac.init(keySpec);

        byte[] rawHmac = mac.doFinal(message.getBytes());
        System.out.println(Base64.getEncoder().encodeToString(rawHmac));
    }
}