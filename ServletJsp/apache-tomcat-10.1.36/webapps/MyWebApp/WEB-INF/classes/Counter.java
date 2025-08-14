package com.mikado;

public class Counter 
{
    int count;
    public void setCount(int count)
    {
        this.count = count;
    }
    public int getCount()
    {
        return count++;
    }
}
