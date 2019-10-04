import java.util.ArrayList;
import java.util.List;

public class ExcelConnection {
    private String filePath;
    private List<Column> outputs;

    public ExcelConnection(String filePath) {
        this.filePath = filePath;
        this.outputs = new ArrayList<>();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public List<Column> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<Column> outputs) {
        this.outputs = outputs;
    }
}
