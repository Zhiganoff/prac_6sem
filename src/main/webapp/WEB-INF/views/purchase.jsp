<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Purchase Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add a Purchase
</h1>
<form action="http://localhost:8080/SpringMVCHibernate/">
    <input type="submit" value="Main Page" />
</form>
<c:url var="addAction" value="/purchase/add" ></c:url>

<form:form action="${addAction}" commandName="purchaseBridge">
    <table>
        <c:if test="${!empty purchaseBridge.id}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8"  disabled="true" />
                    <form:hidden path="id" />
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="clientId">
                    <spring:message text="Client"/>
                </form:label>
            </td>
            <td>
                <form:input path="clientId" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="date">
                    <spring:message text="Date"/>
                </form:label>
            </td>
            <td>
                <form:input path="date" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="address">
                    <spring:message text="Address"/>
                </form:label>
            </td>
            <td>
                <form:input path="address" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="status">
                    <spring:message text="Status"/>
                </form:label>
            </td>
            <td>
                <form:input path="status" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="deliveryMethod">
                    <spring:message text="Delivery Method"/>
                </form:label>
            </td>
            <td>
                <form:input path="deliveryMethod" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="paymentMethod">
                    <spring:message text="Payment Method"/>
                </form:label>
            </td>
            <td>
                <form:input path="paymentMethod" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty purchaseBridge.id}">
                    <input type="submit"
                           value="<spring:message text="Edit Purchase"/>" />
                </c:if>
                <c:if test="${empty purchaseBridge.id}">
                    <input type="submit"
                           value="<spring:message text="Add Purchase"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Purchases List</h3>
<c:if test="${!empty listPurchases}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Client</th>
            <th width="120">Date</th>
            <th width="120">Address</th>
            <th width="120">Status</th>
            <th width="80">Delivery Method</th>
            <th width="80">Payment Method</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listPurchases}" var="purchase">
            <tr>
                <td>${purchase.id}</td>
                <td>${purchase.clientByClientId.fullname}</td>
                <td>${purchase.date}</td>
                <td>${purchase.address}</td>
                <td>${purchase.status}</td>
                <td>${purchase.deliveryMethod}</td>
                <td>${purchase.paymentMethod}</td>
                <td><a href="<c:url value='/purchases/edit/${purchase.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/purchases/remove/${purchase.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
