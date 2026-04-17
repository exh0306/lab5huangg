package com.lab5;

import org.springframework.web.bind.annotation.*;

@RestController
public class WebServiceReceiver {

    @PostMapping("/message")
    public String receiveMessage(@RequestBody Message msg) {
        try {
            String key = "secret_key";

            String receivedMessage = msg.getMessage();
            String receivedHmac = msg.getHmac();

            String generatedHmac = HMACUtil.generateHMAC(receivedMessage, key);

            System.out.println("Web service received:");
            System.out.println("Message Received: " + receivedMessage);
            System.out.println("HMAC Received: " + receivedHmac);
            System.out.println("HMAC Generated: " + generatedHmac);

            if (generatedHmac.equals(receivedHmac)) {
                System.out.println("Integrity Check: PASSED");
                return "Message received successfully (VALID)";
            } else {
                System.out.println("Integrity Check: FAILED");
                return "Message corrupted!";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error processing message";
        }
    }
}
