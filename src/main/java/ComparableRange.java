// Interface modeled after https://ci.apache.org/projects/ofbiz/site/javadocs/org/ofbiz/base/lang/Range.html

public abstract class ComparableRange<T extends Comparable<T>> implements Comparable<ComparableRange<T>>, Range<T>
{
    protected T end;
    protected Boolean isPoint;
    protected T start;

    public ComparableRange(T start, T end)
    {
        this.start = start;
        this.end = end;
        this.validate();
    }

    private void validate()
    {
        if (this.start.compareTo(this.end)>0)
            throw new IllegalArgumentException("Start must be less than or equal to End.");
    }

    @Override
    public int compareTo(ComparableRange<T> o)
    {
        if (this.start.compareTo(o.start)==0 && this.end.compareTo(o.end)==0) return 0;
        if (this.start.compareTo(o.start)==0) return this.end.compareTo(o.end);
        return this.start.compareTo(o.start);
    }
}
