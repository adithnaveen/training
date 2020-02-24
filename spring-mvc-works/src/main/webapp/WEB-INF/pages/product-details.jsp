<%@ include file="./header.jspf" %>

<h2>Product details for id ${param.id}</h2>

<a href="./edit-product?productId=${PRODUCT.productId}" class="btn btn-primary">Edit</a>
<br/>
<br/> <br/> 

 
<div class="row">

	<div class="col">
		<table class="table">
			<tbody>
				<tr>
					<td>ID</td>
					<td>${PRODUCT.productId}</td>
				</tr>
				<tr>
					<td>Name</td>
					<td>${PRODUCT.productName}</td>
				</tr>
				<tr>
					<td>Product Price</td>
					<td>${PRODUCT.productPrice}</td>
				</tr>
				<tr>
					<td>Category Name</td>
					<td>${PRODUCT.categoryName}</td>
				</tr>
				

			</tbody>
		</table>
	</div>
	<div class="col"></div>
</div>

<%@ include file="./footer.jspf" %>