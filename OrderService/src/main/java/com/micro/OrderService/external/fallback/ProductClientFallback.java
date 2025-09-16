//package com.micro.OrderService.external.fallback;
//
//import com.micro.OrderService.exception.CustomException;
//import com.micro.OrderService.external.client.ProductClient;
//import com.micro.OrderService.model.Products;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ProductClientFallback implements ProductClient {
//    @Override
//    public ResponseEntity<Products> getProductById(int id) {
//        System.err.println("Fallback product");
//        throw new CustomException(
//                "Product service is not available now.\n",
//                "UNAVAILABLE",
//                500
//        );
//    }
//}
