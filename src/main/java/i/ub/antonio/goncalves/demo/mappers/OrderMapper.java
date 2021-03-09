package i.ub.antonio.goncalves.demo.mappers;

import i.ub.antonio.goncalves.demo.models.OrderModel;
import i.ub.antonio.goncalves.demo.modelsDto.OrderModelDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderModelDto mapperToDto(OrderModel orderModel) {
        return OrderModelDto.builder()
                .id(orderModel.getId())
                .creationDate(orderModel.getCreationDate())
                .buyerEmail(orderModel.getBuyerEmail())
                .deleted(orderModel.getDeleted())
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

}
