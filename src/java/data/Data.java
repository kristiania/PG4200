package data;


public abstract class Data
{
    //# Fields
    private int bytes;


    //# Constructors
    public Data(int n) {
        this.bytes = n;
    }


    //# Getter-methods
    public int getBytes() {
        return this.bytes;
    }


    //# Setter-methods
    protected void setByteCount(int n) {
        this.bytes = n;
    }
}
