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
public class OrderTable {
    // Order table vs product table
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID orderId;
    int totalPrice;
    int totalQuantity;
    // Buyer is a User Only -> We need to maintain relationship between user table and order table
    // from order table point of view what kind of relationship it looks like
    @ManyToOne
    AppUser user;

    @OneToMany
    // Becaus of one to many annotation another table will get created which
    // orderID vs ProductId
    // and this table will maintain details like what are products that are present in
    // a particular oder
    List<Product> products;
    String status; // Delivered, In Transit, Returned, Cancelled
    String paymentMode; // UPI, DebitCard, COD
}
