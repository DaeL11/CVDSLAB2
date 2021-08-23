package edu.eci.cvds.patterns.shapes;
import edu.eci.cvds.patterns.shapes.concrete.*;

public class ShapeFactory {   
    public static Shape create(RegularShapeType type){
        Shape shape = null;
        switch(type){
            case Triangle:
                shape = Triangle.figura();
                break;
            case Quadrilateral:
                shape = Quadrilateral.figura();
                break;
            case Pentagon:
                shape = Pentagon.figura();
                break;
            case Hexagon:
                shape = Hexagon.figura();
                break;
        }
        return shape;
    }
}

