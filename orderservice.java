package com.example.bootcore;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class OrderService {

	
	private final OrderRepository orderRepository;
	 
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public void printReportForOrderId(Long orderId) {
      
        Order order = orderRepository.findOrderById(orderId);
 
        
        if (order != null) {
            System.out.println("Report for Order ID " + orderId);
            System.out.println("Order Date: " + order.getOrderDate());
          
        } else {
            System.out.println("Order with ID " + orderId + " not found.");
        }
    }
 
   
    public Order getOrderDetails(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }
 
    
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
 
   
    public List<Order> getOrdersByCustomer(Long customerId) {
        
        return (orderRepository).findByCustomer_Id(customerId);
    }
 
  
    public Order createOrder(Order newOrder) {
       
        return orderRepository.save(newOrder);
    }
 
   
    public Order updateOrder(Long orderId, Order updatedOrder) {
      
        Order existingOrder = orderRepository.findById(orderId).orElse(null);
        if (existingOrder != null) {
           
            existingOrder.setOrderStatus(updatedOrder.getOrderStatus());
           
 
         
            return orderRepository.save(existingOrder);
        }
        return null; 
    }
 
   
    public void deleteOrder(Long orderId) {
       
        orderRepository.deleteById(orderId);
    }
}