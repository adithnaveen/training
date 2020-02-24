<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="./header.jspf" %>


<h1>${pageTitle}</h1>
<table class="table table-bordered table-striped">


	<thead>
		<tr>
			<th>SL No</th>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Product Price</th>
			<th>Category Name</th>
			
		</tr>
	</thead>


	<tbody>
		<c:forEach items="${PRODUCTS }" var="product" varStatus="status">
			<tr>
				<td>${status.index+1 }</td>
				
				<td>
				
				<a href="./product-details?productId=${product.productId }" class="btn btn-link">${product.productId }</a>
					
				
				</td>
				
				<td>${product.productName }</td>
				<td>${product.productPrice }</td>
				<td>${product.categoryName }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="./footer.jspf" %> 