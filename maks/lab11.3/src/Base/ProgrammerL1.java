package Base;

public class ProgrammerL1 {
    // Поля класса
    String lastmane;
    int programsDone;
    int programmingLanguages;
    int Q;
    public ProgrammerL1(String lname, int pDone, int pLang) {
        this.lastmane = lname;
        this.programsDone = pDone;
        this.programmingLanguages = pLang;
        this.Q = programsDone * programmingLanguages;
    }
}
