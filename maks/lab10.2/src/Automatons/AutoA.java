package Automatons;
import Automatons.Statement.*;

import java.util.Objects;

public class AutoA extends Auto {
    private final Statement A;
    private final Statement B;
    private final Statement C;
    public boolean[] mark = new boolean[3];
    public AutoA() {
        // обозначение имен состояний
        this.A = new Statement("A");
        this.B = new Statement("B");
        this.C = new Statement("C");
        // выделяем состояние A как активное
        mark = new boolean[]{true, false, false};
    }
    public void nextState(String str) {
        int statePlace = findState();
        // вариации переходов для всех состояний автомата
        if(statePlace == 0) {
            // переходы в другое состояние по переданному сигналу
            if(Objects.equals(str, "01")) markState("A");
            if(Objects.equals(str, "11")) markState("B");
        }
        if(statePlace == 1) {
            if(Objects.equals(str, "10")) markState("A");
            if(Objects.equals(str, "00")) markState("C");
        }
        if(statePlace == 2) {
            if(Objects.equals(str, "10")) markState("C");
            if(Objects.equals(str, "00")) markState("A");
        }
    }
    public void showCurrentState() {
        // вывод активного состояния
        int statePlace = findState();
        if(statePlace == 0) A.show();
        if(statePlace == 1) B.show();
        if(statePlace == 2) C.show();
    }
}
