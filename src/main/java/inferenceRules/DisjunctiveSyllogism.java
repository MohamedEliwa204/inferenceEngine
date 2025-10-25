package inferenceRules;

import Interface.InferenceRuleInterface;
import classes.Expression;

public class DisjunctiveSyllogism implements InferenceRuleInterface {


    @Override
    public boolean matches(Expression exp1, Expression exp2) {
        Expression conj = null, negated = null;
        if (exp1.isDisjunction()) {
            conj = exp1;
        } else if (exp2.isDisjunction()) {
            conj = exp2;
        }
        if (exp1.isLiteral() && exp1.isFirstNegated()) {
            negated = exp1;
        } else if (exp2.isLiteral() && exp2.isFirstNegated()) {
            negated = exp2;
        }
        if (conj == null || negated == null) {
            return false;
        }

        return Expression.isComplement(conj.first, negated.first) || Expression.isComplement(conj.second, negated.first);
    }

    @Override
    public Expression apply(Expression exp1, Expression exp2) {
        if (matches(exp1, exp2)) {
            if (exp1.isLiteral() && Expression.isComplement(exp1.first, exp2.first)) {
                return new Expression(exp2.second);
            } else if (exp1.isLiteral() && Expression.isComplement(exp1.first, exp2.second)) {
                return new Expression(exp2.first);
            } else if (exp2.isLiteral() && Expression.isComplement(exp2.first, exp1.first)) {
                return new Expression(exp1.second);
            } else if (exp2.isLiteral() && Expression.isComplement(exp2.first, exp1.second)) {
                return new Expression(exp1.first);
            }
        }
        return null;
    }
}
