package service;




import model.User; //
import repo.UserRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class) // анотация от JUnit что бы все заработало
public class UserServiceTest {

    private static final String USER_NAME = "TEST_NAME"; // это константы для работы
    private static final String USER_PASSWORD = "TEST_PASSWORD";


    @Mock
    UserRepo userRepo; //Все ссылки что есть в UserService (тоесть в том что будет тестироваться)
    // добавляются в сетсовый класс

    @Mock
    AccountService accountService; //

    @InjectMocks
    UserService userService;//  то что мы будем тестировать (тест для userService)


    @Test
    public void testGetKeyForUser() {// описываем те объекты которые будут возвращаться из юзера
        Long id = 48459854852L;
        User user = new User(id, USER_NAME, USER_PASSWORD, null); //создаем юзера с конкретными параметрами

        Long accountId = 345345L;// создан accountId для использования в тесте

// описываем поведение моков
        when(userRepo.createUser(USER_NAME, USER_PASSWORD)).thenReturn(user);
        //когда будет вызван userRepo.createUser у мокко userRepo с вполне конкретными данными (USER_NAME, USER_PASSWORD)
        // а потом верни юзера thenReturn(user)
        when(accountService.createAccountByUserId(user.getId())).thenReturn(accountId);
        //когда будет вызван accountService.createAccountByUserId(user.getId())) с конкретным ID того эзера
        // которого вызывали в предыдущем методе то верни thenReturn(accountId)
        when(userRepo.save(user)).thenReturn(user);
        //

        User result = userService.createUserWithAccount(USER_NAME, USER_PASSWORD); // мы хотим протестировать метод
        // createUserWithAccount

        Assert.assertEquals(accountId, result.getAccountId());
        Assert.assertEquals(id, user.getId());

        verify(userRepo).createUser(USER_NAME, USER_PASSWORD); // проверяет что метод был вызват с нужными параметрами
        verify(accountService).createAccountByUserId(user.getId());
        verify(userRepo).save(user);
    }
}