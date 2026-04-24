package com.moneysnap.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;        // Tên khoản chi/thu
    private Double amount;       // Số tiền
    private String type;         // "INCOME" hoặc "EXPENSE"
    private String category;     // Ăn uống, Di chuyển...
    private String imageUrl;     // Link ảnh
    private String note;         // Ghi chú

    @CreationTimestamp
    private LocalDateTime createdAt;
}

