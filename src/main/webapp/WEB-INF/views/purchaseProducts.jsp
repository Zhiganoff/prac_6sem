<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>PurchaseProducts Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add a PurchaseProduct
</h1>
<form action="http://localhost:8080/SpringMVCHibernate/">
    <input type="submit" value="Main Page" />
</form>
<c:url var="addAction" value="/purchaseProducts/add" ></c:url>

<form:form action="${addAction}" commandName="purchaseProductsBridge">
    <table>
        <c:if test="${!empty purchaseProductsBridge.purchaseId}">
            <tr>
                <td>
                    <form:label path="purchaseId">
                        <spring:message text="Purchase ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="purchaseId" readonly="true" size="8"  disabled="true" />
                    <form:hidden path="purchaseId" />
                </td>
            </tr>
        </c:if>
        <c:if test="${!empty purchaseProductsBridge.productId}">
            <tr>
                <td>
                    <form:label path="productId">
                        <spring:message text="Product ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="productId" readonly="true" size="8"  disabled="true" />
                    <form:hidden path="productId" />
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="num">
                    <spring:message text="Number"/>
                </form:label>
            </td>
            <td>
                <form:input path="num" />
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <c:if test="${!empty purchaseProductsBridge.purchaseId}">
                    <input type="submit"
                           value="<spring:message text="Edit PurchaseProducts"/>" />
                </c:if>
                <c:if test="${empty purchaseProductsBridge.purchaseId}">
                    <input type="submit"
                           value="<spring:message text="Add PurchaseProducts"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>PurchaseProducts List</h3>
<c:if test="${!empty listPurchaseProducts}">
    <table class="tg">
        <tr>
            <th width="120">Purchase ID</th>
            <th width="120">Product ID</th>
            <th width="120">Number</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listPurchaseProducts}" var="purchaseProducts">
            <tr>
                <td>${purchaseProducts.purchaseId}</td>
                <td>${purchaseProducts.productByProductId.name}</td>
                <td>${purchaseProducts.num}</td>
                <td><a href="<c:url value='/purchaseProducts/edit/${purchaseProducts.purchaseId}-${purchaseProducts.productId}' />" >Edit</a></td>
                <td><a href="<c:url value='/purchaseProducts/remove/${purchaseProducts.purchaseId}-${purchaseProducts.productId}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
