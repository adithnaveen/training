<%@page import="java.io.PrintWriter"%>
<%@ include file="./header.jspf"%>
<h2>Oops sorry error while processing the page</h2>

<button class="btn btn-link" onclick="showErrorDetails()">Show technical Details</button>
<pre style="visibility: hidden" id="errDetails">
<%
	Exception ex = (Exception) request.getAttribute("ex");

	//to pring on the end user, if you use ex.printStackTrace() it will give it in server 
	ex.printStackTrace(new PrintWriter(out));
%>
</pre>
<%@ include file="./footer.jspf"%>


<script>
	function showErrorDetails(){
		document.getElementById("errDetails").style.visibility="visible"; 
	}
</script>