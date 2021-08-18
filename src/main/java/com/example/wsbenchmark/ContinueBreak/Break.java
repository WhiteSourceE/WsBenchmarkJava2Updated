package com.example.wsbenchmark.ContinueBreak;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
@RequestMapping("Break")
public class Break {
    public static Connection dbConnection = null;

    @GetMapping("bad")
    void bad(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery = "safe";

        for (int i = 1; i <= 5; i++) {
            if(i == 2) break;
            accountBalanceQuery = "safe" + req.getParameter("user_id");
        }

        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }

    @GetMapping("safe")
    void safe(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery = "safe";

        for (int i = 1; i <= 5; i++) {
            if(i == 1) break;
            accountBalanceQuery = "safe" + req.getParameter("user_id");
        }

        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }
}
