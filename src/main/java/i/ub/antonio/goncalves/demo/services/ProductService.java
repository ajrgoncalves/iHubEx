package i.ub.antonio.goncalves.demo.services;

import i.ub.antonio.goncalves.demo.mappers.ProductMapper;
import i.ub.antonio.goncalves.demo.models.OrderModel;
import i.ub.antonio.goncalves.demo.models.Product;
import i.ub.antonio.goncalves.demo.modelsDto.OrderModelDto;
import i.ub.antonio.goncalves.demo.modelsDto.ProductDto;
import i.ub.antonio.goncalves.demo.repositories.OrderRepository;
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
        return productRepository.findByDeleted(true).stream()
                .map(product -> productMapper.mapperToDto(product)).collect(Collectors.toList());
    }

    public List<ProductDto> getAllProductsActive() {
        return productRepository.findByDeleted(false).stream()
                .map(product -> productMapper.mapperToDto(product)).collect(Collectors.toList());
    }

    public ProductDto save(ProductDto productDto) {

        Product product  = productRepository
                .save(productMapper.mapperFromDto(productDto));

        return productMapper.mapperToDto(product);
    }

    public void delete(Long id) throws NotFoundException {
        Product product = productRepository.findById(id).get();
        product.setDeleted(true);
        productRepository.save(product);
    }

    public void recover(Long id) throws NotFoundException {
        Product product = productRepository.findById(id).get();
        product.setDeleted(false);
        productRepository.save(product);
    }
}
