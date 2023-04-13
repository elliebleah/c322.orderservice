package edu.iu.c322.orderservice.controller;


import edu.iu.c322.orderservice.model.Order;
import edu.iu.c322.orderservice.repository.OrderRepository;
import edu.iu.c322.orderservice.model.Order;
import edu.iu.c322.orderservice.repository.OrderRepository;
//import jakarta.validation.Valid;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController
{
    //Get localhost:8080/orders
    //ArrayList<Order> orders = new ArrayList<>();
    private OrderRepository repository;
    @GetMapping
    public List<Order> findAll()
    {
        return repository.findAll();
    }

    public OrderController() {
        //this.repository = new OrderController();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@Valid @RequestBody Order order)
    {
       repository.create(order);
       //return newOrder.getId();//repository.create(order);
    }


    //PUT localhost:8080/orders/2

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("{id}")
    public void update(@Valid @RequestBody Order order, @PathVariable int id)
    {
        //order.setId(id);
        //repository.save();
        repository.update(order, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id)
    {
        Order order = new Order();
        order.setId(id);
        repository.delete(id);
    }
    /*
    private Order findByID(int id)
    {
        return  orders.stream().filter(x -> x.getId() == id).findAny().orElse(null);
    }

     */
}
