package data.algorithms.sort;

import data.algorithms.Algorithm;
import data.algorithms.Complexity;


public abstract class SortingAlgorithm
        extends Algorithm
{
    //# Constructor
    public SortingAlgorithm(String name, Complexity.Type time, Complexity.Type spaceAuxiliary) {
        super(name, time, time, time, spaceAuxiliary);
    }

    public SortingAlgorithm(String name, Complexity.Type timeBest, Complexity.Type timeAverage, Complexity.Type timeWorst, Complexity.Type spaceAuxiliary) {
        super(name, timeBest, timeAverage, timeWorst, spaceAuxiliary);
    }


    //# Algorithm::Overrides
    @Override
    public Type getTimeComplexity() {
        return this.complexity.get("time").get("big-o");
    }

    @Override
    public Type getSpaceAuxiliary() {
        return this.complexity.get("space").get("auxiliary");
    }
}
