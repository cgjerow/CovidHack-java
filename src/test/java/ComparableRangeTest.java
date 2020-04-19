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



    // GETTERS

    @Test
    public void startGetter()
    {
        assertEquals((Integer)1, new ComparableIntegerRange(1,2).start());
    }
    @Test
    public void endGetter()
    {
        assertEquals((Integer)2, new ComparableIntegerRange(1,2).end());
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



    // BEFORE

    @Test
    public void valueBeforeAndNotBefore()
    {

        ComparableRange comparableRange1 = new ComparableIntegerRange(1,2);

        assertTrue("Should be before value", comparableRange1.before(3));
        assertFalse("Should not be before value", comparableRange1.before(2));
        assertFalse("Should not be before value", comparableRange1.before(0));
    }
    @Test
    public void rangeBeforeAndNotBefore()
    {
        ComparableRange comparableRange1 = new ComparableIntegerRange(1,2);
        ComparableRange comparableRange2 = new ComparableIntegerRange(0,0);
        ComparableRange comparableRange3 = new ComparableIntegerRange(3,3);

        assertTrue("Should be before range", comparableRange1.before((Range)comparableRange3));
        assertFalse("Should not be before range", comparableRange1.before((Range)comparableRange2));
    }



    // AFTER

    @Test
    public void valueAfterAndNotAfter()
    {

        ComparableRange comparableRange1 = new ComparableIntegerRange(1,2);

        assertTrue("Should be after value", comparableRange1.after(0));
        assertFalse("Should not be after value", comparableRange1.after(1));
        assertFalse("Should not be after value", comparableRange1.after(3));
    }
    @Test
    public void rangeAfterAndNotAfter()
    {
        ComparableRange comparableRange1 = new ComparableIntegerRange(1,2);
        ComparableRange comparableRange2 = new ComparableIntegerRange(0,0);
        ComparableRange comparableRange3 = new ComparableIntegerRange(1,2);

        assertTrue("Should be after range", comparableRange1.after((Range)comparableRange2));
        assertFalse("Should not be after range", comparableRange1.after((Range)comparableRange3));
    }



    // IS POINT

    @Test
    public void isPointAndIsNotPoint()
    {
        ComparableRange comparableRange1 = new ComparableIntegerRange(1,1);
        ComparableRange comparableRange2 = new ComparableIntegerRange(1,2);

        assertTrue("Should be point", comparableRange1.isPoint());
        assertFalse("Should not be point",comparableRange2.isPoint());
    }


    // INCLUDES

    @Test
    public void rangeIncludesAndDoesNotInclude()
    {
        ComparableRange comparableRange1 = new ComparableIntegerRange(1,10);
        ComparableRange comparableRange2 = new ComparableIntegerRange(2,2);
        ComparableRange comparableRange3 = new ComparableIntegerRange(0,5);
        ComparableRange comparableRange4 = new ComparableIntegerRange(5,15);
        ComparableRange comparableRange5 = new ComparableIntegerRange(100,101);

        assertTrue("Should include range", comparableRange1.includes((Range)comparableRange2));
        assertFalse("Should not include range", comparableRange1.includes((Range)comparableRange3));
        assertFalse("Should not include range", comparableRange1.includes((Range)comparableRange4));
        assertFalse("Should not include range", comparableRange1.includes((Range)comparableRange5));

    }
    @Test
    public void valueIncludesAndDoesNotInclude()
    {
        ComparableRange comparableRange1 = new ComparableIntegerRange(1,10);

        assertTrue("Should include value", comparableRange1.includes(5));
        assertFalse("Should not include value", comparableRange1.includes(0));
        assertFalse("Should not include value", comparableRange1.includes(14));

        // Edge cases
        assertTrue("Should include value", comparableRange1.includes(1));
        assertTrue("Should include value", comparableRange1.includes(10));

    }



    public class ComparableIntegerRange extends ComparableRange<Integer>
    {
        ComparableIntegerRange(Integer start, Integer end)
        {
            super(start, end);
        }
    }
}