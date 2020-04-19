public interface Testable
{
    Integer positiveResults();
    Integer negativeResults();
    Integer totalResults();
    Integer totalTaken();

    // More stuff : false positives / false negatives etc.
}
