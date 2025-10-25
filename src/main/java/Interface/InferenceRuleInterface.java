package Interface;

import classes.Expression;

public interface InferenceRuleInterface {
    boolean matches(Expression exp1, Expression exp2);
    Expression apply(Expression exp1, Expression exp2);
}