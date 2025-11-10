public class FactoryPointMain {
    public static void main(String[] args) {
        PointFactory pF=new PointFactory();
        Point p2D=pF.getPoint("2D");
        Point p3D=pF.getPoint("3D");
        p2D.setCoor(2,3);
        p3D.setCoor(2,3,4);
        p2D.draw();
        p3D.draw();
        System.out.println("Length of 2D from 3D = "+p2D.length(p3D));
        System.out.println("Length of 2D from 3D = "+p3D.length(p2D));
    }
}
