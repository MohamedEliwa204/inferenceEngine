package classes;

public class Result {
    public String text;
    public Expression expression;

    public Result(String text, Expression expression) {
        this.text = text;
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    public String getText() {
        return text;
    }
}
