package ma.store.productservice.service;

import ma.store.productservice.dto.Mapping;
import ma.store.productservice.dto.ProductDTO;
import ma.store.productservice.model.Product;
import ma.store.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    ProductRepository productRepository;
    Mapping mapping;

    public ProductService(ProductRepository productRepository, Mapping mapping){
        this.productRepository=productRepository;
        this.mapping=mapping;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public ProductDTO getProductDTO(Long id){
        if(productRepository.findById(id).isPresent()){
            return mapping.mappingFromProductToProductDTO(productRepository.findById(id).get());
        }
        return null;
    }
    public ProductDTO getProductDTOByTitle(String title){
        if(productRepository.findByTitle(title).isPresent()){
            return mapping.mappingFromProductToProductDTO(productRepository.findByTitle(title).get());
        }
        return null;
    }
    public Product getProduct(Long id){
        if(productRepository.findById(id).isPresent()){
            return productRepository.findById(id).get();
        }
        return null;
    }
    public Product getProductByTitle(String title){
        if(productRepository.findByTitle(title).isPresent()){
            return productRepository.findByTitle(title).get();
        }
        return null;
    }

    public String createProduct(Product product){
        if(product != null){
            productRepository.save(product);
            return "CREATED";
        }else{
            return "PRODUCT IS NULL!!";
        }
    }


    public Boolean isAvailable(Long id, Long qty){
        Product product = getProduct(id);
        if(product != null){
            return product.getQuantity() >= qty;
        }
        return null;
    }
    public Boolean isAvailableByTitle(String title, Long qty){
        Product product = getProductByTitle(title);
        if(product != null){
            return product.getQuantity() >= qty;
        }
        return null;
    }
}
