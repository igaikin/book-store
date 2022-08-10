package com.company.bookseller.dao.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import lombok.extern.log4j.Log4j2;
import org.postgresql.ds.PGSimpleDataSource;

@Log4j2
public class PostgresDataSourceFactory {
    public static PGSimpleDataSource createPostgresDataSource() {
        PGSimpleDataSource dataSource = null;
        Properties properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("properties\\database.properties");
            properties.load(inputStream);
            dataSource = new PGSimpleDataSource();
            dataSource.setURL(properties.getProperty("db.url"));
            dataSource.setUser(properties.getProperty("db.user"));
            dataSource.setPassword(properties.getProperty("db.pass"));
        } catch (IOException e) {
            log.error(e);
        }
        return dataSource;
    }
}
