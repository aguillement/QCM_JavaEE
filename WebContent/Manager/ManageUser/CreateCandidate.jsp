<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../../Common/header.jspf"%>
<title>Ajouter un candidat</title>
</head>
<body>
	<div class="container-fluid">
		<%@ include file="../../Common/navbar.jspf"%>
		<div class="row" style="margin-top:20px;">
			<div class="col-lg-12">
				<h2>Créer un candidat</h2>
				
				<c:if test="${!empty  requestScope.isInsert }">
				    <c:choose>
					    <c:when test="${ requestScope.isInsert }">
					    	<div class="alert alert-dismissible alert-success">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								<strong>Succès!</strong>
								<c:out value='${requestScope.message}' />
							</div>
					    </c:when>
					    <c:otherwise>
						    <div class="alert alert-dismissible alert-primary">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								<strong>Attention!</strong>
								<c:out value='${requestScope.message}' />
							</div>
					    </c:otherwise>
					</c:choose>
				</c:if>

				<form
					action="
					<c:out value="${pageContext.servletContext.contextPath}" />
					/Responsable/utilisateur/ajouter"
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