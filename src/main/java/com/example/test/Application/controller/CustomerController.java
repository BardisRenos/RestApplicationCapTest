package com.example.test.Application.controller;

import com.example.test.Application.dto.CustomerDTO;
import com.example.test.Application.dto.CustomerTransactionDTO;
import com.example.test.Application.exception.CustomerNotFoundException;
import com.example.test.Application.service.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The Controller layer of User
 */
@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerServiceImpl userService;

    @GetMapping("customer")
    @ResponseStatus(HttpStatus.OK)
    public CustomerTransactionDTO getCustomerWithTransactions(@RequestParam(value = "surname") String surname) throws CustomerNotFoundException {
        return userService.getCustomerWithTransactions(surname);
    }

    @GetMapping("customers")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDTO> getAllCustomers() {
        return userService.getAllCustomers();
    }
}
