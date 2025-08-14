package tagext;

import java.io.*;
import java.util.*;
import jakarta.servlet.jsp.*;
import jakarta.servlet.jsp.tagext.*;

public class Tag4Handler extends TagSupport
{   
    String name;
    
    public int doStartTag() throws JspTagException
    {
        pageContext.setAttribute("name",name);
        pageContext.setAttribute("className",getClass().getName());
        pageContext.setAttribute("date",new Date());
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
        return EVAL_PAGE;
    }
}