package com.micro.OrderService.external.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.OrderService.exception.CustomException;
import com.micro.OrderService.external.response.ErrorResponse;
import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class CustomFeignErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            if (response.status() == 503 || response.status() == 404) {
                String body = response.body() != null ? new String(response.body().asInputStream().readAllBytes()) : null;

                log.error("Feign error response: {}", body);

                if (body != null && body.trim().startsWith("{")) {
                    System.err.println("work in if");
                    // Likely JSON → try to parse
                    ErrorResponse errorResponse = objectMapper.readValue(body, ErrorResponse.class);
                    return new CustomException(errorResponse.getErrorMessage(), errorResponse.getErrorCode(), response.status());
                } else {
                    // Not JSON → return plain-text error message
                    return new CustomException(body != null ? body : "Unknown error occurred", "SERVICE_UNAVAILABLE", response.status());
                }
            }else {
                System.err.println("else clause");
                    return FeignException.errorStatus(methodKey, response);
            }
        } catch (Exception e) {
            return new CustomException("Internal Server Error: " + e.getMessage(), "INTERNAL_SERVER_ERROR", 500);
        }
    }
}
