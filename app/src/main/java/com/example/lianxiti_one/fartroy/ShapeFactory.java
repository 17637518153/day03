package com.example.lianxiti_one.fartroy;

public class ShapeFactory {

    public Shape getShspe(String type){
        if (type == null) {
            return null;
        }

        if (type.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        }
        if (type.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        if (type.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}
