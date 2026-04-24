package com.moneysnap.backend.service;

import com.moneysnap.backend.entity.Transaction;
import com.moneysnap.backend.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    public Transaction getById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    public Transaction create(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction update(Long id, Transaction updated) {
        Transaction existing = getById(id);
        existing.setTitle(updated.getTitle());
        existing.setAmount(updated.getAmount());
        existing.setType(updated.getType());
        existing.setCategory(updated.getCategory());
        existing.setNote(updated.getNote());
        return transactionRepository.save(existing);
    }

    public void delete(Long id) {
        transactionRepository.deleteById(id);
    }
}
