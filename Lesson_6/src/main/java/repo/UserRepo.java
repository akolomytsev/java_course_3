package repo;

import lombok.extern.log4j.Log4j2;
import model.User;

@Log4j2
public class UserRepo {
    public User createUser(String userName, String  password){
 //       DB WORKS
            log.info("User with user name {} has been created", userName);
             User user = new User();
             user.setId(1L);
             user.setUsername(userName);
             user.setPassword(password);
             return user;
    }

    public User save(User user){
        // DB WORKS

        log.info(" User with id {} has been saved", user.getId());
        return user;
    }

    public User loginUser(String userName, String  password) throws Exception {
        //       DB WORKS
        log.info("User with user name {} has been logged in", userName);
        if (true){
            throw new Exception();
        }
        User user = new User();
//        user.setId(1L);
//        user.setUsername(userName);
//        user.setPassword(password);
        return user;
    }
}
