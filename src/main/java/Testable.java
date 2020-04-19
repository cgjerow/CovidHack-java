import java.util.Set;

public interface Testable
{
    Integer positiveResults();
    Integer negativeResults();
    Integer totalResults();
    Integer totalTaken();
    Set<TestMethod> availableMethods();
    // More stuff : false positives / false negatives etc.
}
