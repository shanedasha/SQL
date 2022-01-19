package data;

import lombok.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataHelper {
    @Data
    @AllArgsConstructor
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }


    @Data
    @NoArgsConstructor
    public static class VerificationCode {
        private String code;
    }

    @SneakyThrows
    private static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SneakyThrows
    public static VerificationCode getVerificationCode() {
        var runner = new QueryRunner();
        var getCodeSQL = "SELECT code FROM auth_codes ORDER BY created DESC LIMIT 1;";
        try (var conn = getConnection()) {
            return runner.query(conn, getCodeSQL, new BeanHandler<>(VerificationCode.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Data
    @NoArgsConstructor
    public static class DeleteDataBase {
        private String database;
    }

    @SneakyThrows
    public static void deleteDataBase() {
        var runner = new QueryRunner();
        var deleteSQL = "DELETE FROM users,auth_codes,cards,card_transactions";
        try (var conn = getConnection()) {
            runner.update(conn,deleteSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




