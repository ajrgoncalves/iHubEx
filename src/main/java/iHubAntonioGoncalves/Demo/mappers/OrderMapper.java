package iHubAntonioGoncalves.Demo.mappers;

import iHubAntonioGoncalves.Demo.models.OrderModel;
import iHubAntonioGoncalves.Demo.modelsDto.OrderModelDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderModelDto mapperToDto(OrderModel orderModel) {
        return OrderModelDto.builder()
                .id(orderModel.getId())
                .creationDate(orderModel.getCreationDate())
                .buyerEmail(orderModel.getBuyerEmail())
                .build();
    }

    public OrderModel mapperFromDto(OrderModelDto orderModelDto) {
        return OrderModel.builder()
                .id(orderModelDto.getId())
                .creationDate(orderModelDto.getCreationDate())
                .buyerEmail(orderModelDto.getBuyerEmail())
                .build();
    }

}
