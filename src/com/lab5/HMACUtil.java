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

//HMACUtil takes msg and key and create HMAC using SHA-256
package com.lab5;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class HMACUtil {

    public static String generateHMAC(String message, String key) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "HmacSHA256");
        mac.init(secretKeySpec);

        //gives a hashed result(bytes)
        byte[] rawHmac = mac.doFinal(message.getBytes());
        //converts the results into a readable string
        return Base64.getEncoder().encodeToString(rawHmac);
    }
}