import java.lang.Math;
public class Point2D implements Point{
    int x,y;
    public void draw(){
    System.out.println("2D Point DRAWN"+x +y );
    }
    public double length(Point p){
        return Math.sqrt(x * p.getx() + y * p.gety());
    }
    public double getx(){
        return x;
    }
    public double gety(){
        return y;
    }
    public double getz(){
        return 0;
    }
    public void setCoor(int x1, int y1, int z){
        
    }
    public void setCoor(int x1, int y1){
        x=x1;
        y=y1;
    }
}