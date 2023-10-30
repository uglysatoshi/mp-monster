import java.util.Objects;
import java.util.Scanner;

public class AsyncAutoM {
    private final Statement A; // состояние А
    private final Statement B; // состояние B
    private final Statement C; // состояние С
    private final boolean[] point; // помечает в каком состоянии находится автомат
    AsyncAutoM() {
        // даем состояниям имена
        this.A = new Statement("A");
        this.B = new Statement("B");
        this.C = new Statement("C");
        // определяем состояние A как активное
        this.point = new boolean[]{true, false, false};
    }
    // функция нахождения индекса активного состояния
    private int getState() {
        int state = 0;
        for(int i = 0; i < 3; i++) {
            if(point[i]) state = i;
        }
        return state;
    }
    // функция, помечающая активное состояние
    private void doMark(String state) {
        if(Objects.equals(state, "A")) forMark(0);
        if(Objects.equals(state, "B")) forMark(1);
        if(Objects.equals(state, "C")) forMark(2);
    }
    // подфункция помечающая активное состояние
    private void forMark(int index) {
        for(int i = 0; i < 3; i++) point[i] = index == i;
    }
    // функция смены состояния
    void changeStatement() {
        Scanner in = new Scanner(System.in);
        if(getState() == 0) {
            System.out.println("Возможные сигналы для состояния A: \n A -> A: 1|10\n A -> C: 0|01\n");
            System.out.print("Введите сигнал: ");
            String signal = in.next();
            if(Objects.equals(signal, "1|10")) {
                doMark("A");
                return;
            }
            if(Objects.equals(signal, "0|01")) {
                doMark("C");
                return;
            }
        }
        if(getState() == 1) {
            System.out.println("Возможные сигналы для состояния B: \n B -> A: 1|2\n B -> B: 0|2");
            System.out.print("Введите сигнал: ");
            String signal = in.next();
            if(Objects.equals(signal, "1|2")) {
                doMark("A");
                return;
            }
            if(Objects.equals(signal, "0|2")) {
                doMark("B");
                return;
            }
        }
        if(getState() == 2) {
            System.out.println("Возможные сигналы для состояния C: \n C -> C: 0|10 \n C -> B: 1|01");
            System.out.print("Введите сигнал: ");
            String signal = in.next();
            if(Objects.equals(signal, "0|10")) {
                doMark("C");
                return;
            }
            if(Objects.equals(signal, "1|01")) {
                doMark("B");
            }
        }
    }
    // функция вывода активного состояния
    void showStatement() {
        if(getState() == 0) A.show();
        if(getState() == 1) B.show();
        if(getState() == 2) C.show();
    }
}