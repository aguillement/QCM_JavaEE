<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.jspf"%>
<title>Accès refusé</title>
</head>
<body>
	<div class="container-fluid">
		<%@ include file="navbar.jspf"%>
		<div class="row" style="margin-top: 20px;">
			<div class="col-lg-12">
				<h2>Accès refusé</h2>
				Vous devez avoir les drois pour pouvoir accèder à cette
				fonctionnalité. Retourner à l' <a
					href="<c:out value="${pageContext.servletContext.contextPath}" />">accueil</a>.
			</div>
		</div>
	</div>

</body>
</html>