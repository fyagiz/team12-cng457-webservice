package com.team12.team12.entity;
import lombok.*;
import javax.persistence.*;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int brandID;
    private String brandName;
    @OneToMany(mappedBy ="brand",cascade = CascadeType.ALL)
    private List<Product> productList;


}
