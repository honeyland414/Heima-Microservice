package com.example.orderservice.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderResponse {
    private Order order;
    private User user;
}
