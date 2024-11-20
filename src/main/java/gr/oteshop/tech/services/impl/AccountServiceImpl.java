package gr.oteshop.tech.services.impl;

import gr.oteshop.tech.models.Account;
import gr.oteshop.tech.repositories.AccountRepository;
import gr.oteshop.tech.services.AccountService;
import gr.oteshop.tech.services.SubscriberService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
@AllArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final SubscriberService subscriberService;

    /**
     * This method transfers funds
     * The sum of funds should be equal before and after the transaction
     * produces runtime errors
     * @param fromAccountId bb
     * @param toAccountId bb
     * @param amount bb
     */
    @Override
    @Transactional
    public void transferFunds(Long fromAccountId, Long toAccountId, Double amount) {
        log.debug("Debug.Transfer funds from {} to {}", fromAccountId, toAccountId);
        log.info("Info.Transfer funds started from {} to {}", fromAccountId, toAccountId);
        Account fromAccount = accountRepository
                .findById(fromAccountId)
                .orElseThrow(() ->{
                    log.error("Error the account  {} does not exist", fromAccountId );
                    return new IllegalArgumentException("Source account not found");
                });
        Account toAccount = accountRepository
                .findById(toAccountId)
                .orElseThrow(() -> new IllegalArgumentException("Target account not found"));

        subscriberService.Subscribe();
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
        log.info("Info.Transfer ended using  funds from {} to {}", fromAccountId, toAccountId);
    }

    @Override
    public Optional<Account> findUserAccount(String userName) {
        return accountRepository
                .findAccountByAccountHolderStartingWith(userName)
                .stream()

                .findFirst();
    }

    @Override
    public boolean existsByBalanceGreaterThan(double amount) {
        return  accountRepository.existsByBalanceGreaterThan(amount   );
    }
}
