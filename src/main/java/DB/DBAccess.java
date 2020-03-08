package DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class DBAccess {
    private String QUERY_IF_TABLE_EXISTS = "SELECT name FROM sqlite_master WHERE type='table'";

    private String CREATE_DICT_TABLE_SQL =
            "CREATE TABLE Dict(msg_hash TEXT PRIMARY KEY," +
                    "dict TEXT);";

    private String CRATE_HFM_TABLE_SQL =
            "CREATE TABLE Huffman(msg_hash TEXT PRIMARY KEY," +
                    "huffman_msg TEXT);";

    private static DBAccess dbAccess;
    private static Connection connection;
    private static Logger logger = Logger.getLogger(DBAccess.class.getName());

    private DBAccess() {
        connection = DBConnector.getConnection();

        /* Check and create tables */
        try {
            /* Check table if exists */
            Statement sm = connection.createStatement();
            ResultSet rs = sm.executeQuery(QUERY_IF_TABLE_EXISTS);

            Set<String> tableSet = new HashSet<>();
            while (rs.next()) {
                tableSet.add(rs.getString("name"));
            }
            sm.close();

            Set<String> checkSet = new HashSet<>();
            checkSet.add("Dict");
            checkSet.add("Huffman");
            checkSet.retainAll(tableSet);

            if (checkSet.size() != 2) {
                logger.warning("Table does not found, create table");
                /* Create table */
                sm = connection.createStatement();
                sm.execute(CREATE_DICT_TABLE_SQL);
                sm.execute(CRATE_HFM_TABLE_SQL);
                connection.commit();
                sm.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("Database check finished");
    }

    public static DBAccess getInstance() {
        if (dbAccess == null) {
            dbAccess = new DBAccess();
        }
        return dbAccess;
    }
}
