package myShoopingMarch.MyShopping.dto;

import lombok.*;
import myShoopingMarch.MyShopping.models.AppUser;

import java.util.UUID;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDTO {
   private UUID id;
   private String productName;
   private String getProductCategory;
   private String rating;
   private String description;
   private int price;
}
