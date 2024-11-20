package gr.oteshop.tech.services;

import org.springframework.stereotype.Service;

@Service
public class AccountManager implements  AccountService{
    @Override
    public void transferFunds(Long fromAccountId, Long toAccountId, Double amount) {

    }
}
