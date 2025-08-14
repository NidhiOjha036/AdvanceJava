<%@ taglib uri="/WEB-INF/descriptor.tld" prefix="examples" %>

<% String s = request.getParameter("name"); %>
<examples:attribHello1 name="<%= s %>" count="100" />