package kz.zhanbolat.concurrency.repository;

import kz.zhanbolat.concurrency.entity.UserAccount;

import java.io.File;
import java.util.Optional;

public interface UserAccountRepository {
    Optional<UserAccount> getUserAccount(File file);
    void updateUserAccount(File file, UserAccount userAccount);
}
