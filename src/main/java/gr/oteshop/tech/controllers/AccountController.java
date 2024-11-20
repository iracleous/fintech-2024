package gr.oteshop.tech.controllers;

import gr.oteshop.tech.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}