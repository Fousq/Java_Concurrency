package kz.zhanbolat.concurrency.service.impl;

import kz.zhanbolat.concurrency.entity.UserAccount;
import kz.zhanbolat.concurrency.exception.FailedLoadUserAccountException;
import kz.zhanbolat.concurrency.repository.UserAccountRepository;
import kz.zhanbolat.concurrency.service.AccountManager;

import java.io.File;
import java.util.Optional;

public class AccountManagerImpl implements AccountManager {
    private final File userAccountFile;
    private UserAccount userAccount;
    private final UserAccountRepository userAccountRepository;

    public AccountManagerImpl(File userAccountFile, UserAccountRepository userAccountRepository) {
        this.userAccountFile = userAccountFile;
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public void loadAccount() throws FailedLoadUserAccountException {
        if (userAccountFile.isDirectory()) {
            throw new IllegalArgumentException("User account should be a file");
        }
        Optional<UserAccount> loadedUserAccount = userAccountRepository.getUserAccount(userAccountFile);
        if (!loadedUserAccount.isPresent()) {
            throw new FailedLoadUserAccountException("Failed to load user account from file " + userAccountFile.getPath());
        }
        userAccount = loadedUserAccount.get();
    }

    @Override
    public UserAccount getUserAccount() {
        return userAccount;
    }

    @Override
    public void updateAccount(UserAccount updatedUserAccount) {
        userAccountRepository.updateUserAccount(userAccountFile, updatedUserAccount);
    }
}
