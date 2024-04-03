package myShoopingMarch.MyShopping.service;

import lombok.Setter;
import myShoopingMarch.MyShopping.dto.BillDTO;
import myShoopingMarch.MyShopping.dto.OrderDetailsDTO;
import myShoopingMarch.MyShopping.dto.OrderProductDTO;
import myShoopingMarch.MyShopping.models.AppUser;
import myShoopingMarch.MyShopping.models.OrderTable;
import myShoopingMarch.MyShopping.models.Product;
import myShoopingMarch.MyShopping.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BuyerService {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    OrderRepository orderRepository;

    public BillDTO placeOrder(List<OrderDetailsDTO> orderDetailsDTOList, UUID userId) {
        // Get user by id
        // 1. Verify user who is placing order
        // 2. We are forgetting to decrease packets in the database.
        // 3. Create bill dto
        // 4. email service
        AppUser user = productService.getUserById(userId);
        OrderTable orderTable = new OrderTable();

        BillDTO bill=new BillDTO();
        // Get List of product
        // we need to get products by id
        int totalPrice = 0;
        int totalQuantity = 0;
        List<Product> products = new ArrayList<>();
        List<OrderProductDTO> orderProducts=new ArrayList<>();
        for (OrderDetailsDTO order : orderDetailsDTOList) {
            OrderProductDTO orderProduct=new OrderProductDTO();
            UUID productId=order.getId();
            orderProduct.setProductID(productId);

            totalQuantity += order.getQuantity();
            Product product = productService.getProductById(productId);
            orderProduct.setProductName(product.getName());
            orderProduct.setQuantity(order.getQuantity());
            totalPrice += (order.getQuantity() * product.getPrice());
            products.add(product);
            orderTable.setPaymentMode(order.getPaymentMode());
            orderProducts.add(orderProduct);
            int updateQuantity=product.getQuantity()-order.getQuantity();
            productService.updateProductQuantity(productId,updateQuantity);
        }

        bill.setBuyerID(user.getId());
        bill.setBuyerName(user.getName());
        bill.setTotalPrice(totalPrice);
        bill.setTotalQuantity(totalQuantity);
        bill.setEmailID(user.getEmail());
        bill.setOrderProducts(orderProducts);
        orderTable.setProducts(products);
        orderTable.setUser(user);
        orderTable.setStatus("Not Delivered");
        orderTable.setTotalPrice(totalPrice);
        orderTable.setTotalQuantity(totalQuantity);

        orderRepository.save(orderTable);
        bill.setBillID(orderTable.getOrderId());
        return bill;

    }
    }
