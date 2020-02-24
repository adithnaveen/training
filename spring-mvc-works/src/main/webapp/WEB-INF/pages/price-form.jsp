<%@ include file="./header.jspf"%>


<h1>Enter the price Range:</h1>

<form action="products-by-price-range" method="GET">

	<div class="row form-group">
		<label class="col-md-4" for="min">Enter Min Price: </label>
		<div class="col-md-8">
			<input type="text" id="min" name="min" class="form-control" />
		</div>
	</div>
	<div class="row form-group">
		<label class="col-md-4" for="max">Enter Max Price: </label>
		<div class="col-md-8">
			<input type="text" id="max" name="max" class="form-control" />
		</div>

	</div>

	<button class="btn btn-primary">Submit</button>


</form>

<%@ include file="./footer.jspf"%>