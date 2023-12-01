package com.example.orm;

import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
	
	
    Item findById(long id);
 
    List<Item> findByItemName(String itemName);
 
    
    List<Item> findByPrice(BigDecimal price);
 
   
    List<Item> findByQuantity(int quantity);
 
   
    List<Item> findByOrder_OrderStatus(OrderStatus orderStatus);

}