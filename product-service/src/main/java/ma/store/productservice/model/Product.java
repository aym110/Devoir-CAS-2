package ma.store.productservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Double price;
    private Long quantity;
    private String description;


//    public Long getId(){
//        return id;
//    }
//    public String getTitle(){
//        return title;
//    }
//    public Long getQuantity(){
//        return quantity;
//    }

}
