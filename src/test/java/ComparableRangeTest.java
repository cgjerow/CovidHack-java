import org.junit.Test;

import static org.junit.Assert.*;

public class ComparableRangeTest
{

    // CONSTRUCTORS

    @Test
    public void testConstructorWithValidIntegers()
    {
        ComparableRange comparableRange = new ComparableIntegerRange(1,2);
        ComparableRange comparableRange1 = new ComparableIntegerRange(1,1);
        assertNotNull(comparableRange);
        assertNotNull(comparableRange1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvertedIntegers()
    {
        new ComparableIntegerRange(2,1);
    }



    // COMPARE TO

    @Test
    public void compareToEquals()
    {
        ComparableRange comparableRange = new ComparableIntegerRange(1,2);
        ComparableRange comparableRange1 = new ComparableIntegerRange(1,2);
        assertEquals(0, comparableRange.compareTo(comparableRange1));
    }

    @Test
    public void compareToStartIsLessButEndIsMore()
    {
        ComparableRange comparableRange = new ComparableIntegerRange(1,2);
        ComparableRange comparableRange1 = new ComparableIntegerRange(0,3);

        // Start takes precedence over end for comparison
        assert(0 < comparableRange.compareTo(comparableRange1));
    }

    @Test
    public void compareToStartIsEqualEndIsMore()
    {
        ComparableRange comparableRange = new ComparableIntegerRange(1,2);
        ComparableRange comparableRange1 = new ComparableIntegerRange(1,3);
        assert(0 > comparableRange.compareTo(comparableRange1));
    }



    // AFTER

    @Test
    public void valueAfterAndNotAfter()
    {

        ComparableRange comparableRange1 = new ComparableIntegerRange(1,2);

        assertTrue("Should be after value", comparableRange1.after((Integer)0));
        assertFalse("Should not be after value", comparableRange1.after((Integer)1));
        assertFalse("Should not be after value", comparableRange1.after((Integer)3));
    }

    @Test
    public void rangeAfterAndNotAfter()
    {
        ComparableIntegerRange comparableRange1 = new ComparableIntegerRange(1,2);
        ComparableIntegerRange comparableRange2 = new ComparableIntegerRange(0,0);
        ComparableIntegerRange comparableRange3 = new ComparableIntegerRange(1,2);

        assertTrue("Should be after range", comparableRange1.after(comparableRange2));
        assertFalse("Should not be after range", comparableRange1.after(comparableRange3));
    }

    @Test
    public void rangeBeforeAndNotBefore()
    {
        ComparableRange comparableRange1 = new ComparableIntegerRange(1,2);
        ComparableRange comparableRange2 = new ComparableIntegerRange(0,0);
        ComparableRange comparableRange3 = new ComparableIntegerRange(3,3);

        assertTrue("Should be before range", comparableRange1.before(comparableRange3));
        assertFalse("Should not be before range", comparableRange1.before(comparableRange2));
    }



    public class ComparableIntegerRange extends ComparableRange<Integer>
    {

        ComparableIntegerRange(Integer start, Integer end)
        {
            super(start, end);
        }

        @Override
        public Boolean before(Integer value) {
            return null;
        }

        @Override
        public Integer end() {
            return this.end;
        }

        @Override
        public Boolean includes(Range<Integer> range) {
            return null;
        }

        @Override
        public Boolean includes(Integer value) {
            return null;
        }

        @Override
        public Boolean isPoint() {
            return null;
        }

        @Override
        public Boolean overlaps(Range<Integer> range) {
            return null;
        }

        @Override
        public Integer start() {
            return this.start;
        }
    }
}