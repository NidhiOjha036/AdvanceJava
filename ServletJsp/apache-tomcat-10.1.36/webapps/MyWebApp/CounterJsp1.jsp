<%@ page import="com.mikado.Counter" %>

<jsp:useBean id="count" scope="request" class="com.mikado.Counter" />
<% out.println(count.getCount()); %>