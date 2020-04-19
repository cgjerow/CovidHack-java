// Interface modeled after https://ci.apache.org/projects/ofbiz/site/javadocs/org/ofbiz/base/lang/Range.html

public abstract class ComparableRange<T extends Comparable<T>> implements Comparable<ComparableRange<T>>, Range<T>
{
    protected final T end;
    protected final T start;

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

    public T start()
    {
        return this.start;
    }

    public T end()
    {
        return this.end;
    }

    public final Boolean isPoint()
    {
        return this.start.compareTo(this.end)==0;
    }


    @Override
    public int compareTo(ComparableRange<T> o)
    {
        if (this.start.compareTo(o.start)==0 && this.end.compareTo(o.end)==0) return 0;
        if (this.start.compareTo(o.start)==0) return this.end.compareTo(o.end);
        return this.start.compareTo(o.start);
    }




    public final Boolean before(Range<T> range)
    {
        return this.end.compareTo(range.start()) < 0;
    }
    public final Boolean before(T value)
    {
        return this.end.compareTo(value) < 0;
    }




    public final Boolean after(Range<T> range)
    {
        return this.start.compareTo(range.end()) > 0;
    }
    public final Boolean after(T value)
    {
        return this.start.compareTo(value) > 0;
    }




    public final Boolean includes(Range<T> range)
    {
        return this.includes(range.start()) && this.includes(range.end());
    }

    public final Boolean includes(T value)
    {
        return this.start.compareTo(value) < 1 && this.end.compareTo(value) > -1;
    }




    public final Boolean overlaps(Range<T> range)
    {
        return this.includes(range.start()) || this.includes(range.end()) || range.includes(this);
    }
}
