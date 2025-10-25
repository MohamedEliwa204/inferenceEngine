package Interface;

import classes.Expression;

public interface InferenceEngineInterface {
    void addRule(InferenceRuleInterface rule);
    void addExpression(Expression exp);
    Expression applyRules();
}
