<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../Common/header.jspf"%>
<title>Create test</title>
</head>
<body>

	<div class="container-fluid">
		<%@ include file="../../Common/navbar.jspf"%>
		<div class="row" style="margin-top: 20px;">
			<div class="col-12 ">
				<h2  style="text-align: center;">Create test</h2>
				<form method="post" action="createTest">
					<div class="row col-12" align="center" style="margin-top: 50px;">
						<div class="col-4"></div>
						<div class="col-2" style="text-align: right;">
							<label for="label">Label: </label>
						</div>
						<div class="col-2">
							<input type="text" id="label" name="label" value="" />
						</div>
						<div class="col-4"></div>
					</div>

					<div class="row col-12" align="center" style="margin-top: 20px;">
						<div class="col-4"></div>
						<div class="col-2" style="text-align: right;">
							<label for="statement">Statement: </label>
						</div>
						<div class="col-2">
							<input type="text" id="statement" name="statement" value="" />
						</div>
						<div class="col-4"></div>
					</div>

					<div class="row col-12" align="center" style="margin-top: 20px;">
						<div class="col-4"></div>
						<div class="col-2" style="text-align: right;">
							<label for="duration">Duration: </label>
						</div>
						<div class="col-2">
							<input type="text" id="duration" name="duration" value="" />
						</div>
						<div class="col-4"></div>
					</div>

					<div class="row col-12" align="center" style="margin-top: 20px;">
						<div class="col-4"></div>
						<div class="col-2" style="text-align: right;">
							<label for="high_level">High Level: </label>
						</div>
						<div class="col-2">
							<input type="text" id="high_level" name="high_level" value="" />
						</div>
						<div class="col-4"></div>
					</div>

					<div class="row col-12" align="center" style="margin-top: 20px;">
						<div class="col-4"></div>
						<div class="col-2" style="text-align: right;">
							<label for="low_level">Low Level: </label>
						</div>
						<div class="col-2">
							<input type="text" id="low_level" name="low_level" value="" />
						</div>
						<div class="col-4"></div>
					</div>

					<div class="row col-12" align="center" style="margin-top: 20px;">
						<div class="col-4"></div>
						<div class="col-2"></div>
						<div class="col-2">
							<input type="submit" value="CreateTest" class="sansLabel" />
						</div>
						<div class="col-4"></div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>