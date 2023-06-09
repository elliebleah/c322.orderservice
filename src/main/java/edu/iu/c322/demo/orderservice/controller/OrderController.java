package edu.iu.c322.demo.orderservice.controller;

import edu.iu.c322.demo.orderservice.model.Order;
import edu.iu.c322.demo.orderservice.model.OrderItem;
import edu.iu.c322.demo.orderservice.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int create(@RequestBody Order order){

        for(int i = 0; i < order.getItems().size(); i++){
            OrderItem item = order.getItems().get(i);
            item.setOrder(order);
        }
        Order addedOrder = repository.save(order);
        return addedOrder.getId();
    }

    @GetMapping("/{customerId}")
    public List<Order> findByCustomer(@PathVariable int customerId){
        return repository.findByCustomerId(customerId);
    }

    @GetMapping("/order/{orderId}")
    public Optional<Order> findByOrderId(@PathVariable int orderId){
        return repository.findById(orderId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Validated @RequestBody Order order, @PathVariable int id){
        order.setId(id);
        repository.save(order);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        Order order = new Order();
        order.setId(id);
        repository.delete(order);
    }

}
