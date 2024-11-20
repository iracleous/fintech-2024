package gr.oteshop.tech.services;

import gr.oteshop.tech.models.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountManager implements  AccountService{
    @Override
    public void transferFunds(Long fromAccountId, Long toAccountId, Double amount) {

    }

    @Override
    public Optional<Account> findUserAccount(String userName) {
        return Optional.empty();
    }

    @Override
    public boolean existsByBalanceGreaterThan(double amount) {
        return false;
    }
}
