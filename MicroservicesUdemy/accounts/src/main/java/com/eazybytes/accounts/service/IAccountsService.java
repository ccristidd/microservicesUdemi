package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.model.Customer;

public interface IAccountsService {
    /**
     *
     * @param customerDto - CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNumber);

    CustomerDto fetchAccountByCustomerId(Customer customer);
    boolean updateAccount(CustomerDto customerDto);

    boolean deleteAccount(String mobileNumber);
}
