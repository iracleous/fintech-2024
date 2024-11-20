package gr.oteshop.tech.services;

import gr.oteshop.tech.models.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    /**
     * Fund transfer
     * produces exceptions
     * @param fromAccountId dd
     * @param toAccountId dd
     * @param amount dd
     */
    void transferFunds(Long fromAccountId, Long toAccountId, Double amount);
    Optional<Account> findUserAccount(String userName);

    boolean existsByBalanceGreaterThan(double amount);
}
