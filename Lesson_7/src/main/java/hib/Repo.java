package hib;


import lombok.RequiredArgsConstructor;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@RequiredArgsConstructor
public class Repo<T> {
    private final DataSource dataSource;


    private final String ID = "id";
    private final String INSERT = "insert into %s (%s) values (%s);";
    private final Function<Object, String> prepareString = (s) -> "'" + s + "'";
    private final Function<Object, Integer> prepareInteger = (i) -> Integer.parseInt(i.toString());


    public void createEntity(T entity) throws Exception {
        Class<?> aClass = entity.getClass();
        if (aClass.isAnnotationPresent(Entity.class)) {
            String table = aClass.getAnnotation(Entity.class).table();
            List<String> columns = new ArrayList<>();
            List<String> questionMarks = new ArrayList<>();
            List<String> values = new ArrayList<>();
            List<Class<?>> classes = new ArrayList<>();
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                if (!declaredField.getAnnotation(Column.class).name().equalsIgnoreCase(ID)) {
                    columns.add(declaredField.getAnnotation(Column.class).name());
                    declaredField.setAccessible(true);
                    values.add(declaredField.get(entity).toString());
                    classes.add(declaredField.get(entity).getClass());
                    questionMarks.add("?");
                }
            }
            String column = String.join(", ", columns);
            String questionMark = String.join(", ", questionMarks);
            String request = String.format(INSERT, table, column, questionMark);

            try (Connection connection = dataSource.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(request)){
                for (int i = 0; i < values.size(); i++) {
                    if (classes.get(i) == String.class){
                        preparedStatement.setString(i + 1, prepareString.apply(values.get(i)));
                    }else if (classes.get(i) == Integer.class){
                        preparedStatement.setInt(i + 1, prepareInteger.apply(values.get(i)));
                    }

                }
                preparedStatement.executeUpdate();
            }
        }
    }
}
