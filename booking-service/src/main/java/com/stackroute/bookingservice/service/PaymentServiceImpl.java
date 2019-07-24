//package com.stackroute.bookingservice.service;
//
//import ChargeRequest;
//import PaymentDetails;
//import com.stackroute.bookingservice.repository.PaymentDetailsRepository;
//import com.stripe.Stripe;
//import com.stripe.exception.*;
//import com.stripe.model.Charge;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class PaymentServiceImpl implements PaymentService {
//
//    @Value("sk_test_BpQ0dovE5pJ7VQIYwy4U6iYw00C1IMpYQg")
//    private String secretKey;
//
//    @PostConstruct
//    public void init()
//    {
//        Stripe.apiKey = secretKey;
//    }
//
//    private PaymentDetailsRepository paymentDetailsRepository;
//
//    @Autowired
//    public PaymentServiceImpl(PaymentDetailsRepository paymentDetailsRepository){
//
//        this.paymentDetailsRepository = paymentDetailsRepository;
//    }
//
//
//
//    @Override
//    public Charge charge(ChargeRequest chargeRequest) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
//
//        Map<String, Object> chargeParams = new HashMap<>();
//
//        chargeParams.put("amount",chargeRequest.getAmount());
//        chargeParams.put("currency",chargeRequest.getCurrency());
//        chargeParams.put("description",chargeRequest.getDescription());
//        chargeParams.put("source",chargeRequest.getStripeToken());
//        System.out.println(chargeParams);
//        Charge charge=Charge.create(chargeParams);
//
//        return charge;
//    }
//
//    @Override
//    public PaymentDetails savePaymentDetails(PaymentDetails paymentDetails) {
//        return paymentDetailsRepository.save(paymentDetails);
//    }
//
//}
