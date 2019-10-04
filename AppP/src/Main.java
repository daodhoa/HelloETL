import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\User\\Desktop\\Book1.xlsx";
        ExcelUltils excelUltils = new ExcelUltils();
        try {
            ArrayList<String> columnNames = excelUltils.getColumnName(1, filePath);

            ExcelConnection excelConnection = new ExcelConnection(filePath);
            ArrayList<Column> outputs = (ArrayList<Column>) excelConnection.getOutputs();
            for (int i = 0; i < columnNames.size(); i++) {
                String columnName = columnNames.get(i);
                Column column = new Column(columnName, "DT_STR", "100", "NO");
                outputs.add(column);
            }
            excelConnection.setOutputs(outputs);

            String createTable = "create table table_name ( ";
            for (int i = 0; i < outputs.size(); i++) {
                Column col = outputs.get(i);
                createTable += col.getName() + " varchar("+ col.getLength() +"), ";
            }
            createTable += ")";
            System.out.println(createTable);

            SqlServerConnection sqlServerConnection = new SqlServerConnection("DESKTOP-BP3T59L", "sa", "123456");
            ArrayList<String> listDatabase = (ArrayList<String>) sqlServerConnection.getListDatabase();
            listDatabase.forEach(x -> System.out.println(x));

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
