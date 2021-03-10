package i.ub.antonio.goncalves.demo.services;

import i.ub.antonio.goncalves.demo.mappers.ProductMapper;
import i.ub.antonio.goncalves.demo.models.Product;
import i.ub.antonio.goncalves.demo.modelsDto.ProductDto;
import i.ub.antonio.goncalves.demo.repositories.ProductRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderService orderService;


    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> productMapper.mapperToDto(product)).collect(Collectors.toList());
    }

    public List<ProductDto> getAllProductsDeleted() {
        return productRepository.findByActive(false).stream()
                .map(product -> productMapper.mapperToDto(product)).collect(Collectors.toList());
    }

    public List<ProductDto> getAllProductsActive() {
        return productRepository.findByActive(true).stream()
                .map(product -> productMapper.mapperToDto(product)).collect(Collectors.toList());
    }

    public ProductDto save(ProductDto productDto) {

        Product product  = productRepository
                .save(productMapper.mapperFromDto(productDto));

        return productMapper.mapperToDto(product);
    }

    public ProductDto delete(Long id) throws NotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new org.webjars.NotFoundException("Product not found for id: %d" + id));
        product.setActive(false);
        productRepository.save(product);
        return productMapper.mapperToDto(product);
    }

    public ProductDto recover(Long id) throws NotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new org.webjars.NotFoundException("Product not found for id: %d" + id));
        product.setActive(true);
        productRepository.save(product);
        return productMapper.mapperToDto(product);
    }

    public ProductDto update(ProductDto productDto){
        Product product = productRepository.findById(productDto.getId())
                .orElseThrow(() -> new org.webjars.NotFoundException("Product not found for id: %d" + productDto.getId()));

        product.setActive(productDto.getActive());
        product.setCreationDate(productDto.getCreationDate());
        product.setPrice(productDto.getPrice());
        product.setName(productDto.getName());

        productRepository.save(product);

        return productMapper.mapperToDto(product);
    }
}
