package ma.store.orderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("PRODUCT-SERVICE")
public interface ProductInterface {
    @GetMapping("product/isAvl/{id}")
    public ResponseEntity<Boolean> isAvailable(@PathVariable Long id, @RequestParam Long qty);
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductDTO(@PathVariable Long id);
}
