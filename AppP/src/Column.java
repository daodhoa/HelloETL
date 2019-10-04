public class Column {
    private String name;
    private String dataType;
    private String length;
    private String expression;

    public Column(String name, String dataType, String length, String expression) {
        this.name = name;
        this.dataType = dataType;
        this.length = length;
        this.expression = expression;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
