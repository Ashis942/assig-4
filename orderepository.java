package com.example.orm;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	
    Order findById(long id);
 
  
    List<Order> findByOrderDate(Date orderDate);
 
   
    List<Order> findByOrderStatus(OrderStatus orderStatus);
 
    
    List<Order> findByTotalAmountGreaterThan(BigDecimal totalAmount);
 
   
    List<Order> findByCustomer(Customer customer);

    List<Order> findByCustomer_Id(Long customerId);
    
    Order findOrderById(Long orderId);
    
    @Query("SELECT o FROM Order o WHERE O.customer.id = :customerId")
    List<Order> findOrdersByCustomerId(@Param("customerId") Long customerId);


}