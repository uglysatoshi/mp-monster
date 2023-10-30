public class Main {
    public static void Medium() {
        System.out.println("Средний уровень: ");
        SyncAutoM autoB = new SyncAutoM();
        for(int i = 0; i < 10; i++) {
            autoB.showStatement();
            autoB.changeStatement();
        }
    }
    public static void Hard() {
        System.out.println("Высокий уровень: ");
        SyncAutoH autoH = new SyncAutoH();
        for(int i = 0; i < 10; i++) {
            autoH.showStatement();
            autoH.changeStatement();
        }
    }
    public static void main(String[] args) {
        Medium();
        Hard();
    }
}