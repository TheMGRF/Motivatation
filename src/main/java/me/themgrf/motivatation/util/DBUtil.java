package me.themgrf.motivatation.util;

import xyz.minecrossing.databaseconnector.DatabaseConnector;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {

    public static final String DATABASE_NAME = "motivatation";

    public static Connection getConnection() throws SQLException {
        return DatabaseConnector.getInstance().getConnection(DATABASE_NAME);
    }

}
