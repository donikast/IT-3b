<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="bg">
<head>
<meta charset="UTF-8">
<title>Вписване на потребител</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<div class="content">
		<h1>Вход в приложението</h1>
		<div class="form-container">
			<form action="login" method="post">

				<div class="mt20-mb10">
					<label for="username">Потребителско име</label> <input type="text"
						name="username" id="username"
						placeholder="Въведете потребителско име" />
				</div>
				<div class="mt20-mb10">
					<label for="password">Парола</label> <input type="password"
						name="password" id="password"
						placeholder="Въведете парола с поне 8 символа" />
				</div>

				<input type="submit" value="Вход" />
			</form>
		</div>
	</div>
</body>
</html> 