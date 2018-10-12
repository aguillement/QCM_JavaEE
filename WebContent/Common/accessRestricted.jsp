<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.jspf"%>
<title>Accès restreint</title>
</head>
<body>
	<div class="container-fluid">
		<%@ include file="./Navbars/navbar_noConnected.jspf"%>
		<div class="row" style="margin-top: 20px;">
			<div class="col-lg-12">
				<h2>Accès restreint</h2>
				Vous devez être connecter pour accèder au site. Retourner à l'<a
					href="<c:out value="${pageContext.servletContext.contextPath}" />">accueil</a>.
			</div>
		</div>
	</div>
</body>
</html>