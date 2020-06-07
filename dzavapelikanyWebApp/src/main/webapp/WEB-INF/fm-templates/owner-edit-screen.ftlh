<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="description" content="Strona mojej firmy"/>
    <title>DzavaApp - Edycja danych</title>
    <link rel="stylesheet" href="../../styles.css"/>
    <link href="../../form.css" rel="stylesheet"/>
    <link href='https://fonts.googleapis.com/css?family=Atomic Age' rel='stylesheet'>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand logo" href="/owner-menu"><h2>DzavaApp!</h2></a>
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
            <li class="nav-item active">
                <a class="nav-link" href="/owner-menu">Menu</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/owner-contact-us">Kontakt</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/logout">Wyloguj</a>
            </li>
        </ul>
    </div>
</nav>

<header class="jumbotron">
    <div class="container my-header">
        <h1 class="display-3">Twoje dane</h1>
    </div>
</header>

<main role="main">
    <p><#if msg??>${msg}<#else> </#if>
    </p>
    <main role="main">
        <main role="main">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h3 class="display-5">Formularz edycji</h3>
                    </div>
                </div>

    <p><input class="button" type ="button" id="myMenu" value="<-- Powrot"/></p>

                <form class="form-inline" method="post" action="/owner-edit-details" class="form">
                    <div class="form-group mb-2">Imię:
                        <label for="name" class="sr-only">Imię</label>
                        <input type="text" class="form-control" id="name" value="${name}" name="name">
                    </div>
                    <br />
                    <div class="form-group mx-sm-3 mb-2">Nazwisko:
                        <label for="surname" class="sr-only">Nazwisko</label>
                        <input type="text" class="form-control" id="surname" value="${surname}" name="surname">
                    </div>
                    <br />
                    <div class="form-group mb-2">Email:
                        <label for="email" class="sr-only">Email</label>
                        <input type="text" class="form-control" id="email" value="${email}" name="email">
                    </div>
                    <br/>
                    <div class="form-group mb-2">Hasło:
                        <label for="password" class="sr-only">Password</label>
                        <input type="text" class="form-control" id="inputPassword2" value="${password}" name="password">
                    </div>
                    <button type="submit" class="btn btn-primary mb-2">Zapisz zmiany</button>
                </form>
                <form action="/delete-owner" method="post">
                    <input type="hidden" name="action" value="delete"/>
                    <button type="submit" class="btn btn-danger mb-2" value="delete">Usuń użytkownika</button>
                </form>
            </div>
        </main>
    </main>
</main>

<#include "footer.ftlh">

</body>
</html>