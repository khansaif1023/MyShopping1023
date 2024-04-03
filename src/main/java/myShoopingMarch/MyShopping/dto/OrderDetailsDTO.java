package myShoopingMarch.MyShopping.dto;

import lombok.*;

import java.util.UUID;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDTO {
    UUID id;
    int quantity;
    String paymentMode;
}
