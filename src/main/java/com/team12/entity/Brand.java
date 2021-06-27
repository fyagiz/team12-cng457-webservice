package com.team12.entity;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import javax.persistence.*;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(scope=Brand.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "brandID")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int brandID;
    @Column(unique = true)
    private String brandName;
    @OneToMany(mappedBy ="brand",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> productList;


    public Brand(int i, String apple) {
        this.brandID=i;
        this.brandName=apple;
    }
}
