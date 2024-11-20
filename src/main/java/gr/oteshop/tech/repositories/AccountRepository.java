package gr.oteshop.tech.repositories;

import gr.oteshop.tech.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAccountByAccountHolderStartsWith(String accountHolder);
    List<Account> findAccountByAccountHolderStartingWith(String accountHolder);
    List<Account> findAccountByBalanceGreaterThan(Double balance);

    @Query
    List<Account> findAccountByBalanceLessThan(Double balance);

//    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN TRUE ELSE FALSE END FROM Author a WHERE CAST(a.mobileNo AS string) LIKE %:query%")
//    Boolean existsByMobileNoContaining(@Param("query") String query);

    @Query("SELECT CASE WHEN COUNT(0) > 0 THEN TRUE ELSE FALSE END FROM Account a WHERE  a.balance  > :amount")
    Boolean existsByBalanceGreaterThan(@Param("amount") double amount);

}
