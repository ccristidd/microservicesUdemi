package com.eazybytes.loans.service.impl;

import com.eazybytes.loans.dto.LoansDto;
import com.eazybytes.loans.service.ILoansService;

public class ILoansServiceImplv2 implements ILoansService {
    /**
     * @param mobileNumber - Mobile Number of the Customer
     */
    @Override
    public void createLoan(String mobileNumber) {

    }

    /**
     * @param mobileNumber - Input mobile Number
     * @return Loan Details based on a given mobileNumber
     */
    @Override
    public LoansDto fetchLoan(String mobileNumber) {
        return null;
    }

    /**
     * @param loansDto - LoansDto Object
     * @return boolean indicating if the update of card details is successful or not
     */
    @Override
    public boolean updateLoan(LoansDto loansDto) {
        return false;
    }

    /**
     * @param mobileNumber - Input Mobile Number
     * @return boolean indicating if the delete of loan details is successful or not
     */
    @Override
    public boolean deleteLoan(String mobileNumber) {
        return false;
    }
}
