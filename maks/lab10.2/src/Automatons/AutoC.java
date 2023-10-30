package Automatons;
import Automatons.Statement.*;

import java.util.Objects;

public class AutoC extends Auto{
    private final Statement A;
    private final Statement B;
    public boolean[] mark = new boolean[2];
    public AutoC() {
        this.A = new Statement("A");
        this.B = new Statement("B");
        mark = new boolean[]{true, false};
    }
    public void nextState(String str) {
        int statePlace = findState();
        if(statePlace == 0) {
            if(Objects.equals(str, "01")) markState("A");
            if(Objects.equals(str, "10")) markState("B");
        }
        if(statePlace == 1) {
            if(Objects.equals(str, "00")) markState("B");
            if(Objects.equals(str, "11")) markState("A");
        }
    }
    public void markState(String str) {
        if(str.equals("A")) forMark(0);
        if(str.equals("B")) forMark(1);
    }
    public void showCurrentState() {
        int statePlace = findState();
        if(statePlace == 0) A.show();
        if(statePlace == 1) B.show();
    }
}
