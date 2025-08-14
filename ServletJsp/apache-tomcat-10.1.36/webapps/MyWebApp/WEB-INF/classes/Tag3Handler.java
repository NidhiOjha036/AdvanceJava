package tagext;

import java.io.*;
import java.util.*;
import jakarta.servlet.jsp.*;
import jakarta.servlet.jsp.tagext.*;

public class Tag3Handler extends TagSupport
{   
    String name;
    int count;
    public int doStartTag() throws JspTagException
    {
        return EVAL_BODY_INCLUDE;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public void setCount(int count)
    {
        this.count = count;
    }
    public int getCount()
    {
        return count;
    }

    public int doEndTag() throws JspTagException
    {
        JspWriter out = pageContext.getOut();
        try {
            out.println("Hello "+name+" count= "+count);
        } catch (Exception e) {
            throw new JspTagException(e.toString());
        }
        return EVAL_PAGE;
    }
}