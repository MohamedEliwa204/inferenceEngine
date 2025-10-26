package inferenceRules;

import Interface.InferenceRuleInterface;
import classes.Expression;

public class ModusPonens implements InferenceRuleInterface {

    public boolean matches(Expression exp1, Expression exp2) {
        Expression implication, literal;

        if (exp1.operator.equals(">") && exp2.isLiteral()) {
            implication = exp1;
            literal = exp2;
        } else if (exp2.operator.equals(">") && exp1.isLiteral()) {
            implication = exp2;
            literal = exp1;
        } else return false;

        if (implication.first.equals(literal.first)) return true;

        return false;
    }

    public Expression apply(Expression exp1, Expression exp2) {
        if (exp1.isImplication()) return new Expression(exp1.second);
        if (exp2.isImplication()) return new Expression(exp2.second);
        return null;
    }

}
