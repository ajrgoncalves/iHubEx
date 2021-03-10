package i.ub.antonio.goncalves.demo.mappers;

import i.ub.antonio.goncalves.demo.models.Product;
import i.ub.antonio.goncalves.demo.modelsDto.ProductDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class ProductMapperTest {

    @Autowired
    ProductMapper productMapper;

    private Product productOne;

    private ProductDto productOneDto;


    @BeforeEach
    public void setUp() {

        productOne = Product.builder()
                .price(10)
                .active(true)
                .name("Product 1")
                .creationDate(new Date())
                .build();


        productOneDto = ProductDto.builder()
                .price(10)
                .active(true)
                .name("Product 1")
                .creationDate(new Date())
                .build();
    }

    @Test
    public void mapperToDto() {

        assertEquals(productOneDto, productMapper.mapperToDto(productOne));
    }

    @Test
    public void mapperFromDto() {
        assertEquals(productOne, productMapper.mapperFromDto(productOneDto));
    }
}