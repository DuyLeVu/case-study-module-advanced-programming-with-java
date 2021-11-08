package com.service.Impl;

import com.model.Account;
import com.model.Song;
import com.service.GeneralService;

import java.util.List;

public class AccountManageImpl implements GeneralService<Account> {
    private List<Account> listAccount;

    public AccountManageImpl() {
    }

    public AccountManageImpl(List<Account> listAccount) {
        this.listAccount = listAccount;
    }

    @Override
    public void create(Account account) {
        listAccount.add(account);
    }

    @Override
    public void delete(String username) {
        int index = findIndexByName(username);
        if (index == -1) System.out.println("This Account is not available");
        else listAccount.remove(index);
    }

    @Override
    public void update(String name, String newName) {

    }

    @Override
    public void findByName(String name) {

    }

    @Override
    public List<Account> displayAll() {
        return null;
    }

    @Override
    public void display() {
        for (Account account : listAccount){
            System.out.println(account);
        }
    }

    @Override
    public int findIndexByName(String name) {
        int indexOf = -1;
        for (int i = 0; i < listAccount.size(); i++) {
            if (listAccount.get(i).getUsername().equals(name)) {
                indexOf = i;
                break;
            }
        }
        return indexOf;
    }
}
