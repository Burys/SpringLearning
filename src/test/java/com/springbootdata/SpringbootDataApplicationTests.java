package com.springbootdata;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.security.sasl.SaslServer;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringbootDataApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
        System.out.println(dataSource.getClass());

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            System.out.println("==>"+connection);
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
