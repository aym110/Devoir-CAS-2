package ma.store.productservice.dto;

import ma.store.productservice.model.Product;
import org.springframework.stereotype.Component;

@Component
public class Mapping {

    public ProductDTO mappingFromProductToProductDTO(Product product){
        if(product != null){
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setTitle(product.getTitle());
            productDTO.setPrice(product.getPrice());
            return productDTO;
        }
        return null;
    }
}
