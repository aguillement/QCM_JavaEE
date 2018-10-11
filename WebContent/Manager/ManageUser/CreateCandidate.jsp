<%@ include file="../../Common/header.jspf"%>
<title>Ajouter un candidat</title>
</head>
<body>
	<div class="container-fluid">
		<%@ include file="../../Common/navbar.jspf"%>
		<div class="row" style="margin-top:20px;">
			<div class="col-lg-12">
				<h2>Créer un candidat</h2>
				<%
					if (request.getAttribute("isInsert") != null) {
						if ((boolean) request.getAttribute("isInsert")) {
				%>
				<div class="alert alert-dismissible alert-success">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<strong>Succès!</strong>
					<%=request.getAttribute("message")%>
				</div>
				<%
					} else {
				%>
				<div class="alert alert-dismissible alert-primary">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<strong>Attention!</strong>
					<%=request.getAttribute("message")%>
				</div>
				<%
					}
					}
				%>

				<form
					action="<%=request.getContextPath()%>/Responsable/utilisateur/ajouter"
					name="formAddUser" method="post">
					<fieldset>
						<div class="form-group">
							<label for="lastname">Nom :</label> <input class="form-control"
								type="text" name="tLastname" id="lastname" />
						</div>

						<div class="form-group">
							<label for="firstname">Prénom :</label> <input
								class="form-control" type="text" name="tFirstname"
								id="firstname" />
						</div>

						<div class="form-group">
							<label for="mail">Email :</label> <input class="form-control"
								type="mail" name="tMail" id="mail" />
						</div>
						<div class="text-center">
							<button type="submit" class="btn btn-outline-success"
								name="bSave" value="Enregistrer">Enregistrer</button>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>