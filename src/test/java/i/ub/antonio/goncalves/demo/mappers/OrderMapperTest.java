package i.ub.antonio.goncalves.demo.mappers;

import i.ub.antonio.goncalves.demo.models.OrderModel;
import i.ub.antonio.goncalves.demo.models.Product;
import i.ub.antonio.goncalves.demo.modelsDto.CreateOrderModelDto;
import i.ub.antonio.goncalves.demo.modelsDto.OrderModelDto;
import i.ub.antonio.goncalves.demo.modelsDto.ProductDto;
import i.ub.antonio.goncalves.demo.repositories.ProductRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class OrderMapperTest {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    ProductRepository productRepository;

    private OrderModel orderModel;

    private OrderModelDto orderModelDto;

    private CreateOrderModelDto createOrderModelDto;

    private Product productOne;

    private Product productTwo;

    @BeforeEach
    public void setUp() {

        productOne = Product.builder()
                .price(10)
                .active(true)
                .name("Product 1")
                .creationDate(new GregorianCalendar(2021, Calendar.MARCH, 11).getTime())
                .build();
        productTwo = Product.builder()
                .price(55)
                .name("Product 2")
                .creationDate(new GregorianCalendar(2021, Calendar.MARCH, 11).getTime())
                .active(false)
                .build();

        orderModel = OrderModel.builder()
                .buyerEmail("email@teste.pt")
                .active(true)
                .creationDate(new GregorianCalendar(2021, Calendar.MARCH, 11).getTime())
                .build();

        orderModelDto = OrderModelDto.builder()
                .buyerEmail("email@teste.pt")
                .active(true)
                .creationDate(new GregorianCalendar(2021, Calendar.MARCH, 11).getTime())
                .build();

        createOrderModelDto = CreateOrderModelDto.builder()
                .buyerEmail("email@teste.pt")
                .active(true)
                .creationDate(new Date())
                .build();
    }

    @Test
    void mapperToDto() {
        //First need to add product to Order

//        assertEquals(orderModelDto, orderMapper.mapperToDto(orderModel));
    }

    @Test
    void mapperFromDto() {
//        assertEquals(orderModel, orderMapper.mapperFromDto(orderModelDto));
    }

    @Test
    void mapperToDtoCreate() {
//        assertEquals(orderModelDto, orderMapper.mapperToDtoCreate(orderModel));
    }

    @Test
    void mapperFromDtoCreate() {
//        assertEquals(orderModel, orderMapper.mapperFromDtoCreate(createOrderModelDto));
    }
}