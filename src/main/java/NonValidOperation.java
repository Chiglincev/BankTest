public class NonValidOperation extends RuntimeException {

    public NonValidOperation() {
        super("Недопустимая операция");
    }
}
