package TestExample;

public class Shortcut {

    public static void main(String[] args) {
        String INPUT_TO_READ = "r#proId";
        String INPUT_TO_DELETE = "d#proId";
        String INPUT_TO_WRITE = "w ->#proname-unitprice-qty";

        String[] read = INPUT_TO_READ.split("#");
        for (String r : read) {
            System.out.println(r);
        }

        String[] delete = INPUT_TO_DELETE.split("#");
        for (String d : delete) {
            System.out.println(d);
        }

        String[] write = INPUT_TO_WRITE.split("[ ->#-]+");
        for (String w : write) {
            System.out.println(w);
        }
    }
}