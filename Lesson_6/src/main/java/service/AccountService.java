package service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import repo.AccountRepo;

@RequiredArgsConstructor
@Log4j2
public class AccountService {
    private final AccountRepo accountRepo;

    public Long createAccountByUserId(Long id){
        log.info("Account for user {} has been created", id);
        return  accountRepo.createAccountByUserId(id);

    }
}
