package com.example.productservice_dc_05.service;

import com.example.productservice_dc_05.dto.ProductDto;
import com.example.productservice_dc_05.models.category;
import com.example.productservice_dc_05.models.products;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
@Service
public class FakeStoreProductService implements ProductService{
    RestTemplate template = new RestTemplate();
    public products convertToProducts(ProductDto prdto){
        products product = new products();
        product.setId(prdto.getId());
        product.setTitle(prdto.getTitle());
        product.setDescription(prdto.getDescription());
        product.setImage(prdto.getImage());
        category category = new category();
        category.setDescription(prdto.getCategory());
        product.setCategory(category);
        return product;
    }
    @Override
    public products getProductById(Long id) {
        ProductDto prdto = template.getForObject("https://fakestoreapi.com/products"+id, ProductDto.class);
        return convertToProducts(prdto);
    }

    @Override
    public ArrayList<products> getAllProducts() {
        ProductDto[] prdtos = template.getForObject("https://fakestoreapi.com/products", ProductDto[].class);
        ArrayList<products> products = new ArrayList<>();
        for(int i = 0; i < prdtos.length;i++){
            products.add(convertToProducts(prdtos[i]));
        }
        return products;
    }
}
