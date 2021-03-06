package com.zopper.bsi.controllers;

import com.zopper.bsi.config.exceptions.APIException;
import com.zopper.bsi.response.APIResponse;
import com.zopper.bsi.response.OrderData;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Sudhir on 18/5/16.
 */
@RestController
@RequestMapping("/test")
public class TestApiController {

    Logger logger  = Logger.getLogger(TestApiController.class);

    @Autowired
    private MailSender mailSender;

    @RequestMapping(value="/exception-custom",method = RequestMethod.GET)
    @ResponseBody
    public APIResponse testCustomException(@RequestParam Boolean show) throws APIException {
        if (show)
            throw new APIException("CODE", "Custom exception works");
        return new APIResponse("success");
    }

    @RequestMapping(value="/exception-global",method = RequestMethod.GET)
    @ResponseBody
    public APIResponse globalException(@RequestParam(required = false) Boolean show) throws APIException {
        if (show){
            String t = "";
            String[] x = t.split(",");
        }
        return new APIResponse("success");
    }

    @RequestMapping(value="/email/",method = RequestMethod.GET)
    @ResponseBody
    public APIResponse sendEmail(@RequestParam(value="message") String emailMessage,
                            @RequestParam(value="emailAddress") String emailAddress){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailAddress);
        message.setFrom("brand-cust-care@zopper.com");
        message.setSubject("Test Email Service");
        message.setText(emailMessage);

        mailSender.send(message);

        return new APIResponse("Email Sent");
    }

    @RequestMapping(value="/order-data/",method = RequestMethod.GET,produces="application/json")
    @ResponseBody public APIResponse onboardOrderData(@RequestParam(value="orderId") int id){

        System.out.println("Order being processed: " + id);

        String orderFetchURL = "http://45.56.118.248/sales/orders/" + id + "/";

        RestTemplate restTemplate = new RestTemplate();
        OrderData personData = restTemplate.getForObject(orderFetchURL, OrderData.class);

        if( personData == null)
        {
            System.out.println("No order data found with this order ID ");
        }
        else
        {
            System.out.println(personData);
        }

        return new APIResponse(personData);
    }

}
