<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../Common/header.jspf"%>
<title>Inscription test</title>
</head>
<body>
	<%@ include file="../../Common/navbar.jspf"%>

	<ol>
		<c:forEach items="${requestScope.tests}" var="test">
			<li><a href="test/ajouter?id=${test.getId()}">${test.getLabel()} - ${test.getStatement()}</a>
			</li>
		</c:forEach>
	</ol>
</body>
</html>