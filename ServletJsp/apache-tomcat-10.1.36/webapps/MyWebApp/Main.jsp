<%@ page errorPage="err.jsp" %>

<%
    if(Math.random() < 0.5)
    {
        out.println("Hi");
    }
    else
    {
        throw new Exception("Bye");
    }
%>