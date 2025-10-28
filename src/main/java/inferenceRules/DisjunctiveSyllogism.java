package inferenceRules;

import Interface.InferenceRuleInterface;
import classes.Expression;

public class DisjunctiveSyllogism implements InferenceRuleInterface {


    @Override
    public boolean matches(Expression exp1, Expression exp2) {
        Expression disg = null, negated = null;
        if (exp1.isDisjunction()) {
            disg = exp1;
        } else if (exp2.isDisjunction()) {
            disg = exp2;
        }
        if (exp1.isLiteral() && exp1.isFirstNegated()) {
            negated = exp1;
        } else if (exp2.isLiteral() && exp2.isFirstNegated()) {
            negated = exp2;
        }
        if (disg == null || negated == null) {
            return false;
        }

        return Expression.isComplement(disg.first, negated.first) || Expression.isComplement(disg.second, negated.first);
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

    public String getName() {
        return "DisjunctiveSyllogism";
    }
}
