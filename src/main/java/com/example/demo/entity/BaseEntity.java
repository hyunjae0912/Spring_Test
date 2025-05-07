package com.example.demo.entity;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
@EntityListeners(value = { AuditingEntityListener.class }) 
abstract class BaseEntity {
	
	@Column(nullable = false)
    @CreatedDate
    LocalDateTime regDate;

}
