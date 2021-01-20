package com.transaction.demo.controller;

import com.transaction.demo.model.Transaction;
import com.transaction.demo.model.TransactionResponse;
import com.transaction.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transactionservice/")
public class TransactionController {
    @Autowired
    TransactionRepository transactionRepository;

    @RequestMapping(value="/transaction/{id}",method = RequestMethod.PUT)
    public TransactionResponse save(@ModelAttribute("transaction") Transaction transaction){
        Transaction existing = transactionRepository.findOne()
        Transaction trx = transactionRepository.saveAndFlush(transaction);

        return trx != null && trx.getTransactionId() != null ? new TransactionResponse("ok")
                : new TransactionResponse("failed");
    }


}
