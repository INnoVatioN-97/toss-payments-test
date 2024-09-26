package com.example.toss_payments_test.domain.free_lancers;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity(name = "free_lancers")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FreeLancers {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "varchar(20)")
    private String name;

    @Column(name = "email", unique = true, nullable = false, columnDefinition = "varchar(50)")
    private String email;

    @ColumnDefault("0")
    @Builder.Default
    private Long searchCount = 0L;

    @CreatedDate()
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate()
    @Column(nullable = false)
    private LocalDateTime updatedAt;

}
