package factory;

import classes.Expression;
import classes.Result;
import inferenceRules.*;



public class InferenceRuleFactory {

    DisjunctiveSyllogism disjunctiveSyllogism = new DisjunctiveSyllogism();
    HypotheticalSyllogism hypotheticalSyllogism = new HypotheticalSyllogism();
    ModusPonens modusPonens = new ModusPonens();
    ModusTollens modusTollens = new ModusTollens();
    Resolution resolution = new Resolution();

    public Result solve(Expression exp1, Expression exp2) {
        if (disjunctiveSyllogism.matches(exp1, exp2)) {
            return new Result("DisjunctiveSyllogism", disjunctiveSyllogism.apply(exp1, exp2));
        } else if (hypotheticalSyllogism.matches(exp1, exp2)) {
            return new Result("HypotheticalSyllogism", hypotheticalSyllogism.apply(exp1, exp2));
        } else if (modusPonens.matches(exp1, exp2)) {
            return new Result("ModusPonens", modusPonens.apply(exp1, exp1));
        } else if (modusTollens.matches(exp1, exp2)) {
            return new Result("ModusTollens", modusTollens.apply(exp1, exp2));
        } else if (resolution.matches(exp1, exp2)) {
            return new Result("Resolution", resolution.apply(exp1, exp2));
        }
        return new Result("Don't match any of our inferennce rules!", new Expression("no solution!"));
    }


}
