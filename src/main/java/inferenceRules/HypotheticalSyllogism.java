package inferenceRules;

import Interface.InferenceRuleInterface;
import classes.Expression;

public class HypotheticalSyllogism implements InferenceRuleInterface {
    public boolean matches(Expression exp1, Expression exp2) {

        if (exp1.isImplication() && exp2.isImplication()) {
            return exp1.second.equals(exp2.first) || exp2.second.equals(exp1.first);
        }

        return false;
    }

    public Expression apply(Expression exp1, Expression exp2) {
        String first, second;

        if(exp1.second.equals(exp2.first)) {
            first = exp1.first;
            second = exp2.second;
            return new Expression(first, ">", second);
        }
        else if(exp2.second.equals(exp1.first)) {
            first = exp2.first;
            second = exp1.second;
            return new Expression(first, ">", second);
        }
        return null;
    }
}
