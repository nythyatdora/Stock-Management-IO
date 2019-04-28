package TeamImplementation.Monita;

public class ShortCut {
    private static String INPUT_TO_READ = "r#proID";
    private static String INPUT_TO_DELETE = "d#proID";
    private static String INPUT_TO_WRITE = "w#production-unit-price";


    public static void main(String[] args) {
        String[] read = INPUT_TO_READ.split("#");
        for (String r : read) {
            System.out.println(r);
        }

        String[] delete = INPUT_TO_DELETE.split("#");
        for (String d : delete) {
            System.out.println(d);
        }

        String[] write = INPUT_TO_WRITE.split("[#-]+");
        for (String w : write) {
            System.out.println(w);
        }
    }
}