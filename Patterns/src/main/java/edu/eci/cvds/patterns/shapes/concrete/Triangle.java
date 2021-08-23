package edu.eci.cvds.patterns.shapes.concrete;

import edu.eci.cvds.patterns.shapes.Shape;


public class Triangle  implements Shape{
    public int getNumberOfEdges(){
        return 3;
    }
    public static Shape figura(){
        return new Triangle();
    }
}
