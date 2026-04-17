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

import org.springframework.web.bind.annotation.*;

//class will handle incoming web requests
@RestController
public class WebServiceReceiver {

    //something is sent to /message, run it
    @PostMapping("/message")

    //Converts JSON into a message
    public String receiveMessage(@RequestBody Message msg) {
        try {
            String key = "secret_key";

            String receivedMessage = msg.getMessage();
            String receivedHmac = msg.getHmac();

            //recreates HMAC
            String generatedHmac = HMACUtil.generateHMAC(receivedMessage, key);

            System.out.println("Web service received:");
            System.out.println("Message Received: " + receivedMessage);
            System.out.println("HMAC Received: " + receivedHmac);
            System.out.println("HMAC Generated: " + generatedHmac);

            //compares HMAC from sender and receiver
            if (generatedHmac.equals(receivedHmac)) {
                System.out.println("Integrity Check: PASSED");
                return "Message received successfully!";
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
