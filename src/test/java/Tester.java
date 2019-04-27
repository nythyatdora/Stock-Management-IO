public class Tester {

    BaseCode baseCode;
    public Tester() {
        baseCode = new BaseCode();
    }

    public static void main(String[] args) {
        Tester tester = new Tester();
        tester.baseCode.outputHelpScreen();
    }
}
