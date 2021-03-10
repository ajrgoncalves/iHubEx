package i.ub.antonio.goncalves.demo.mappers;

import i.ub.antonio.goncalves.demo.models.OrderModel;
import i.ub.antonio.goncalves.demo.models.Product;
import i.ub.antonio.goncalves.demo.modelsDto.CreateOrderModelDto;
import i.ub.antonio.goncalves.demo.modelsDto.OrderModelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    @Autowired
    private ProductMapper productMapper;

    public OrderModelDto mapperToDto(OrderModel orderModel) {
        return OrderModelDto.builder()
                .id(orderModel.getId())
                .creationDate(orderModel.getCreationDate())
                .buyerEmail(orderModel.getBuyerEmail())
                .deleted(orderModel.getDeleted())
                .productsDtos(orderModel.getProducts().stream().map(product -> productMapper.mapperToDto(product)).collect(Collectors.toList()))
                .build();
    }

    public OrderModel mapperFromDto(OrderModelDto orderModelDto) {
        return OrderModel.builder()
                .id(orderModelDto.getId())
                .creationDate(orderModelDto.getCreationDate())
                .buyerEmail(orderModelDto.getBuyerEmail())
                .deleted(orderModelDto.getDeleted())
                .build();
    }

    //This will be used only on create calls
    public CreateOrderModelDto mapperToDtoCreate(OrderModel orderModel) {
        return CreateOrderModelDto.builder()
                .id(orderModel.getId())
                .creationDate(orderModel.getCreationDate())
                .buyerEmail(orderModel.getBuyerEmail())
                .deleted(orderModel.getDeleted())
                .productIds(orderModel.getProducts().stream().map(product -> product.getId()).collect(Collectors.toList()))
                .build();
    }

    public OrderModel mapperFromDtoCreate(CreateOrderModelDto createOrderModelDto) {
        return OrderModel.builder()
                .id(createOrderModelDto.getId())
                .creationDate(createOrderModelDto.getCreationDate())
                .buyerEmail(createOrderModelDto.getBuyerEmail())
                .deleted(createOrderModelDto.getDeleted())
                .build();
    }

}
