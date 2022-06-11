package com.kubro.myemployee.api.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kubro.myemployee.entity.BankAccount;
import com.kubro.myemployee.exception.DataFormatException;
import com.kubro.myemployee.service.BankAccountService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1/bank-accounts")
public class BankAccountController extends AbstractRestHandler {

    @Autowired
    private BankAccountService bankAccountService;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createBankAccount(@RequestBody BankAccount bankAccount,
                                 HttpServletRequest request, HttpServletResponse response) {
        BankAccount createdBankAccount = this.bankAccountService.createBankAccount(bankAccount);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdBankAccount.getId()).toString());
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    Page<BankAccount> getAllBankAccount(
                                      @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                      @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                      HttpServletRequest request, HttpServletResponse response) {
        return this.bankAccountService.getAllBankAccounts(page, size);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    BankAccount getBankAccount(
                             @PathVariable("id") Long id,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
        BankAccount bankAccount = this.bankAccountService.getBankAccount(id);
        checkResourceFound(bankAccount);
        return bankAccount;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBankAccount(
                                 @PathVariable("id") Long id, @RequestBody BankAccount bankAccount,
                                 HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.bankAccountService.getBankAccount(id));
        if (id != bankAccount.getId()) throw new DataFormatException("ID doesn't match!");
        this.bankAccountService.updateBankAccount(bankAccount);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBankAccount(
                                 @PathVariable("id") Long id, HttpServletRequest request,
                                 HttpServletResponse response) {
        checkResourceFound(this.bankAccountService.getBankAccount(id));
        this.bankAccountService.deleteBankAccount(id);
    }
}
