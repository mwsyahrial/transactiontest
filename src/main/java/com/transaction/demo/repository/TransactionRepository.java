package com.transaction.demo.repository;

import com.transaction.demo.model.Transactions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Long> {
//    @Query("SELECT transactionId FROM transactions trx WHERE trx.type = ?1")
    List<Long> findByType(String type);

}
