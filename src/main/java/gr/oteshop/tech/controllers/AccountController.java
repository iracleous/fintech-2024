package gr.oteshop.tech.controllers;

import gr.oteshop.tech.models.Account;
import gr.oteshop.tech.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/transfer")
    public ResponseEntity<String> transferFunds(@RequestParam Long fromAccountId,
                                                @RequestParam Long toAccountId,
                                                @RequestParam Double amount) {
        try {
            accountService.transferFunds(fromAccountId, toAccountId, amount);
            return ResponseEntity.ok("Transfer successful");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @GetMapping("{name}")
    public ResponseEntity<Optional<Account>> getAccount(@PathVariable String name) {
        return  ResponseEntity.ok(accountService.findUserAccount(name));
    }

    @GetMapping("/fund/{amount}")
    public ResponseEntity<Boolean> getAccount(@PathVariable Double amount) {
        return  ResponseEntity.ok(accountService.existsByBalanceGreaterThan(amount));
    }

}