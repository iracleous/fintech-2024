package gr.oteshop.tech.services;

public interface AccountService {
    void transferFunds(Long fromAccountId, Long toAccountId, Double amount);
}
