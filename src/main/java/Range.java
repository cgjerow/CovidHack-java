// modeled after https://ci.apache.org/projects/ofbiz/site/javadocs/org/ofbiz/base/lang/Range.html
public interface Range<T>
{
    Boolean after(Range<T> range);
    Boolean after(T value);
    Boolean before(Range<T> range);
    Boolean before(T value);
    T end();
    Boolean includes(Range<T> range);
    Boolean includes(T value);
    Boolean isPoint();
    Boolean overlaps(Range<T> range);
    T start();
}
