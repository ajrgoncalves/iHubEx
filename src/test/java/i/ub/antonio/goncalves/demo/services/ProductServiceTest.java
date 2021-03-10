package i.ub.antonio.goncalves.demo.services;

import i.ub.antonio.goncalves.demo.mappers.ProductMapper;
import i.ub.antonio.goncalves.demo.models.Product;
import i.ub.antonio.goncalves.demo.modelsDto.ProductDto;
import i.ub.antonio.goncalves.demo.repositories.ProductRepository;
import javassist.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductMapper productMapper;

    @MockBean
    private ProductRepository productRepository;

    private Product productOne;

    private Product productTwo;

    private ProductDto productOneDto;

    private ProductDto productTwoDto;

    private List<ProductDto> products = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        products.clear();

        productOne = Product.builder()
                .price(10)
                .active(true)
                .name("Product 1")
                .creationDate(new Date())
                .build();
        productTwo = Product.builder()
                .price(55)
                .name("Product 2")
                .creationDate(new Date())
                .active(false)
                .build();

        productOneDto = ProductDto.builder()
                .price(10)
                .active(true)
                .name("Product 1")
                .creationDate(new Date())
                .build();
        productTwoDto = ProductDto.builder()
                .price(55)
                .active(false)
                .name("Product 2")
                .creationDate(new Date())
                .build();

        products.add(productOneDto);
        products.add(productTwoDto);
    }

    @Test
    public void getAllProducts() {
        when(productRepository.findAll()).thenReturn(List.of(productOne, productTwo));
                when(productMapper.mapperToDto(eq(productOne))).thenReturn(productOneDto);
        when(productMapper.mapperToDto(eq(productTwo))).thenReturn(productTwoDto);
        assertEquals(products, productService.getAllProducts());
    }

    @Test
    public void getAllProductsDeleted() {

        when(productRepository.findByActive(false)).thenReturn(List.of(productOne, productTwo));
                when(productMapper.mapperToDto(eq(productOne))).thenReturn(productOneDto);
        when(productMapper.mapperToDto(eq(productTwo))).thenReturn(productTwoDto);
        assertEquals(products, productService.getAllProductsDeleted());
    }

    @Test
    public void getAllProductsActive() {
        when(productRepository.findByActive(true)).thenReturn(List.of(productOne, productTwo));
                when(productMapper.mapperToDto(eq(productOne))).thenReturn(productOneDto);
        when(productMapper.mapperToDto(eq(productTwo))).thenReturn(productTwoDto);
        assertEquals(products, productService.getAllProductsActive());
    }

    @Test
    public void save() {

        when(productMapper.mapperToDto(eq(productOne))).thenReturn(productOneDto);
        when(productMapper.mapperFromDto(eq(productOneDto))).thenReturn(productOne);
        when(productRepository.save(eq(productOne))).thenReturn(productOne);

        assertEquals(productOneDto, productService.save(productOneDto));

    }

    @Test
    public void delete() throws NotFoundException {

        when(productRepository.findById(eq(productOne.getId()))).thenReturn(Optional.of(productOne));
        when(productRepository.save(eq(productOne))).thenReturn(productOne);
        productOne.setActive(false);
        productOneDto.setActive(false);

        when(productMapper.mapperToDto(eq(productOne))).thenReturn(productOneDto);

        assertEquals(productOneDto, productService.delete(productOneDto.getId()));
    }

    @Test
    public void recover() throws NotFoundException {

        when(productRepository.findById(eq(productTwo.getId()))).thenReturn(Optional.of(productTwo));
        when(productRepository.save(eq(productTwo))).thenReturn(productTwo);
        productTwo.setActive(true);
        productTwoDto.setActive(true);

        when(productMapper.mapperToDto(eq(productTwo))).thenReturn(productTwoDto);

        assertEquals(productTwoDto, productService.recover(productTwoDto.getId()));
    }
}