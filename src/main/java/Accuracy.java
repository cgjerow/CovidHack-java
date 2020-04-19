import jdk.jfr.Percentage;

public interface Accuracy<T extends Testable>
{
    float accuracyRate();
    float falsePositiveRate();
    float falseNegativeRate();
}
