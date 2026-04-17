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

import org.springframework.web.client.RestTemplate;

public class WebServiceSender {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        try {
            String key = "secret_key";
            String text = "hello world";

//generates a secure hash
            String hmac = HMACUtil.generateHMAC(text, key);

            Message msg = new Message(text, hmac);

            System.out.println("Web service sending:");
            System.out.println("Message Sent: " + msg.getMessage());
            System.out.println("HMAC Sent: " + msg.getHmac());

            //sends data to web service
            String response = restTemplate.postForObject(
                    "http://localhost:8080/message",
                    msg,
                    String.class
            );

            System.out.println("Server response: " + response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
