<%@ include file="./header.jspf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>



<div class="col">

	<sf:form modelAttribute="product" action="save-product" method="POST">


		<div class="form-group row">
			<label class="col-md-4" for="productId">Product Id</label>
			<div class="col-md-8">
				<sf:input path="productId" cssClass="form-control" />
				<sf:errors path="productId" cssClass="text-danger" />
			</div>
		</div>

		<div class="form-group row">
			<label class="col-md-4" for="productName">Product Name</label>
			<div class="col-md-8">
				<sf:input path="productName" cssClass="form-control" />
				<sf:errors path="productName" cssClass="text-danger" />

			</div>
		</div>

		<div class="form-group row">
			<label class="col-md-4" for="productPrice">Product Price</label>
			<div class="col-md-8">
				<sf:input path="productPrice" cssClass="form-control" />
				<sf:errors path="productPrice" cssClass="text-danger" />

			</div>
		</div>
		<%-- 
	<div class="form-group row">
		<label class="col-md-4" for="categoryName">Category Name</label>
		<div class="col-md-8">
			<sf:input path="categoryName" cssClass="form-control" />
		</div>
	</div> --%>



		<div class="form-group row">
			<label class="col-md-4" for="categoryName">Category Name</label>
			<div class="col-md-8">
				<sf:select path="categoryName" cssClass="form-control custom-select">
					<sf:option value="-1">--Select--</sf:option>
					<sf:options items="${CATEGORIES}" />
					<sf:errors path="categoryName" cssClass="text-danger" />

				</sf:select>
			</div>
		</div>



		<div class="form-group row">
			<label class="col-md-4"></label>
			<div class="col-md-8">
				<button class="btn btn-primary">Submit</button>
			</div>
		</div>

	</sf:form>
</div>
<div class="col"></div>

<%@ include file="./footer.jspf"%>
