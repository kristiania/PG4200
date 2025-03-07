package data.algorithms;

import java.util.HashMap;

public interface Complexity
{
    Type getTimeComplexity();
    Type getSpaceAuxiliary();


    /*
    // TODO
    default Type getSpaceComplexity(String type) {
        return switch (this.getSpaceAuxiliarySpace(type)) {
            case Constant, ONE -> Type.N;
            case Linear, N -> null;
            case Logarithmic -> null;
            case LOGN -> null;
            case NLOGN -> null;
            case Quadratic -> null;
            case NSQUARED -> null;
            case Exponential -> null;
            case TWOPOWERN -> null;
        }
    }
    */


    enum Type {
        Constant,
        Linear,
        Logarithmic,
        Quadratic,
        Exponential,
    }
}
