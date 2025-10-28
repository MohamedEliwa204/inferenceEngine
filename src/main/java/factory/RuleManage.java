package factory;

import Interface.InferenceEngineInterface;
import Interface.InferenceRuleInterface;
import classes.Expression;

import java.util.ArrayList;
import java.util.List;

public class RuleManage implements InferenceEngineInterface {

    private final List<InferenceRuleInterface> rules = new ArrayList<>();
    private final List<Expression> expressions = new ArrayList<>();
    String r;

    public RuleManage() {

    }

    @Override
    public void addRule(InferenceRuleInterface rule) {
        rules.add(rule);
    }

    @Override
    public void addExpression(Expression exp) {
        if (expressions.size() == 2) {
            expressions.clear();
        }
        expressions.add(exp);

    }

    @Override
    public Expression applyRules() {
        for (InferenceRuleInterface rule : rules) {
            if (rule.matches(expressions.get(0), expressions.get(1))) {
                r = rule.getClass().getSimpleName();
                return rule.apply(expressions.get(0), expressions.get(1));
            }

        }
        r = "no inference rule match this exppressions!";
        return new Expression("no solution!");
    }

    public String getR() {
        return r;
    }
}
