package com.example.productservice_dc_05.dto;

import com.example.productservice_dc_05.service.FakeStoreProductService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
