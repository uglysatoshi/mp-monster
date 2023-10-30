package Base;

import java.util.Scanner;
// класс наследник для просчета скорости
public class Speed extends Time {
    double speed;
    public Speed() {
        Scanner in = new Scanner(System.in);
        while(true)
        {
            System.out.print("Введите скорость в м/с: ");
            this.speed = in.nextDouble();
            if(this.speed  >= 0) {
                break;
            }
        }

    }
    public double getDistanceKM() {
        return (hours * 360 * speed + minutes * 60 * speed + seconds * speed) / 1000;
    }
}
