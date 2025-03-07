package data.algorithms;

import java.util.HashMap;


public abstract class Algorithm
        implements Complexity
{
    //# Fields
    protected final String name;
    protected final HashMap<String, HashMap<String, Complexity.Type>> complexity = new HashMap<>();

    {
        this.complexity.put("time", new HashMap<>());
        this.complexity.put("space", new HashMap<>());
    }


    //# Constructor
    public Algorithm(String name, Complexity.Type time, Complexity.Type spaceAuxiliary) {
        this(name, time, time, time, spaceAuxiliary);
    }

    public Algorithm(String name, Complexity.Type timeBest, Complexity.Type timeAverage, Complexity.Type timeWorst, Complexity.Type spaceAuxiliary) {
        this.name = name;

        this.complexity.get("time").put("omega", timeBest);
        this.complexity.get("time").put("theta", timeAverage);
        this.complexity.get("time").put("big-o", timeWorst);

        this.complexity.get("space").put("auxiliary", spaceAuxiliary);
    }


    //# Getter-methods
    public Complexity.Type getTimeBestComplexity() {
        return this.complexity.get("time").get("omega");
    }

    public Complexity.Type getTimeAverageComplexity() {
        return this.complexity.get("time").get("theta");
    }

    public Complexity.Type getTimeWorstComplexity() {
        return this.complexity.get("time").get("big-o");
    }


    //# Setter-methods
    protected void setTimeBestComplexity(Complexity.Type complexity) {
        this.complexity.get("time").put("omega", complexity);
    }

    protected void setTimeAverageComplexity(Complexity.Type complexity) {
        this.complexity.get("time").put("theta", complexity);
    }

    protected void setTimeWorstComplexity(Complexity.Type complexity) {
        this.complexity.get("time").put("big-o", complexity);
    }
}
