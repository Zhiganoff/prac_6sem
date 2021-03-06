<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Product Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add a Product
</h1>
<form action="http://localhost:8080/SpringMVCHibernate/">
    <input type="submit" value="Main Page" />
</form>
<c:url var="addAction" value="/product/add" ></c:url>

<form:form action="${addAction}" commandName="productBridge">
    <table>
        <c:if test="${!empty productBridge.name}">
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
                <form:label path="producttypeId">
                    <spring:message text="Product Type"/>
                </form:label>
            </td>
            <td>
                <form:input path="producttypeId" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="producerId">
                    <spring:message text="Producer"/>
                </form:label>
            </td>
            <td>
                <form:input path="producerId" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="cost">
                    <spring:message text="Cost"/>
                </form:label>
            </td>
            <td>
                <form:input path="cost" />
            </td>
        </tr>
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
            <td>
                <form:label path="size">
                    <spring:message text="Size"/>
                </form:label>
            </td>
            <td>
                <form:input path="size" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="properties">
                    <spring:message text="Properties"/>
                </form:label>
            </td>
            <td>
                <form:input path="properties" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty productBridge.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Product"/>" />
                </c:if>
                <c:if test="${empty productBridge.name}">
                    <input type="submit"
                           value="<spring:message text="Add Product"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Clients List</h3>
<c:if test="${!empty listProducts}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Product Type</th>
            <th width="120">Producer</th>
            <th width="80">Cost</th>
            <th width="60">Number</th>
            <th width="60">Size</th>
            <th width="60">Properties</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listProducts}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.productTypeByProducttypeId.name}</td>
                <td>${product.producerByProducerId.name}</td>
                <td>${product.cost}</td>
                <td>${product.num}</td>
                <td>${product.size}</td>
                <td>${product.properties}</td>
                <td><a href="<c:url value='/products/edit/${product.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/products/remove/${product.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
