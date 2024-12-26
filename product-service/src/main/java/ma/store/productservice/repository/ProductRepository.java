package ma.store.productservice.repository;

//import ma.store.productservice.dto.ProductDTO;
import ma.store.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@RepositoryRestResource(collectionResourceRel = "products", path = "ecommerce", excerptProjection = ProductDTO.class)
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.title = :title")
    Optional<Product> findByTitle(@Param("title") String title);
}
