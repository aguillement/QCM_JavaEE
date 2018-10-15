<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../Common/header.jspf"%>
<title>Create theme</title>
</head>
<body>

	<div class="container-fluid">
		<%@ include file="../../Common/navbar.jspf"%>
		<div class="row" style="margin-top: 20px;">
			<div class="col-lg-12">
				<form method="post" action="createTheme">
					<fieldset>
						<legend>Create theme</legend>
						<label for="label">Libelle</label> <input
							type="text" id="label" name="label" value="" /> <br /> <input
							type="submit" value="CreateTheme" class="sansLabel" /> <br />
					</fieldset>
				</form>
			</div>
		</div>
	</div>

</body>
</html>