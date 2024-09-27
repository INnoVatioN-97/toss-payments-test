package com.example.toss_payments_test.domain.free_lancers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreeLancersRepository extends JpaRepository<FreeLancers, Long>, FreeLancersCustomRepository {

}
