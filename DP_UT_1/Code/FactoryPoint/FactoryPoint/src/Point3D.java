import java.lang.Math;
public class Point3D implements Point{
    int x,y,z;
    public void draw(){
    System.out.println("3D Point DRAWN"+x +y +z);
    }
    public double length(Point p){
        return Math.sqrt(x*p.getx()+y*p.gety());
    }
    public void setCoor(int x1,int y1, int z1){
        x=x1;
        y=y1;
        z=z1;
    } 
    public void setCoor(int x1, int y1){
        
    }
    public double getx(){
        return x;
    }
    public double gety(){
        return y;
    }
    public double getz(){
        return z;
    }
}