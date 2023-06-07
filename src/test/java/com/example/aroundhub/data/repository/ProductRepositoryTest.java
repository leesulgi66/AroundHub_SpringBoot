package com.example.aroundhub.data.repository;

import com.example.aroundhub.data.entity.ProductEntity;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @BeforeEach
    void GenerateData() {
        int count = 1;
        productRepository.save(getProduct(Integer.toString(count), count++, 2000, 3000));
        productRepository.save(getProduct(Integer.toString(count), count++, 1500, 200));
        productRepository.save(getProduct(Integer.toString(--count), count = count + 2, 1500, 200));
        productRepository.save(getProduct(Integer.toString(count), count++, 4000, 3000));
        productRepository.save(getProduct(Integer.toString(count), count++, 10000, 1500));
        productRepository.save(getProduct(Integer.toString(count), count++, 10000, 1000));
        productRepository.save(getProduct(Integer.toString(count), count++, 500, 10000));
        productRepository.save(getProduct(Integer.toString(count), count++, 8500, 3500));
        productRepository.save(getProduct(Integer.toString(count), count++, 1000, 2000));
        productRepository.save(getProduct(Integer.toString(count), count++, 5100, 1700));
    }

    private ProductEntity getProduct(String id, int nameNumber, int price, int stock) {
        return new ProductEntity(id, "Product" + nameNumber, price, stock);
    }

    @Test
    void findTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for(ProductEntity productEntity : foundAll) {
            System.out.println(productEntity.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        List<ProductEntity> foundEntities = productRepository.findByProductName("Product4");

        for(ProductEntity productEntity : foundEntities) {
            System.out.println(productEntity.toString());
        }

        List<ProductEntity> queryEntities = productRepository.queryByProductName("Product4");

        for(ProductEntity productEntity : queryEntities) {
            System.out.println(productEntity.toString());
        }

    }

    @Test
    void existTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for(ProductEntity productEntity : foundAll) {
            System.out.println(productEntity.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        System.out.println(productRepository.existsByProductName("Product4"));
    }

    @Test
    void countTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for(ProductEntity productEntity : foundAll) {
            System.out.println(productEntity.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        System.out.println(productRepository.countByProductName("Product4"));
    }

    @Test
    @Transactional
    void deleteTest() {
        System.out.println("before : "+productRepository.count());

        productRepository.deleteByProductId("1");
        productRepository.deleteByProductId("9");

        System.out.println("After : "+productRepository.count());
    }

    @Test
    void topTest() {
        productRepository.save(getProduct("100", 123, 1500, 5000));
        productRepository.save(getProduct("101", 123, 2500, 5000));
        productRepository.save(getProduct("102", 123, 3500, 5000));
        productRepository.save(getProduct("103", 123, 4500, 5000));
        productRepository.save(getProduct("104", 123, 1000, 5000));
        productRepository.save(getProduct("105", 123, 2000, 5000));
        productRepository.save(getProduct("106", 123, 3000, 5000));
        productRepository.save(getProduct("107", 123, 4000, 5000));

        List<ProductEntity> foundEntities = productRepository.findFirst5ByProductName("Product123"); // 별도의 정렬 쿼리가 없다면 기본적으로 아이디로 정렬된다.
        for(ProductEntity productEntity : foundEntities) {
            System.out.println(productEntity.toString());
        }

        List<ProductEntity> foundEntities2 = productRepository.findTop3ByProductName("Product123");
        for(ProductEntity productEntity : foundEntities2) {
            System.out.println(productEntity.toString());
        }
    }

    /* 조건자 키워드 테스트 */

    @Test
    void isEqualsTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for(ProductEntity productEntity : foundAll) {
            System.out.println(productEntity.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        System.out.println(productRepository.findByProductIdIs("1"));
        System.out.println(productRepository.findByProductIdEquals("1"));

    }

    @Test
    void notTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for(ProductEntity productEntity : foundAll) {
            System.out.println(productEntity.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        List<ProductEntity> foundEntities = productRepository.findByProductIdNot("1");
        for(ProductEntity productEntity : foundEntities) {
            System.out.println(productEntity);
        }

        System.out.println(productRepository.findByProductIdIsNot("1"));
    }

    @Test
    void nullTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for(ProductEntity productEntity : foundAll) {
            System.out.println(productEntity.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        System.out.println(productRepository.findByProductStockIsNull());
        System.out.println(productRepository.findByProductStockIsNotNull());
    }

    @Test
    void andTest(){
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for(ProductEntity productEntity : foundAll) {
            System.out.println(productEntity.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        System.out.println(productRepository.findTopByProductIdAndProductName("1", "Product1"));
    }

    @Test
    void greaterTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for(ProductEntity productEntity : foundAll) {
            System.out.println(productEntity.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        List<ProductEntity> productEntities = productRepository.findByProductPriceGreaterThan(5000);

        for(ProductEntity productEntity : productEntities) {
            System.out.println(productEntity);
        }
    }

    @Test
    void containTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for(ProductEntity productEntity : foundAll) {
            System.out.println(productEntity.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        System.out.println(productRepository.findByProductNameContaining("Product1"));
    }



    /* 정렬과 페이징 */
    @Test
    void orderByTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for(ProductEntity productEntity : foundAll) {
            System.out.println(productEntity.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        List<ProductEntity> foundProducts = productRepository.findByProductNameContainingOrderByProductStockAsc("Product");
        System.out.println("--------------- sort stock asc ----------------");
        for(ProductEntity product : foundProducts) {
            System.out.println(product);
        }

        foundProducts = productRepository.findByProductNameContainingOrderByProductStockDesc("Product");
        System.out.println("--------------- sort stock desc ----------------");
        for(ProductEntity product : foundProducts) {
            System.out.println(product);
        }
    }

    @Test
    void multiOrderByTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for(ProductEntity productEntity : foundAll) {
            System.out.println(productEntity.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        List<ProductEntity> foundProducts = productRepository.findByProductNameContainingOrderByProductPriceAscProductStockDesc("Product");
        System.out.println("--------------- sort price & stock ----------------");
        for(ProductEntity product : foundProducts) {
            System.out.println(product);
        }
    }

    @Test
    void orderByWithParameterTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for(ProductEntity productEntity : foundAll) {
            System.out.println(productEntity.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        List<ProductEntity> foundProducts = productRepository.findByProductNameContaining("Product", Sort.by(Sort.Order.asc("ProductPrice")));
        System.out.println("--------------- order by with parameter(product, price) ----------------");
        for(ProductEntity product : foundProducts) {
            System.out.println(product);
        }

        foundProducts = productRepository.findByProductNameContaining("Product", Sort.by(Sort.Order.asc("ProductPrice"), Sort.Order.asc("ProductStock")));
        System.out.println("--------------- order by with parameter(price, stock) ----------------");
        for(ProductEntity product : foundProducts) {
            System.out.println(product);
        }
    }

    @Test
    void pagingTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for(ProductEntity productEntity : foundAll) {
            System.out.println(productEntity.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        List<ProductEntity> foundProducts = productRepository.findByProductPriceGreaterThan(200, PageRequest.of(0, 2));
        System.out.println("--------------- paging(0, 2) ----------------");
        for(ProductEntity product : foundProducts) {
            System.out.println(product);
        }

        foundProducts = productRepository.findByProductPriceGreaterThan(200, PageRequest.of(4, 2));
        System.out.println("--------------- paging(4, 2) ----------------");
        for(ProductEntity product : foundProducts) {
            System.out.println(product);
        }
    }
}
