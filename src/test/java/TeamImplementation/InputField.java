package TeamImplementation;

public class InputField {
    public interface InputType {
        int TYPE_TEXT = 1;
        int TYPE_INTEGER = 2;
        int TYPE_DOUBLE = 3;
    }

    public static <T> T readDataFromInputField(String placeholder, InputType inputType) {
        System.out.println(placeholder + " : ");
        return null;
    }

    public static void main(String[] args) {

    }
}
