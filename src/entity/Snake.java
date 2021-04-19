package entity;

public class Snake extends Role{
    private int length;
    
    public Snake(){
    
    }

    public Snake(Coordinate[] coordinates) {
        super(coordinates);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
}
