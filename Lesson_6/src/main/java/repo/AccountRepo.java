package repo;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AccountRepo {
    public Long createAccountByUserId(Long userId){
      // DB  WORKS

      Long accountId = 135768463876L;
      log.info("For user with is {} have been created an account {} " , userId, accountId);
      return accountId;
    }
}
