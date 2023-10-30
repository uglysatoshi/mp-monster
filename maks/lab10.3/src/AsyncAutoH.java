import java.util.Objects;
import java.util.Scanner;

public class AsyncAutoH {
    private final Statement A; // состояние А
    private final Statement B; // состояние B
    private final boolean[] point; // помечает в каком состоянии находится автомат
    AsyncAutoH() {
        // даем состояниям имена
        this.A = new Statement("A");
        this.B = new Statement("B");
        // определяем состояние A как активное
        this.point = new boolean[]{true, false};
    }
    // функция нахождения индекса активного состояния
    private int getState() {
        int state = 0;
        for(int i = 0; i < 2; i++) {
            if(point[i]) state = i;
        }
        return state;
    }
    // функция, помечающая активное состояние
    private void doMark(String state) {
        if(Objects.equals(state, "A")) forMark(0);
        if(Objects.equals(state, "B")) forMark(1);
    }
    // подфункция помечающая активное состояние
    private void forMark(int index) {
        for(int i = 0; i < 2; i++) point[i] = index == i;
    }
    // функция смены состояния
    void changeStatement() {
        Scanner in = new Scanner(System.in);
        if(getState() == 0) {
            System.out.println("Возможные сигналы для состояния A: \n A -> A: 00|101 \n A -> B: 01|2");
            System.out.print("Введите сигнал: ");
            String signal = in.next();
            if(Objects.equals(signal, "00|101")) {
                doMark("A");
                return;
            }
            if(Objects.equals(signal, "01|2")) {
                doMark("B");
                return;
            }
        }
        if(getState() == 1) {
            System.out.println("Возможные сигналы для состояния B: \n B -> B: 01|2 \n B -> A: 00|11");
            System.out.print("Введите сигнал: ");
            String signal = in.next();
            if(Objects.equals(signal, "01|2")) {
                doMark("B");
                return;
            }
            if(Objects.equals(signal, "00|11")) {
                doMark("A");
            }
        }
    }
    // функция вывода активного состояния
    void showStatement() {
        if(getState() == 0) A.show();
        if(getState() == 1) B.show();
    }
}