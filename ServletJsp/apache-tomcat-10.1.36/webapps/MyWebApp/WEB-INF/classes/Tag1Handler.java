package tagext;

import java.io.*;
import java.util.*;
import jakarta.servlet.jsp.*;
import jakarta.servlet.jsp.tagext.*;

public class Tag1Handler extends TagSupport
{
    public int doStartTag() throws JspTagException
    {
        return EVAL_BODY_INCLUDE;
    }
    public int doEndTag() throws JspTagException
    {
        JspWriter out = pageContext.getOut();
        try {
            out.println("</br> Hello World </br>");
            out.println("My Name is "+getClass().getName());
            out.println("</br> Today's date is "+new Date());
            return EVAL_PAGE;
        } catch (Exception e) {
            throw new JspTagException(e.toString());
        }
    }
}