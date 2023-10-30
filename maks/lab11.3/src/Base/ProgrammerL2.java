package Base;

import Base.ProgrammerL1;

public class ProgrammerL2 extends ProgrammerL1 {
    int P;
    double Qp;
    public ProgrammerL2(String lname, int pDone, int pLang, int dProperly) {
        super(lname, pDone, pLang);
        this.P = dProperly;
        this.Qp = (double) (Q * P) / programsDone;
    }
    @Override
    public String toString() {
        return String.format("Фамилия: %s\nЧисло программ: %d\nЧисло ЯП: %d\nQ: %d\nP: %d\nQp: %.2f\n\n", lastmane, programsDone, programmingLanguages, Q, P, Qp);
    }
}
