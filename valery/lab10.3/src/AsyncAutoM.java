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
            System.out.println("Возможные сигналы для состояния A: \n A -> B: 1|000 \n A -> C: 0|11");
            System.out.print("Введите сигнал: ");
            String signal = in.next();
            if(Objects.equals(signal, "1|000")) {
                doMark("B");
                return;
            }
            if(Objects.equals(signal, "0|11")) {
                doMark("C");
                return;
            }
        }
        if(getState() == 1) {
            System.out.println("Возможные сигналы для состояния B: \n B -> B: 0|11 \n B -> C: 1|3");
            System.out.print("Введите сигнал: ");
            String signal = in.next();
            if(Objects.equals(signal, "0|11")) {
                doMark("B");
                return;
            }
            if(Objects.equals(signal, "1|3")) {
                doMark("C");
                return;
            }
        }
        if(getState() == 2) {
            System.out.println("Возможные сигналы для состояния C: \n C -> B: 0|3 \n C -> A: 1|101");
            System.out.print("Введите сигнал: ");
            String signal = in.next();
            if(Objects.equals(signal, "0|3")) {
                doMark("B");
                return;
            }
            if(Objects.equals(signal, "1|101")) {
                doMark("A");
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
