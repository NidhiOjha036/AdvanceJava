package tagext;

import java.io.*;
import java.util.*;
import jakarta.servlet.jsp.*;
import jakarta.servlet.jsp.tagext.*;

public class Tag2Handler extends TagSupport
{   
    String name;
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
    public int doEndTag() throws JspTagException
    {
        JspWriter out = pageContext.getOut();
        try {
            out.println("Hello "+name);
        } catch (Exception e) {
            throw new JspTagException(e.toString());
        }
        return EVAL_PAGE;
    }
}