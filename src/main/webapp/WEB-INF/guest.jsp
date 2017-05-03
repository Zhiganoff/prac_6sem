<%@ page import="model.Client" %>
<%@ page import="java.util.Collection" %>;

<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:useBean id="clientList" type="java.util.List<model.Client>" scope="request" />
<%--<jsp:useBean id="clientList" type="java.lang.Integer" scope="request" />--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <head>
        <title>Page for testing</title>
    </head>

    <p>Wow, that's test</p>
    <p><%= clientList%></p>

    <%--<hr><ol>--%>
    <%--<% for (Client client : clientList) { %>--%>
    <%--<li> <%= client %> </li>--%>
    <%--<% } %>--%>
    <%--</ol><hr>--%>

    <%--<body>--%>
        <%--<form method="POST" action="guest.html">--%>
            <%--Name: <input type="text" name="name" />--%>
            <%--<input type="submit" value="Add" />--%>
        <%--</form>--%>
 <%----%>
        <%--<hr><ol> --%>
        <%--<% for (Guest guest : guestDao.getAllGuests()) { %>--%>
            <%--<li> <%= guest %> </li>--%>
        <%--<% } %>--%>
        <%--</ol><hr>--%>
 <%----%>
		<%--<iframe src="http://www.objectdb.com/pw.html?spring-download"--%>
            <%--frameborder="0" scrolling="no" width="100%" height="30"></iframe>--%>
	</body>
</html>