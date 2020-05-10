<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="description" content="Strona mojej firmy"/>
    <title>DzavaApp - Logowanie.</title>
    <link rel="stylesheet" href="../../styles.css"/>
    <link href="../../form.css" rel="stylesheet"/>
    <link href='https://fonts.googleapis.com/css?family=Atomic Age' rel='stylesheet'>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand logo" href="/homepage"><h2>DzavaApp!</h2></a>
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
                <a class="nav-link" href="/homepage">Strona Główna</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/registration">Rejestracja</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/login">Logowanie</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/contact">Kontakt</a>
            </li>
        </ul>
    </div>
</nav>

<header class="jumbotron">
    <div class="container">
        <h1 class="display-3">Logowanie</h1>
    </div>
</header>

<main role="main">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <h3 class="display-5">Formularz logowania</h3>
            </div>
        </div>

        <form action="action" method="post" class="contact-from">
            <div class="row">
                <div class="form col-lg-6 col-sm-12">
                    <label for="login">Login:</label>
                    <input type="text" name="login" id="login" required/>
                </div>
                <div class="form col-lg-6 col-sm-12">
                    <label for="password">Hasło:</label>
                    <input type="password" name="password" id="password" required/>
                </div>
                <div class="form col-12">
                    <button class="btn btn-primary" type="submit">
                        Zaloguj
                    </button>
                </div>
            </div>
        </form>
    </div>
</main>

<#include "footer.ftlh">

</body>
</html>
