package club.piclight.hw.HuffmanCore.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DBConnector {
    private static DBConnector dbConnector;
    private static final String url = "jdbc:sqlite:huffman-message.db";
    private Connection connection;
    private static Logger logger = Logger.getLogger(DBConnector.class.getName());

    private DBConnector() {
        try {
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            logger.info("club.piclight.hw.DB init success, get connection success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (dbConnector == null)
            dbConnector = new DBConnector();
        return dbConnector.connection;
    }
}
