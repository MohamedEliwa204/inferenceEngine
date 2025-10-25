package inferenceRules;

import Interface.InferenceRuleInterface;
import classes.Expression;

public class ModusTollens implements InferenceRuleInterface {

    public boolean matches(Expression exp1, Expression exp2) {
        Expression implication, literal;

        if(exp1.isImplication() && exp2.isLiteral()) {
            implication = exp1;
            literal = exp2;
        }
        else if (exp2.isImplication() && exp1.isLiteral()) {
            implication = exp2;
            literal = exp1;
        }
        else return false;

        return Expression.isComplement(implication.second, literal.first);
    }
    public Expression apply(Expression exp1, Expression exp2) {
        if (exp1.isImplication()) return new Expression(Expression.negate(exp1.first));
        if (exp2.isImplication()) return new Expression(Expression.negate(exp2.first));
        return null;
    }

}
