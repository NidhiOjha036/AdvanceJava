<%@ page import="java.util.Date, java.sql.*" %>
<%= new java.util.Date() %>
<%= new Date() %>
<%! 
int count; // Declarative tag

public int getCount() {
    return count++;
}
%>
<% out.println(getCount()); %>
<%
if(Math.random() < 0.5)
{
    out.println("Hi");
}
else
{
    out.println("Bye");
}
%>