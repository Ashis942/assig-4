package com.example.orm;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/api/orders")
public class OrderController {
   
	
	private final OrderService orderService;
	 
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
 
    
    @GetMapping("/{orderId}")
    public Order getOrderDetails(@PathVariable Long orderId) {
        return orderService.getOrderDetails(orderId);
    }
 
  
    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
 
    
    @GetMapping("/customer/{customerId}")
    public List<Order> getOrdersByCustomer(@PathVariable Long customerId) {
        return orderService.getOrdersByCustomer(customerId);
    }
 
   
    @PostMapping("/create")
    public Order createOrder(@RequestBody Order newOrder) {
        return orderService.createOrder(newOrder);
    }
 
   
    @PutMapping("/update/{orderId}")
    public Order updateOrder(@PathVariable Long orderId, @RequestBody Order updatedOrder) {
        return orderService.updateOrder(orderId, updatedOrder);
    }
 
    
    @DeleteMapping("/delete/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
    }
}