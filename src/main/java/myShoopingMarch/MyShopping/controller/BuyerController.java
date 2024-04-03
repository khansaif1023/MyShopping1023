package myShoopingMarch.MyShopping.controller;

import myShoopingMarch.MyShopping.dto.BillDTO;
import myShoopingMarch.MyShopping.dto.OrderDetailsDTO;
import myShoopingMarch.MyShopping.models.OrderTable;
import myShoopingMarch.MyShopping.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    BuyerService buyerService;
    @PostMapping("/placeorder")
    public BillDTO placeOrder(@RequestBody List<OrderDetailsDTO> orders, @RequestParam UUID userId){
        return buyerService.placeOrder(orders, userId);
    }
}
