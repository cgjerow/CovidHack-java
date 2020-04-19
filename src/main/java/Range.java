// modeled after https://ci.apache.org/projects/ofbiz/site/javadocs/org/ofbiz/base/lang/Range.html
public interface Range<T>
{
    boolean after(Range<T> range);
    boolean after(T value);
    boolean before(Range<T> range);
    boolean before(T value);
    T end();
    boolean includes(Range<T> range);
    boolean includes(T value);
    boolean isPoint();
    boolean overlaps(Range<T> range);
    T start();
}
