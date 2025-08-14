<%@ taglib uri="/WEB-INF/descriptor.tld" prefix="examples" %>

<%! java.util.List names = new java.util.LinkedList();

    public void jspInit() {
        names.add("Sanjay");
        names.add("Tarun");
        names.add("Pankaj");
    }

%>

<examples:helloIterator names="<%= names %>">
    <b> Hello <%= name %> ! you are at index <%= index %> in my list </b><br/>
</examples:helloIterator>
<br/>
We have finished Looping.  
But I can still access TagHandler's ClassName <%= className %> and date <%= date %>
