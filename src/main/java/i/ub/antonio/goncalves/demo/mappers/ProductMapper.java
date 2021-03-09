package i.ub.antonio.goncalves.demo.mappers;

import i.ub.antonio.goncalves.demo.models.OrderModel;
import i.ub.antonio.goncalves.demo.models.Product;
import i.ub.antonio.goncalves.demo.modelsDto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDto mapperToDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .creationDate(product.getCreationDate())
                .name(product.getName())
                .orderModelId(product.getOrderModel().getId())
                .deleted(product.getDeleted())
                .build();
    }

    public Product mapperFromDto(ProductDto productDto, OrderModel orderModel) {
        return Product.builder()
                .id(productDto.getId())
                .creationDate(productDto.getCreationDate())
                .name(productDto.getName())
                .orderModel(orderModel)
                .deleted(productDto.getDeleted())
                .build();
    }
}
