<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../Common/header.jspf"%>
<title>Inscription test</title>
</head>
<body>
	<%@ include file="../../Common/navbar.jspf"%>

	${test.getLabel()} - ${test.getStatement()}

	<c:forEach items="${requestScope.promos}" var="promo">
		<li>
			${promo.getLabel()}
		<li>
	</c:forEach>

</body>
</html>