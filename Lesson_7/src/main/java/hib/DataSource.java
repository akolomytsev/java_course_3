package hib;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {

    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource ds;
    static {
        config.setJdbcUrl("jdbc:sqlite:Lesson_7/dogs.db");
        ds = new HikariDataSource(config);
    }

    DataSource(){

    }

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
