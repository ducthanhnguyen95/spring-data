package com.example.spring.data.controllers;

import com.example.spring.data.models.Account;
import com.example.spring.data.requests.TransferRequest;
import com.example.spring.data.services.TransferService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest request) {
        transferService.transferMoney(request.getSenderAccountId(), request.getReceiverAccountId(), request.getAmount());
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts(@RequestParam(required = false) String name) {
        if (name == null) return transferService.getAllAccounts();
        return transferService.findAccountsByName(name);

    }
}
