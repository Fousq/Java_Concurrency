package kz.zhanbolat.concurrency.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.zhanbolat.concurrency.entity.UserAccount;
import kz.zhanbolat.concurrency.repository.UserAccountRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class UserAccountRepositoryImpl extends AbstractRepository implements UserAccountRepository {
    private static final Logger logger = LogManager.getLogger(UserAccountRepositoryImpl.class);

    public UserAccountRepositoryImpl(ObjectMapper objectMapper) {
        super(objectMapper);
    }

    public Optional<UserAccount> getUserAccount(File file) {
        checkParameters(file);
        try {
            return Optional.of(objectMapper.readValue(file, UserAccount.class));
        } catch (IOException e) {
            logger.error("Failed to load from file " + file.getPath() + ". Caused by: " + e);
        }
        return Optional.empty();
    }

    public void updateUserAccount(File file, UserAccount userAccount) {
        try {
            objectMapper.writeValue(file, userAccount);
            logger.info("The account was update. File: " + file.getPath());
        } catch (IOException e) {
            logger.error("Failed to write to file " + file.getPath() + ". Caused by " + e);
        }
    }
}
