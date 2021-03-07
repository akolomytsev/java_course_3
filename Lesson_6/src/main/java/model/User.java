package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // если добавит data от lombok то создается класс в котором определены все методы
@AllArgsConstructor // добавляет this
// если порыться в lombok то можно найти кучу интересного
public class User {
    private  Long id;
    private String username;
    private String password;
    private Long accountId;
   // private String color;


    public User() {

    }
}
