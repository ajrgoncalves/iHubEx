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
                .deleted(product.getDeleted())
                .price(product.getPrice())
                .build();
    }

    public Product mapperFromDto(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .creationDate(productDto.getCreationDate())
                .name(productDto.getName())
                .deleted(productDto.getDeleted())
                .price(productDto.getPrice())
                .build();
    }
}
