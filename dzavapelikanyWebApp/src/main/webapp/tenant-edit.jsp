<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="description" content="Strona mojej firmy"/>
    <title>DzavaApp - Szukaj pokoju.</title>
    <link rel="stylesheet" href="../../styles.css"/>
    <link href="../../form.css" rel="stylesheet"/>
    <link href='https://fonts.googleapis.com/css?family=Atomic Age' rel='stylesheet'>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
<%
String name = (String)session.getAttribute("name");
String surname = (String)session.getAttribute("surname");
String email = (String)session.getAttribute("email");
String password = (String)session.getAttribute("password");
%>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand logo" href="/tenant-menu"><h2>DzavaApp!</h2></a>
    <button
            class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navigation"
    >
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navigation">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/tenant-menu">Menu Lokatora</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/tenant-room">Twój Pokój</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/tenant-search-room">Szukaj Pokoju</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/tenant-edit-details">Edycja Danych</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/tenant-contact-us">Kontakt</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/logout">Wyloguj</a>
            </li>
        </ul>
    </div>
</nav>

<header class="jumbotron">
    <div class="container">
        <h1 class="display-3">Edytuj swoje dane</h1>
    </div>
</header>
<main role="main">
    <form class="form-inline" method="post" action="${pageContext.request.contextPath}/tenant-edit-details">
        <div class="form-group mb-2">
            <label for="name" class="sr-only">Imię</label>
            <input type="text" class="form-control" id="name" placeholder="<% System.out.println(name);%>" name="name" />
        </div>
        <div class="form-group mx-sm-3 mb-2">
            <label for="surname" class="sr-only">Nazwisko</label>
            <input type="password" class="form-control" id="surname" placeholder="<% System.out.println(surname);%>" name="surname">
        </div>
        <br />
        <div class="form-group mb-2">
            <label for="email" class="sr-only">Email</label>
            <input type="text" class="form-control" id="email" placeholder="<% System.out.println(email);%>" name="email" />
        </div>
        <div class="form-group mx-sm-3 mb-2">
            <label for="inputPassword2" class="sr-only">Hasło</label>
            <input type="password" class="form-control" id="inputPassword2" placeholder="<% System.out.println(password);%>" name="password">
        </div>
        <button type="submit" class="btn btn-primary mb-2">Edytuj</button>
    </form>
</main>

<#include "footer.ftlh">

</body>
</html>