package com.example.wsbenchmark.Switch;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
@RequestMapping("SwitchStatement")
public class SwitchStatement {
    public static Connection dbConnection = null;
    private final Type typeBad = Type.typeC;
    private final Type typeSafe = Type.typeB;

    @GetMapping("bad")
    void bad(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery = null;

        switch (typeBad) {
            case typeA: {
                accountBalanceQuery = "safe";
                break;
            }
            case typeB: {
                accountBalanceQuery = "safe";
                break;
            }
            case typeC: {
                accountBalanceQuery = "safe" + req.getParameter("user_id");
                break;
            }
            case typeD: {
                accountBalanceQuery = "safe";
                break;
            }
            default : {
                break;
            }
        }

        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }

    @GetMapping("safe")
    void safe(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery = null;

        switch (typeSafe) {
            case typeA: {
                accountBalanceQuery = "safe";
                break;
            }
            case typeB: {
                accountBalanceQuery = "safe";
                break;
            }
            case typeC: {
                accountBalanceQuery = "safe" + req.getParameter("user_id");
                break;
            }
            case typeD: {
                accountBalanceQuery = "safe";
                break;
            }
            default : {
                break;
            }
        }

        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }
}

enum Type  {
    typeA,
    typeB,
    typeC,
    typeD
}
