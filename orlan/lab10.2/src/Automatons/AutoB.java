package Automatons;
import Automatons.Statement.*;

import java.util.Objects;

public class AutoB extends Auto{
    private final Statement A;
    private final Statement B;
    private final Statement C;
    public boolean[] mark = new boolean[3];
    public AutoB() {
        this.A = new Statement("A");
        this.B = new Statement("B");
        this.C = new Statement("C");
        mark = new boolean[]{true, false, false};
    }
    public void nextState(String str) {
        int statePlace = findState();
        if(statePlace == 0) {
            if(Objects.equals(str, "00")) markState("B");
        }
        if(statePlace == 1) {
            if(Objects.equals(str, "01")) markState("C");
        }
        if(statePlace == 2) {
            if(Objects.equals(str, "11")) markState("A");
        }
    }
    public void showCurrentState() {
        int statePlace = findState();
        if(statePlace == 0) A.show();
        if(statePlace == 1) B.show();
        if(statePlace == 2) C.show();
    }
}
