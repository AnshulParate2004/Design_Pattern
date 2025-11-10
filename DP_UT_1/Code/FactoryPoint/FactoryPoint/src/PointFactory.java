public class PointFactory {
    public Point getPoint(String pointType){
    if(pointType == null){
        return null;
    }
    if(pointType.equalsIgnoreCase("2D")){ 
	return new Point2D();
    }
    if(pointType.equalsIgnoreCase("3D")){ 
	return new Point3D();
    } 
    return null;
    }
}
