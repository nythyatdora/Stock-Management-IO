public class CommonMethod {
    private static final CommonMethodImplementation METHOD_IMPLEMENTATION = new CommonMethodImplementation();

    public static void printlnStrings(String[] arr) {
        METHOD_IMPLEMENTATION.printlnStringsImp(arr);
    }
}
