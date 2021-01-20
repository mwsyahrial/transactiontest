package com.transaction.demo.repository;

import com.transaction.demo.model.Transactions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Long> {
    @Query("SELECT t.transactionId FROM Transactions t WHERE t.type = ?1")
    List<Long> findByType(String type);

    @Query("SELECT SUM(amount) FROM Transactions WHERE parentId = CAST(?1 as string) or transactionId = ?1 ")
    Double findSum(Long id);

}
