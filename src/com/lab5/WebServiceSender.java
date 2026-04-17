package com.lab5;

import org.springframework.web.client.RestTemplate;

public class WebServiceSender {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        try {
            String key = "secret_key";
            String text = "hello world"; // IMPORTANT: keep simple

            String hmac = HMACUtil.generateHMAC(text, key);

            Message msg = new Message(text, hmac);

            System.out.println("Web service sending:");
            System.out.println("Message Sent: " + msg.getMessage());
            System.out.println("HMAC Sent: " + msg.getHmac());

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
