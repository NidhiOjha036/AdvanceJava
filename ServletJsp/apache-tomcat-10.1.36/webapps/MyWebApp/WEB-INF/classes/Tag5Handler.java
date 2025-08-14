package tagext;

import java.io.*;
import java.util.*;
import jakarta.servlet.jsp.*;
import jakarta.servlet.jsp.tagext.*;

public class Tag5Handler extends TagSupport {
    List names;
    int index;

    public int doStartTag() throws JspTagException {
        index = 0;
        setLoopVariables();
        return EVAL_BODY_INCLUDE;
    }

    public void setLoopVariables() {
        pageContext.setAttribute("name", names.get(index));
        pageContext.setAttribute("index", new Integer(index));
    }

    public int doAfterBody() {
        if (++index < names.size()) {
            setLoopVariables();
            return EVAL_BODY_AGAIN;
        }
        return SKIP_BODY;
    }
    
    public void setNames(List names) {
        this.names = names;
    }

    public List getNames() {
        return names;
    }
    
    public int doEndTag() throws JspTagException {
        pageContext.setAttribute("className", getClass().getName());
        pageContext.setAttribute("date", new Date());
        return EVAL_PAGE;
    }
    
}