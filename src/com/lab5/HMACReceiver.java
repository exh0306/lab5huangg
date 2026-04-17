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
package com.lab5;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class HMACReceiver {
    public static void main(String[] args) throws Exception {

        String key = "secret_key";
        String message = "hello world";

        String receivedHMAC = "zxpBivqvx5jfSP2ASiq/aXAoOv2MQLQfgYrZtspPjKg=";

        Mac mac = Mac.getInstance("HmacSHA256");

        //converts key into bytes and loads into HMAC system
        mac.init(new SecretKeySpec(key.getBytes(), "HmacSHA256"));
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "HmacSHA256");

        //turns message into bytes, creates the HMAC, encode the message, and turns into a string
        String computedHMAC = Base64.getEncoder() .encodeToString(mac.doFinal(message.getBytes()));

        if (computedHMAC.equals(receivedHMAC)) {
            //Check if computed HMAC ==received HMAC
            System.out.println("HMAC received");
        } else {
            System.out.println("HMAC NOT received");
        }
        System.out.println("Message Sent : " + message);
        System.out.println("Web service received:");
    }
}