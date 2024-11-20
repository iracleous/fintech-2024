package gr.oteshop.tech.services;

import gr.oteshop.tech.models.Account;
import gr.oteshop.tech.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public void transferFunds(Long fromAccountId, Long toAccountId, Double amount) {
        Account fromAccount = accountRepository
                .findById(fromAccountId)
                .orElseThrow(() -> new IllegalArgumentException("Source account not found"));
        Account toAccount = accountRepository
                .findById(toAccountId)
                .orElseThrow(() -> new IllegalArgumentException("Target account not found"));

// Deduct amount from source account
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        accountRepository.save(fromAccount);

// Simulate a failure (e.g., network issue, validation error)
        if (amount > 1000) {
            throw new IllegalArgumentException("Transfer amount exceeds limit");
        }

// Add amount to target account
        toAccount.setBalance(toAccount.getBalance() + amount);
        accountRepository.save(toAccount);
    }
}
