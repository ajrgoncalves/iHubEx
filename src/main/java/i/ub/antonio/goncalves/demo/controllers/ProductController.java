package i.ub.antonio.goncalves.demo.controllers;

import i.ub.antonio.goncalves.demo.modelsDto.ProductDto;
import i.ub.antonio.goncalves.demo.services.ProductService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    private List<ProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping(path = "/deleted")
    private List<ProductDto> getAllProductsDeleted(){
        return productService.getAllProductsDeleted();
    }

    @GetMapping(path = "/active")
    private List<ProductDto> getAllProductsActive(){
        return productService.getAllProductsActive();
    }

    @PostMapping()
    private ProductDto addProduct(@RequestBody ProductDto productDto)throws NotFoundException{
        return productService.save(productDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) throws NotFoundException {
        productService.delete(id);
    }
    @PostMapping(path = "recover/{id}")
    public void recover(@PathVariable Long id) throws NotFoundException {
        productService.recover(id);
    }
}
