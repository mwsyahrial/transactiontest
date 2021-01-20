package com.transaction.demo.controller;

import com.transaction.demo.model.TransactionSumResponse;
import com.transaction.demo.model.Transactions;
import com.transaction.demo.model.TransactionResponse;
import com.transaction.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transactionservice/")
public class TransactionController {
    @Autowired
    TransactionRepository transactionRepository;

    @RequestMapping(value="transaction/{id}",method = RequestMethod.PUT)
    public TransactionResponse save(@PathVariable Long id, @RequestBody Transactions transactions){
        transactions.setTransactionId(id);

        Transactions trx = transactionRepository.saveAndFlush(transactions);
        return trx != null && trx.getTransactionId() != null ? new TransactionResponse("ok")
                : new TransactionResponse("failed");
    }

    @RequestMapping(value="transaction/{id}",method = RequestMethod.GET)
    public Transactions get(@PathVariable Long id) {
        return transactionRepository.findById(id).get();
    }

    @RequestMapping(value="types/{type}",method = RequestMethod.GET)
    public List<Long> getTransactionTypes(@PathVariable String type) {
        return transactionRepository.findByType(type);
    }

    @RequestMapping(value="types/sum/{id}",method = RequestMethod.GET)
    public TransactionSumResponse getTransactionSum(@PathVariable Long id) {
        return new TransactionSumResponse(transactionRepository.findSum(id));
    }
}