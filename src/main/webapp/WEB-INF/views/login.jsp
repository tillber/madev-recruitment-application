<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>RecruitmentApplication</title>
<!-- CSS File -->
<link th:href="@{/css/style.css}" rel="stylesheet" />
<!-- Bulma.io CSS Framework CDN -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.8.0/css/bulma.min.css" integrity="sha256-D9M5yrVDqFlla7nlELDaYZIpXfFWDytQtiV+TaH6F1I=" crossorigin="anonymous" />
</head>
<body>
<div class="container">
<form class="login-form" method="post" action="./api/">
<div class="form-title">
<!--<p class="title is-4">Recruitment Application</p>
<p class="subtitle is-6">Java REST Web App deployed on Heroku</p>-->
<img src="https://ssl.gstatic.com/images/branding/product/2x/avatar_circle_blue_48dp.png"/>
</div>
<div class="field">
  <div class="control">
    <input class="input" type="text" placeholder="Username" name="username" required>
  </div>
</div>
<div class="field">
  <div class="control">
    <input class="input" type="password" placeholder="Password" name="password" required>
  </div>
</div>
<div class="control">
  <button class="button is-primary is-fullwidth" type="submit">Login</button>
  <button class="button is-link is-light is-fullwidth is-small register-button">Register account</button>
</div>
</form>
</div>
</body>
</html>