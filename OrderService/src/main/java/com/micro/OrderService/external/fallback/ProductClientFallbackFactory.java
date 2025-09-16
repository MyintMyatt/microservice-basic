//package com.micro.OrderService.external.fallback;
//
//import com.micro.OrderService.exception.CustomException;
//import com.micro.OrderService.external.client.ProductClient;
//import org.springframework.cloud.openfeign.FallbackFactory;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ProductClientFallbackFactory implements FallbackFactory<ProductClient> {
//    @Override
//    public ProductClient create(Throwable cause) {
//        return id -> {
//            System.err.println("Fallback triggered due to: " + cause);
//            throw new CustomException(
//                    "Product service is not available now.\n" + cause.getMessage(),
//                    "UNAVAILABLE",
//                    503
//            );
//        };
//    }
//}
//
