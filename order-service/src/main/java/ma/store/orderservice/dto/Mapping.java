package ma.store.orderservice.dto;

import ma.store.orderservice.models.Order;
import org.springframework.stereotype.Component;

@Component
public class Mapping {

    public Order mappingFromOrderDtoToOrder(OrderDTO orderDTO){
        Order order = new Order();
        order.setQuantity(orderDTO.getQuantity());
        order.setProductId(orderDTO.getProductId());
        return order;
    }

}
