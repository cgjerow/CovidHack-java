public interface TestMethod<T extends Testable>
{
    String description();
    Accuracy<T> accuracy();
}
