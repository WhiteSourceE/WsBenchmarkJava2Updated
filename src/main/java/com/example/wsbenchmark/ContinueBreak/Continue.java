package com.example.wsbenchmark.ContinueBreak;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
@RequestMapping("Continue")
public class Continue {
    public static Connection dbConnection = null;

    @GetMapping("bad")
    void bad(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery = "safe";

        for (int i = 1; i <= 5; i++) {
            accountBalanceQuery = "safe" + req.getParameter("user_id");
            continue;
        }
        System.out.println("--" + accountBalanceQuery);
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }

    @GetMapping("safe")
    void safe(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery = "safe";

        for (int i = 1; i <= 5; i++) {
            if(true) continue;
            accountBalanceQuery = "safe" + req.getParameter("user_id");
        }
        System.out.println("--" + accountBalanceQuery);
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }
}
