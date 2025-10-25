package inferenceRules;

import Interface.InferenceRuleInterface;
import classes.Expression;

public class Resolution implements InferenceRuleInterface {
    @Override
    public boolean matches(Expression exp1, Expression exp2) {
        Expression conj1 = null, conj2 = null;
        if (exp1.isDisjunction() && exp2.isDisjunction()) {
            conj1 = exp1;
            conj2 = exp2;
        }
        if (conj1 == null || conj2 == null) return false;
        return Expression.isComplement(conj1.first, conj2.first) || Expression.isComplement(conj1.first, conj2.second) ||
                Expression.isComplement(conj1.second, conj2.first) || Expression.isComplement(conj1.second, conj2.second);
    }

    @Override
    public Expression apply(Expression exp1, Expression exp2) {
        if (matches(exp1, exp2)) {
            if (Expression.isComplement(exp1.first, exp2.first)) {
                return new Expression(exp1.second, "v", exp2.second);
            } else if (Expression.isComplement(exp1.first, exp2.second)) {
                return new Expression(exp1.second, "v", exp2.first);
            } else if (Expression.isComplement(exp1.second, exp2.first)) {
                return new Expression(exp1.first, "v", exp2.second);
            } else if (Expression.isComplement(exp1.second, exp2.second)) {
                return new Expression(exp1.first, "v", exp2.first);
            }
        }
        return null;
    }
}
