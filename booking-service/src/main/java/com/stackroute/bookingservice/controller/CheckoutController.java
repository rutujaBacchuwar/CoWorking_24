//package com.stackroute.bookingservice.controller;
//
//
//import ChargeRequest;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class CheckoutController {
//
//    @Value("pk_test_jN5Y04oyub1EPTZIwTzr37i000AMPHi2SC")
//    private String stripePublicKey;
//
//    @RequestMapping("/checkout")
//    public String checkout(Model model) {
//        model.addAttribute("amount", 50 * 100); // in cents
//        model.addAttribute("stripePublicKey", stripePublicKey);
//        model.addAttribute("currency", ChargeRequest.Currency.EUR);
//        return "checkout";
//    }
//}
