package kz.zhanbolat.concurrency.service;

import kz.zhanbolat.concurrency.entity.UserAccount;
import kz.zhanbolat.concurrency.exception.FailedLoadUserAccountException;

public interface AccountManager {
    void loadAccount() throws FailedLoadUserAccountException;
    UserAccount getUserAccount();
    void updateAccount(UserAccount updatedUserAccount);
}
