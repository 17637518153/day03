package com.example.lianxiti_one;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lianxiti_one.fartroy.Shape;
import com.example.lianxiti_one.fartroy.ShapeFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShspe("CIRCLE");
        shape1.drow();

        Shape shape2 = shapeFactory.getShspe("RECTANGLE");
        shape2.drow();

        Shape shape3 = shapeFactory.getShspe("SQUARE");
        shape3.drow();
    }
}
