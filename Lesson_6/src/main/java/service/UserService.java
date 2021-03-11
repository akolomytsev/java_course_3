package service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repo.UserRepo;



@RequiredArgsConstructor
@Log4j2
public class UserService {

    private final UserRepo userRepo;
    private  final AccountService accountService;

    Logger comradeMajor = LogManager.getLogger("comradeMajor");


    public User createUserWithAccount(String userName, String password){
        User user = userRepo.createUser(userName,password);
        user.setAccountId(accountService.createAccountByUserId(user.getId()));
        return userRepo.save(user);
    }

    public void login(String userName, String password){
        log.info("User {} is login in", userName);
        try {
            userRepo.loginUser(userName, password);
        } catch (Exception e){
            comradeMajor.warn("User is logging in with: name - {}, password - {}", userName, password);
            e.printStackTrace();
        }


    }
}
