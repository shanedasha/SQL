package Data;

import lombok.*;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login = "SELECT login FROM users;";
        private String password = "SELECT password FROM users;";
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo();
    }

    @Value
    public static class VerificationCode {
        private String codeSQL = "SELECT code FROM auth_codes;";
        private QueryRunner runner = new QueryRunner();

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
        {
            var code = runner.query(conn, codeSQL, new ;
        }
    }

    public static VerificationCode getVerificationCode() {
        return new VerificationCode();
    }
    @Value
    public static class CleanBD {
        private String delete = "DROP TABLE IF EXISTS cards,auth_codes,users,card_transaction";
    }
    public static CleanBD getCleanBD() {
        return new CleanBD();
    }
}


