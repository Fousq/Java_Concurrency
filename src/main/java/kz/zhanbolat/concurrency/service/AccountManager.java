package kz.zhanbolat.concurrency.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import kz.zhanbolat.concurrency.entity.UserAccount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class AccountManager {
    private static final Logger logger = LogManager.getLogger(AccountManager.class);
    private ConcurrentMap<String, UserAccount> userAccountsMap;
    private ObjectMapper mapper;

    public AccountManager() {
        userAccountsMap = new ConcurrentHashMap<>();
        mapper = new YAMLMapper().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);
        mapper.findAndRegisterModules();
    }

    public void loadAccounts(File accountDirectory) {
        if (!accountDirectory.isDirectory()) {
            throw new IllegalArgumentException("To load accounts. The accounts' directory should be specified");
        }
        File[] files = accountDirectory.listFiles();
        Objects.requireNonNull(files);
        if (files.length == 0) {
            throw new IllegalArgumentException("The account directory is empty");
        }

        Arrays.stream(files).forEach(file -> {
            if (file.isDirectory()) {
                loadAccounts(file);
            }
            if (file.getName().endsWith("yml")) {
                try {
                    userAccountsMap.put(file.getPath(), mapper.readValue(file, UserAccount.class));
                } catch (IOException e) {
                    logger.error("Failed to read user account from yml file: " + file.getPath()
                            + ". The cause: " + e);
                }
            }
        });
    }

    public Collection<UserAccount> getUserAccounts() {
        return Collections.unmodifiableCollection(userAccountsMap.values());
    }

    public void updateAccounts(List<UserAccount> userAccounts) {
        userAccountsMap.forEach((path, storedUserAccount) -> {
            for (UserAccount userAccount : userAccounts) {
                if (userAccount.getId() == storedUserAccount.getId()) {
                    try {
                        mapper.writeValue(new File(path), userAccount);
                        logger.info("Update the yml file: " + path);
                    } catch (IOException e) {
                        logger.error("Failed to write updated info to yml file: " + path
                                + ". The cause: " + e.getCause());
                    }
                    break;
                }
            }
        });
    }
}
