package myShoopingMarch.MyShopping.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    int quantity;
    @OneToOne
    AppUser user;
    int totalPrice;
    @OneToMany
    List<Product> products;

}
