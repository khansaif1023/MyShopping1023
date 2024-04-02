package myShoopingMarch.MyShopping.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /**
     * Whenever we will add a new product so a new unique id will automatically get generated.
     */
    UUID id;
    String name;
    String category;
    int quantity;
    int price;
    @ManyToOne
    AppUser user; // Relationship is betweern user table and product table.
    // User which we will be consendring here is only sellers type.
    // many products in product table can be owned by one user so relationship is many to one
    String rating;
    String description;
}
