package classes;

public class Expression {
    public String first = null;
    public String operator = null;
    public String second = null;

    public Expression(String first, String operator, String second) {
        this.first = first;
        this.operator = operator;
        this.second = second;
    }

    public Expression(String first) {
        this.first = first;
    }

    public boolean isLiteral() {
        return ((first != null) && (operator == null) && (second == null));
    }

    public boolean isFirstNegated() {
        return first.length() == 2;
    }

    public boolean isSecondNegated() {
        return second.length() == 2;
    }

    public static boolean isComplement(String first, String second) {
        String normal, negated;
        if (first.length() == 1 && second.length() == 2) {
            normal = first;
            negated = second;
        } else if (first.length() == 2 && second.length() == 1) {
            normal = second;
            negated = first;
        } else return false;

        return negated.charAt(1) == (char) normal.charAt(0);
    }

    public boolean isImplication() {
        return ">".equals(operator);
    }

    public boolean isConjunction() {
        return "^".equals(operator);
    }

    public boolean isDisjunction() {
        return "v".equals(operator);
    }

    public static String negate(String operand) {
        if (operand.length() == 1) return "~" + operand;
        else if (operand.length() == 2) return operand.charAt(1) + "";
        return null;
    }

    @Override
    public String toString() {
        if (operator == null && second == null) {
            return first; // just a literal, like "~P"
        }
        return first + " " + operator + " " + second;
    }
}