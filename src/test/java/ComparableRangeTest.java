import org.junit.Test;

import static org.junit.Assert.*;

public class ComparableRangeTest
{
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

    public class ComparableIntegerRange extends ComparableRange<Integer>
    {

        ComparableIntegerRange(Integer start, Integer end)
        {
            super(start, end);
        }

        @Override
        public Boolean after(Range<Integer> range) {
            return null;
        }

        @Override
        public Boolean after(Integer value) {
            return null;
        }

        @Override
        public Boolean before(Range<Integer> range) {
            return null;
        }

        @Override
        public Boolean before(Integer value) {
            return null;
        }

        @Override
        public Integer end() {
            return null;
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
            return null;
        }
    }
}