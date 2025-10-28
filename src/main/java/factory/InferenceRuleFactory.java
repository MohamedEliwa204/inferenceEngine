package factory;

import Interface.InferenceEngineInterface;
import Interface.InferenceRuleInterface;
import classes.Expression;
import classes.Result;
import inferenceRules.*;

import java.util.ArrayList;
import java.util.List;


public class InferenceRuleFactory {


    DisjunctiveSyllogism disjunctiveSyllogism = new DisjunctiveSyllogism();
    HypotheticalSyllogism hypotheticalSyllogism = new HypotheticalSyllogism();
    ModusPonens modusPonens = new ModusPonens();
    ModusTollens modusTollens = new ModusTollens();
    Resolution resolution = new Resolution();
    RuleManage ruleManage = new RuleManage();

    public InferenceRuleFactory() {
        ruleManage.addRule(disjunctiveSyllogism);
        ruleManage.addRule(hypotheticalSyllogism);
        ruleManage.addRule(modusPonens);
        ruleManage.addRule(modusTollens);
        ruleManage.addRule(resolution);
    }

    public Result solve(Expression exp1, Expression exp2) {
        Expression exp = ruleManage.applyRules();
        ruleManage.addExpression(exp1);
        ruleManage.addExpression(exp2);

        return new Result(ruleManage.getR(), exp);
    }


}

