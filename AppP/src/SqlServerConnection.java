import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlServerConnection {
    private String hostName;
    private String userName;
    private String password;
    private String databaseName;
    private String tableName;
    private List<Column> inputs;

    public SqlServerConnection(String hostName, String userName, String password) {
        this.hostName = hostName;
        this.userName = userName;
        this.password = password;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Column> getInputs() {
        return inputs;
    }

    public void setInputs(List<Column> inputs) {
        this.inputs = inputs;
    }

    public List<String> getListDatabase() throws SQLException {
        List<String> listDatabase = new ArrayList<>();
        Connection conn = null;

        String dbURL = "jdbc:sqlserver://" + this.hostName + "; integratedSecurity=true";
        System.out.println(dbURL);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, this.userName, this.password);
            System.out.println("connect successfully!");

            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT name FROM master.dbo.sysdatabases");
            while (rs.next()) {
                listDatabase.add(rs.getString(0));
            }

            conn.close();
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return listDatabase;
    }
}
