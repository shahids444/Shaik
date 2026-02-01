package com.medicart.cartorders.controller;

import com.medicart.cartorders.client.MedicineClient;
import com.medicart.cartorders.service.CartService;
import com.medicart.common.dto.CartItemDTO;
import com.medicart.common.dto.MedicineDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private MedicineClient medicineClient;

    @PostMapping("/add")
    public ResponseEntity<CartItemDTO> addToCart(
            @RequestHeader("X-User-Id") Long userId,
            @RequestParam Long medicineId,
            @RequestParam Integer quantity) {

        MedicineDTO medicineDTO = medicineClient.getMedicineById(medicineId);
        if (medicineDTO == null) {
            return ResponseEntity.badRequest().build();
        }

        CartItemDTO cartItem =
                cartService.addToCart(userId, medicineId, quantity, medicineDTO);

        return ResponseEntity.ok(cartItem);
    }

    @GetMapping
    public ResponseEntity<List<CartItemDTO>> getCart(
            @RequestHeader("X-User-Id") Long userId) {

        return ResponseEntity.ok(cartService.getUserCart(userId));
    }

    @PutMapping("/update/{itemId}")
    public ResponseEntity<CartItemDTO> updateCartItem(
            @PathVariable Long itemId,
            @RequestHeader("X-User-Id") Long userId,
            @RequestParam Integer quantity) {

        return ResponseEntity.ok(
                cartService.updateCartItem(itemId, quantity, userId)
        );
    }

    @DeleteMapping("/remove/{itemId}")
    public ResponseEntity<Void> removeFromCart(
            @PathVariable Long itemId,
            @RequestHeader("X-User-Id") Long userId) {

        cartService.removeFromCart(itemId, userId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/clear")
    public ResponseEntity<Void> clearCart(
            @RequestHeader("X-User-Id") Long userId) {

        cartService.clearUserCart(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/total")
    public ResponseEntity<Double> getTotal(
            @RequestHeader("X-User-Id") Long userId) {

        return ResponseEntity.ok(cartService.getCartTotal(userId));
    }
}
