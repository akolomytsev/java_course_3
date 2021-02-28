import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Connection connection = getConnection();

        try {
               Statement statement = connection.createStatement(); // закрытие процесса горонтирует компилятор

            statement.executeUpdate("insert into students (Name, GroupNanme, Score) values ('Alex', 'CS', 5 )");
            Savepoint sp = connection.setSavepoint(); // при откате вернется все что был до этого Savepoint
            statement.executeUpdate("insert into students (Name, GroupNanme, Score) values ('Katy', 'CS', 5 )");
            connection.rollback(sp); // откат операции если что то пошло не так
            statement.executeUpdate("insert into students (Name, GroupNanme, Score) values ('Fil', 'CS', 5 )");
            connection.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }



    }
    private  static void commitExBatch() throws Exception{
        Connection connection = getConnection();
        String req = "insert into students (Name, GroupNanme, Score) values (?, ?, ? )"; // перевод: вставить в таблицу студенты.
        // В скобочках указываем имена колонок в которые хотим вставить  и пишем values, знак вопроса передает
        // что это точно надо передавать
        Long start = System.currentTimeMillis(); // Засекаем начало выполнения операции
        try (PreparedStatement preparedStatement = connection.prepareStatement(req)){ // закрытие процесса горонтирует компилятор
            connection.setAutoCommit(false); // выключение автокамита для ускарения записи в БД (надо где то вкл иначе записей не будет)
            for (int i = 0; i < 10000; i++) { // должно 10000 раз заполнить нашу баду данными ниже
                preparedStatement.setString(1, "John");
                preparedStatement.setString(2, "CS_" +i);
                preparedStatement.setInt(3, i * 17 % 5);
                preparedStatement.addBatch(); // формирует запрос целиком в пакет и только потом отправляет в БД
                // что ускоряет работу

            }
            preparedStatement.executeBatch();
            connection.commit(); // включили автокоммит

        }catch (Exception e) {
            e.printStackTrace();
        }
        Long finish = System.currentTimeMillis(); // Засекаем конец выполнения операции
        System.out.println("Time is: " + (finish - start)); // выводим время выполнения операции
    }



    private  static void commitEx() throws Exception{
        Connection connection = getConnection();
        String req = "insert into students (Name, GroupNanme, Score) values (?, ?, ? )"; // перевод: вставить в таблицу студенты.
        // В скобочках указываем имена колонок в которые хотим вставить  и пишем values, знак вопроса передает
        // что это точно надо передавать
        Long start = System.currentTimeMillis(); // Засекаем начало выполнения операции
        try (PreparedStatement preparedStatement = connection.prepareStatement(req)){ // закрытие процесса горонтирует компилятор
            connection.setAutoCommit(false); // выключение автокамита для ускарения записи в БД (надо где то вкл иначе записей не будет)
            for (int i = 0; i < 10000; i++) { // должно 10000 раз заполнить нашу баду данными ниже
                preparedStatement.setString(1, "John");
                preparedStatement.setString(2, "CS_" +i);
                preparedStatement.setInt(3, i * 17 % 5);
                preparedStatement.executeUpdate(); // выполняет обновление в БД

            }
            connection.commit(); // включили автокоммит

        }catch (Exception e) {
            e.printStackTrace();
        }
        Long finish = System.currentTimeMillis(); // Засекаем конец выполнения операции
        System.out.println("Time is: " + (finish - start)); // выводим время выполнения операции


    }


    private static void statementVsPS () throws Exception{
        String name = "Sania";
        Connection connection = getConnection(); // метод ниже
        Statement statement = connection.createStatement(); //
        ResultSet resultSet = statement.executeQuery("select * from students where Name = '" + name +"'"); // Пытаемся вытащить из таблицы все
        print(resultSet);// метод ниже


        System.out.println("Injected version");
        String injectedName = "A' or 1 = 1;";  //никогда не применять
        ResultSet injectedResultSet = statement.executeQuery("select * from students where Name = '" + injectedName +"'"); // Пытаемся вытащить из таблицы все
        print(injectedResultSet);// метод ниже


        String preparedStatementSQL = "select * from students where Name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(preparedStatementSQL);
        preparedStatement.setString(1, injectedName);
        ResultSet injectedResultSetPS = preparedStatement.executeQuery();
        print(injectedResultSetPS);

        resultSet.close();
        statement.close();
        connection.close();
    }


    private static void firstSelect () throws Exception{
        Connection connection = getConnection(); // метод ниже
        Statement statement = connection.createStatement(); //
        ResultSet resultSet = statement.executeQuery("select * from students"); // Пытаемся вытащить из таблицы все
        print(resultSet);// метод ниже
        resultSet.close();
        statement.close();
        connection.close();
    }

    private static void print(ResultSet resultSet) throws SQLException { // метод чисто для печати в консоль
        while (resultSet.next()){      // пробегаем по всем рядам при помощи этого метода
            System.out.print(resultSet.getLong("StudID") + " "); // обязательно указываем правльный тип данных
            System.out.print(resultSet.getString("Name") + " "); // иначе считает нуль
            System.out.print(resultSet.getString("GroupNanme") + " ");
            System.out.print(resultSet.getLong("Score") + " ");
        }
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException { // метод для подключения к БД
        Class.forName("org.sqlite.JDBC"); // Метод который загружает класс самого себя
        Connection connection = DriverManager.getConnection("jdbc:sqlite:Lesson_2/mydatabase.db"); //подключаем базу данных
        // и прописываем к ней путь
        return connection;
    }
}
