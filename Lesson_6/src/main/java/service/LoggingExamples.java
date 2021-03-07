package service;


import lombok.extern.log4j.Log4j2;
import repo.AccountRepo;
import repo.UserRepo;

@Log4j2
public class LoggingExamples {
    public static void main(String[] args) throws Exception {
        UserService userService = new UserService(new UserRepo(), new AccountService(new AccountRepo()));
        userService.login("kWUEFGHEU", "123");

    }
}
