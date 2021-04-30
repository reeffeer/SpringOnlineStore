package my.project.armorer.s.shop.dto;

import lombok.Data;
import my.project.armorer.s.shop.entities.Cart;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CartDto {

    private List<CartItemDto> cartItemsDto;
    private BigDecimal totalPrice;

    public CartDto(Cart cart) {
        this.totalPrice = cart.getTotalPrice();
        this.cartItemsDto = cart.getCartItems().stream().map(CartItemDto::new).collect(Collectors.toList());
    }
}
