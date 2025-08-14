
<%@ page import="java.util.Date, java.sql.*" %>
<%= new java.util.Date() %>
<%= new Date() %>
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