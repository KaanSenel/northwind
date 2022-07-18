package com.example.northwind.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
@JsonIgnoreProperties({"hibernateLazyInitiliazer","handler","products"})
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "description")
    private String description;

    //bir kategorinin birden fazla ürünü olabilir bu yüzden one to many ilişkisi kurduk.
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
