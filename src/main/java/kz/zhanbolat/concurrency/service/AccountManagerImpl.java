package kz.zhanbolat.concurrency.service;

import kz.zhanbolat.concurrency.entity.UserAccount;
import kz.zhanbolat.concurrency.repository.UserAccountRepository;
import kz.zhanbolat.concurrency.util.YamlFileLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class AccountManagerImpl implements AccountManager {
    private ConcurrentMap<String, UserAccount> userAccountsMap;
    private UserAccountRepository userAccountRepository;

    public AccountManagerImpl(UserAccountRepository userAccountRepository) {
        userAccountsMap = new ConcurrentHashMap<>();
        this.userAccountRepository = userAccountRepository;
    }

    public void loadAccounts(File accountDirectory) {
        List<File> fileList = YamlFileLoader.loadYamlFiles(accountDirectory.getPath());

        fileList.forEach(file -> userAccountRepository.getUserAccount(file)
                .ifPresent(account -> userAccountsMap.put(file.getPath(), account)));
    }

    public List<UserAccount> getUserAccounts() {
        return new ArrayList<>(userAccountsMap.values());
    }

    public void updateAccounts(List<UserAccount> userAccounts) {
        userAccountsMap.forEach((path, storedUserAccount) -> {
            for (UserAccount userAccount : userAccounts) {
                if (userAccount.getId() == storedUserAccount.getId()) {
                    userAccountRepository.updateUserAccount(new File(path), userAccount);
                    break;
                }
            }
        });
    }
}
