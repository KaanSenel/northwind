package com.example.northwind.dataAccess.abstracts;

import com.example.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer>{

    Product getByProductName(String productName);

    Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);

    //product entitysinde category nesnesi verdiğimiz için sorguda da categorinin kategori_id'sini çağır diyoruz.
    List<Product> getByProductNameOrCategory_CategoryId(String productName,int categoryId);

    List<Product> getByCategory_CategoryIdIn(List<Integer> categoryId);

    List<Product> getByProductNameContains(String name);

    List<Product> getByProductNameStartsWith(String name);

    @Query("From Product where categoryName=:name and category.categoryId=:id")
    List<Product> getByNameAndCategory(String name,int id);
}
