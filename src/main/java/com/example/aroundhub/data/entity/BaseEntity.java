package com.example.aroundhub.data.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // 엔티티 객체를 데이터베이스에 적용하기 전/후에 콜백을 요청하는 어노테이션
public class BaseEntity {

    @CreatedDate // 엔티티가 저장되는 시점에 자동으로 시간 주입
    @Column(updatable = false)
    private LocalDateTime createdAt;

  /*
  @CreatedBy // 엔티티가 저장되는 시점에 저장 주체가 누구인지 주입
  @Column(updatable = false)
  private String createdBy;
  */

    @LastModifiedDate // 엔티티가 수정되는 시점에 자동으로 시간을 주입
    private LocalDateTime updatedAt;

  /*
  @LastModifiedBy // 엔티티가 수정되는 시점에 수정 주체가 누구인지 주입
  private String updatedBy;
  */

}
