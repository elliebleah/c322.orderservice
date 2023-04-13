package edu.iu.c322.orderservice.repository;

import edu.iu.c322.orderservice.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOrderRepository
{
    public List<Order> orders = new ArrayList<>();

    public List<Order> findAll()
    {
        return orders;
    }


    public int create(@RequestBody Order customer)
    {
        int id = orders.size() + 1;
        customer.setId(id);
        orders.add(customer);
        return 0;
    }


    public void update(Order customer, int id)
    {
        Order x = findByID(id);
        if (x != null)
        {
            x.setName(customer.getName());
            x.setEmail(customer.getEmail());
        }
        else {
            throw  new IllegalStateException("customer id is not valid");
        }
    }


    public void delete(int id)
    {
        Order x = findByID(id);
        if (x != null)
        {
            orders.remove(x);
        }
        else {
            throw  new IllegalStateException("customer id is not valid");
        }

    }

    public Order findByID(int id)
    {
        return  orders.stream().filter(x -> x.getId() == id).findAny().orElse(null);
    }

    public Order getByID(int id)
    {
        return new Order();
    }
}
