package ma.store.productservice.controller;

import ma.store.productservice.model.Product;
import ma.store.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductDTO(@PathVariable Long id){
        return new ResponseEntity<>(productService.getProductDTO(id), HttpStatus.OK);
    }
    @GetMapping("/byTitle/{title}")
    public ResponseEntity<?> getProductDTOByTitle(@PathVariable String title){
        return new ResponseEntity<>(productService.getProductDTOByTitle(title), HttpStatus.OK);
    }

    @GetMapping("/isAvl/{id}")
    public ResponseEntity<Boolean> isAvailable(@PathVariable Long id,@RequestParam Long qty){
        return new ResponseEntity<>(productService.isAvailable(id, qty),HttpStatus.OK);
    }
    @GetMapping("/isAvl/byTitle/{title}")
    public ResponseEntity<?> isAvailableByTitle(@PathVariable String title,@RequestParam Long qty){
        return new ResponseEntity<>(productService.isAvailableByTitle(title, qty),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.OK);
    }
}
