package Data;

import com.github.javafaker.Faker;
import lombok.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.BeforeEach;

import java.sql.DriverManager;

public class DataHelper {
    @BeforeEach
    @SneakyThrows
    void SetUp() {
        var faker = new Faker();
        var runner = new QueryRunner();
        var dataSQL = "INSERT INTO users(login,password) VALUES (?,?);";
        var codeSQL = "INSERT INTO auth_codes(user_id, code) VALUES (?,?);";

        try (
                var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
        ) {
            runner.update(conn, dataSQL, faker.name().username(), "pass");
            runner.update(conn, codeSQL, dataSQL, "12345");
        }
    }

    @BeforeEach
    @SneakyThrows
    void GetInfo() {
        var codeSQL = "SELECT * FROM  auth_codes;";
        var runner = new QueryRunner();
        try (
                var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
        ) {
            var User = runner.query(conn, codeSQL, new ScalarHandler<>(User.class));
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class User {
        private int id;
        private String login;
        private String password;
        private String code;
    }
}

