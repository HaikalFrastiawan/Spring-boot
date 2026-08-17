package com.app.ecommers.dto;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {

    @NotBlank(message = "Nama produk tidak boleh kosong")
    private String name;

    private String description;

    @NotNull(message = "Harga tidak boleh kosong")
    @DecimalMin(value = "0.0", inclusive = false, message = "Harga harus lebih dari 0")
    private BigDecimal price;

    @NotNull(message = "Stok tidak boleh kosong")
    @Min(value = 0, message = "Stok minimal 0")
    private Integer stock;
}