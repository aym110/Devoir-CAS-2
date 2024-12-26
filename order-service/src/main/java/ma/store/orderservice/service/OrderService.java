package ma.store.orderservice.service;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.store.orderservice.dto.Mapping;
import ma.store.orderservice.dto.OrderDTO;
import ma.store.orderservice.feign.ProductInterface;
import ma.store.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    OrderRepository orderRepository;
    ProductInterface productInterface;
    Mapping mapping;

    public OrderService(OrderRepository orderRepository, ProductInterface productInterface, Mapping mapping){
        this.orderRepository=orderRepository;
        this.productInterface=productInterface;
        this.mapping=mapping;
    }
    // create an order

    @CircuitBreaker(name = "productService" ,fallbackMethod = "fallback")
    public String createOrder(OrderDTO orderDTO){
        // check if the order is available (send a request to product service)
        if(productInterface.isAvailable(orderDTO.getProductId(), (long) orderDTO.getQuantity()).getBody()){
            orderRepository.save(mapping.mappingFromOrderDtoToOrder(orderDTO));
            return "Created";
        }
        return "Stock insufficient";
    }

    private String fallback(){
        return "The server is down now. Please try again after 1-2 hours!";
    }


}
