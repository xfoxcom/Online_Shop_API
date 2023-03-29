package com.boev.shop.stock.service.serviceImpl;

import com.boev.shop.stock.dto.DiscountDto;
import com.boev.shop.stock.entity.Discount;
import com.boev.shop.stock.entity.Product;
import com.boev.shop.stock.dto.ProductDto;
import com.boev.shop.stock.exception.ProductNotFoundException;
import com.boev.shop.stock.mapper.ProductMapper;
import com.boev.shop.stock.repository.ProductRepository;
import com.boev.shop.stock.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Override
    @Transactional
    public void addNewProduct(ProductDto productDto) {

        Product product = productMapper.productDtoToProduct(productDto);

        productRepository.save(product);
    }

    @Override
    @Transactional
    public void updateProduct(long id, ProductDto productDto) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("No product with id: " + id));

        productMapper.updateProductFromDto(productDto, product);

        productRepository.save(product);
    }

    @Override
    public List<ProductDto> getAllAvailableProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::productToProductDto)
                .toList();
    }

    @Override
    public ProductDto getProductByTitle(String title) {

       Product product = productRepository.findByTitle(title)
                .orElseThrow(() -> new ProductNotFoundException("No product with title " + title));

       return productMapper.productToProductDto(product);
    }

    @Override
    @Transactional
    public void addDiscounts(DiscountDto discountDto) {

      long count = discountDto.getTitles().stream()
                .map(title -> productRepository.findByTitle(title).orElseThrow(() -> new ProductNotFoundException("No product " + title)))
                .peek(product -> product.setDiscount(new Discount(discountDto)))
                .count();

      log.info("Updated " + count + " discounts.");
    }
}
