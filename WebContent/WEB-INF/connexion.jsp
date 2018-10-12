<%@ include file="../../Common/header.jspf"%>
<title>Connexion</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row" style="margin-top: 20px;">
			<div class="col-lg-12 text-center">
				<h1>Test</h1>
			</div>
		</div>
		<div class="row" style="margin-top: 20px;">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">
				<div class="text-center">
					<h2>Connexion</h2>
				</div>
				<form method="post" action="connexion">
					<div class="form-group">
						<label for="mail" class="col-form-label">Adresse email <span
							class="required">*</span></label> <input type="email" id="mail"
							class="form-control" placeholder="Email" name="tmail" value="" />
						<span class="error">${form.erreurs['tmail']}</span>
					</div>
					<div class="form-group">
						<label for="password" class="col-form-label">Mot de passe
							<span class="required">*</span>
						</label> <input type="password" id="password" class="form-control"
							placeholder="Mot de passe" name="tpassword" value="" /> <span
							class="error">${form.erreurs['tpassword']}</span>
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-outline-success">Connexion</button>
					</div>

					<p class="${empty form.errors ? 'succes' : 'erreur'}">${form.results}</p>
				</form>
			</div>
		</div>
		<div class="col-lg-4"></div>
	</div>
</body>
</html>