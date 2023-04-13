package edu.iu.c322.orderservice.repository;

import edu.iu.c322.orderservice.model.Order;
import edu.iu.c322.orderservice.model.Order;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
;
;

    public List<Order> findAll();


    public int create(@RequestBody Order order);


    public void update(Order order, int id);


    public void delete(int id);

    public Order findByID(int id);
}