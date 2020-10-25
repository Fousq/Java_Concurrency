package kz.zhanbolat.concurrency.service;

import kz.zhanbolat.concurrency.entity.UserAccount;

import java.io.File;
import java.util.List;

public interface AccountManager {
    void loadAccounts(File accountsDirectory);
    List<UserAccount> getUserAccounts();
    void updateAccounts(List<UserAccount> userAccounts);
}
