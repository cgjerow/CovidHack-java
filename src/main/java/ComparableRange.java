/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 * NOTICE: This has been modified by the distributor
 *******************************************************************************/

public abstract class ComparableRange<T extends Comparable<T>> implements Comparable<ComparableRange<T>>, Range<T>
{
    protected final T end;
    protected final T start;
    protected final boolean isPoint;

    public ComparableRange(T point)
    {
        this(point,point);
    }
    public ComparableRange(T start, T end)
    {
        if (start.compareTo(end)>0)
            throw new IllegalArgumentException("Start must be less than or equal to End.");
        this.start = start;
        this.end = end;
        this.isPoint = start.equals(end);
    }

    public T start()
    {
        return this.start;
    }

    public T end()
    {
        return this.end;
    }

    public final boolean isPoint()
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




    public final boolean before(Range<T> range)
    {
        return this.end.compareTo(range.start()) < 0;
    }
    public final boolean before(T value)
    {
        return this.end.compareTo(value) < 0;
    }




    public final boolean after(Range<T> range)
    {
        return this.start.compareTo(range.end()) > 0;
    }
    public final boolean after(T value)
    {
        return this.start.compareTo(value) > 0;
    }




    public final boolean includes(Range<T> range)
    {
        return this.includes(range.start()) && this.includes(range.end());
    }

    public final boolean includes(T value)
    {
        return this.start.compareTo(value) < 1 && this.end.compareTo(value) > -1;
    }




    public final boolean overlaps(Range<T> range)
    {
        return this.includes(range.start()) || this.includes(range.end()) || range.includes(this);
    }
}
