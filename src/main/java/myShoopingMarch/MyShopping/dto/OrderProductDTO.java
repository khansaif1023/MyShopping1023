package myShoopingMarch.MyShopping.dto;

import lombok.*;

import java.beans.Transient;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class OrderProductDTO {
    UUID productID;
    String productName;
    int quantity;
}
