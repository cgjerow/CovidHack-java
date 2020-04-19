import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.*;

public class DateRangeTest
{
    // CONSTRUCTORS

    @Test
    public void createValidDateRange()
    {
        DateRange dateRange = new DateRange(new Date(0), new Date(10));
        assertNotNull(dateRange);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidDateRange()
    {
        new DateRange(new Date(10), new Date(0));
    }
}