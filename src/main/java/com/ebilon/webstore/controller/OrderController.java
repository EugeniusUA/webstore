package com.ebilon.webstore.controller;

import com.ebilon.webstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/order/P123/2")
    public String processOrder(){
        orderService.processOrder("P123",2);
        return "redirect:/products";
    }
}
