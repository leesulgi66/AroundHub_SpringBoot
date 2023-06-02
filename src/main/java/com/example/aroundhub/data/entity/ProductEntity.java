package com.example.aroundhub.data.entity;

import com.example.aroundhub.data.dto.ProductDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString   // 직접적인 사용은 아니지만, test 환경에서 Entity 값을 확인하기 위함
@Table(name = "product")
public class ProductEntity extends BaseEntity{

    @Id
    String productId;
    String productName;
    Integer productPrice;
    Integer productStock;

    /*
    @Colum
    String sellerId;

    @Colum
    String sellerPhoneNumber;
     */

    public ProductDto toDto() {
        return ProductDto.builder()
            .productId(productId)
            .productName(productName)
            .productPrice(productPrice)
            .productStock(productStock)
            .build();
    }
}
