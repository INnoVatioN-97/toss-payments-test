package com.example.toss_payments_test.domain.free_lancers;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "free_lancers")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FreeLancers {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "varchar(20)")
    private String name;

    @Column(name = "email", unique = true, nullable = false, columnDefinition = "varchar(50)")
    private String email;

    @Column()
    private LocalDateTime createdAt;

    @Column()
    private LocalDateTime updateAt;

}
