package myShoopingMarch.MyShopping.repository;

import myShoopingMarch.MyShopping.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Query(value = "Select * from product where category=:category and name=:name",nativeQuery = true)
    public List<Product> getProductsByCategoryAndName(String category,String name);


    @Query(value = "Select * from product where category=:category",nativeQuery = true)
    public List<Product> getProductsByCategory(String category);

    @Query(value = "Select * from product where name=:name",nativeQuery = true)
    public List<Product> getProdcutsByName(String name);
}
