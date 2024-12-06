package ss4_class_object.bai_3;

public class Fan {
    int slow = 1;
    int normal = 2;
    int fast = 3;

    private int speed = slow;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public Fan() {
    }

    public int getSlow() {
        return slow;
    }

    public int getNormal() {
        return normal;
    }

    public int getFast() {
        return fast;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return this.on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (this.isOn()) {
            return "Fan is on, " + "speed: " + this.getSpeed() + ", radius: " + this.getRadius() + ", color: " + this.getColor();
        } else {
            return "Fan is off, " + "radius: " + this.getRadius() + ", color: " + this.getColor();
        }
    }
}
