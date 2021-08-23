package edu.eci.cvds.patterns.shapes;

public interface Shape {
    public int getNumberOfEdges();
    default static Shape figura(){
        return null;
    };
}
