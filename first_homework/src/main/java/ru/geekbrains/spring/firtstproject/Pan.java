package ru.geekbrains.spring.firtstproject;

import java.awt.*;

public class Pan {
    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Pan(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("Color of pan is RGB(%d, %d, %d)",
                color.getRed(), color.getGreen(), color.getBlue());
    }
}
