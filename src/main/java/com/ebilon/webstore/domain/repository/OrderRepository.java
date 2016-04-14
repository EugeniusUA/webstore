package com.ebilon.webstore.domain.repository;

import com.ebilon.webstore.domain.Order;

public interface OrderRepository {
    Long saveOrder(Order order);
}
