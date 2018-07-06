package com.decathlon.orderservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.decathlon.orderservices.bean.DecaOrder;

@Repository
public interface OrderRepository extends JpaRepository<DecaOrder, Long> {

}
