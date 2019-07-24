//package com.stackroute.bookingservice.controller;
//
//import CardDetails;
//import PaymentDetails;
//import ChargeRequest;
//import com.stackroute.bookingservice.service.CardService;
//import com.stackroute.bookingservice.service.PaymentService;
//import com.stripe.exception.StripeException;
//import com.stripe.model.Charge;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//
//
//@RestController
//@RequestMapping(value = "api/v1")
//@CrossOrigin
//public class PaymentController {
//
//    @Autowired
//    private PaymentService paymentService;
//
//    public PaymentController(PaymentService paymentService){
//        this.paymentService=paymentService;
//    }
//
//    @PostMapping("/charge")
//    public String charge(@RequestBody ChargeRequest chargeRequest, Model model) throws StripeException{
//        chargeRequest.setDescription("Example charge");
//        chargeRequest.setCurrency(ChargeRequest.Currency.EUR);
//        Charge charge = paymentService.charge(chargeRequest);
//        model.addAttribute("id", charge.getId());
//        model.addAttribute("status", charge.getStatus());
//        model.addAttribute("chargeId", charge.getId());
//        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
//        return "result";
//    }
//
//
//    @PostMapping("/paymentDetails")
//    public ResponseEntity<?> savePaymentDetails(@RequestBody PaymentDetails paymentDetails){
//        PaymentDetails paymentDetails1=paymentService.savePaymentDetails(paymentDetails);
//        ResponseEntity responseEntity=new ResponseEntity<Object>(paymentDetails1, HttpStatus.CREATED);
//        return responseEntity;
//
//    }
//
////    @PostMapping("/cardDetails")
////    public ResponseEntity<?> saveCardDetails(@RequestBody CardDetails cardDetails){
////        CardDetails cardDetails1= CardService.saveCardDetails(cardDetails);
////        ResponseEntity responseEntity=new ResponseEntity<Object>(cardDetails1, HttpStatus.CREATED);
////        return responseEntity;
////
////    }
//}
