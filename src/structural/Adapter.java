package structural;

//convert interface of a class into other interface which client wants using adapter without more changes to code
public class Adapter {
    public static void main(String[] args) {
        GeometricShape triangle = new Triangle();
        Shape shape = new GeometricShapeAdapter(triangle);
        Shape rectangle = new Rectangle();
        shape.draw();
        rectangle.draw();
    }
}

class GeometricShapeAdapter implements Shape{
    GeometricShape geometricShape;
    public GeometricShapeAdapter(GeometricShape geometricShape){
        this.geometricShape = geometricShape;
    }

    @Override
    public void draw() {
        geometricShape.drawShape();
    }
}
interface GeometricShape{
    public void drawShape();
}

interface Shape{
    public void draw();

}

class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Drawing rectangle");
    }
}
class Triangle implements GeometricShape{

    @Override
    public void drawShape() {
        System.out.println("Drawing triangle");
    }
}