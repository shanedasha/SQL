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


    private static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


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

    public static void deleteDataBase() {
        var runner = new QueryRunner();
        var deleteSQL1 = "DELETE FROM users";
        var deleteSQL2 = "DELETE FROM auth_codes";
        var deleteSQL3 = "DELETE FROM cards";
        var deleteSQL4 = "DELETE FROM card_transactions";
        try (var conn = getConnection()) {
            runner.update(conn, deleteSQL1);
            runner.update(conn, deleteSQL2);
            runner.update(conn, deleteSQL3);
            runner.update(conn, deleteSQL4);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




