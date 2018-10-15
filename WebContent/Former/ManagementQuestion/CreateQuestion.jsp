<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../Common/header.jspf"%>
<title>Create question</title>
</head>
<body>

	<div class="container-fluid">
		<%@ include file="../../Common/navbar.jspf"%>
		<div class="row" style="margin-top: 20px;">
			<div class="col-lg-12">
			
				<form method="post" action="createQuestion">
					<fieldset>
						<legend>Create question</legend>
						<label for="statement">Statement</label>
						<input type="text" id="statement" name="statement" value="" /> <br />

						<label for="media">Media</label> <input
							type="text" id="media" name="media" value="" /> <br /> <label
							for="points">Points</label> <input
							type="text" id="points" name="points" value="" /> <br /> <select
							name="theme">
							<c:forEach items="${lstTheme}" var="theme">
								<option value="${theme.id}">${theme.label}</option>
							</c:forEach>
						</select> <br /> <input type="submit" value="CreateQuestion"
							class="sansLabel" /> <br />
					</fieldset>				
				</form>				
				
			</div>
		</div>
	</div>

</body>
</html>