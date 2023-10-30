import Base.Speed;
import Medium.Picture;

public class Main {
    public static void Base() {
        Speed speed = new Speed();
        System.out.println("Дистанция: " + speed.getDistanceKM() + " км");
    }
    public static void Medium() {
        Picture pic = new Picture();
        pic.write();
        pic.areaOfTriangle();
    }
    public static void main(String[] args) {
        Base();
        Medium();
    }
}