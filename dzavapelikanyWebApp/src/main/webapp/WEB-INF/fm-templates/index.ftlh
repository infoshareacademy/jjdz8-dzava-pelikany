<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />

    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="description" content="Strona mojej firmy"/>
    <title>DzavaApp - Stronga główna.</title>
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
            <li class="nav-item active">
                <a class="nav-link" href="/homepage">Strona Główna</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/registration">Rejestracja</a>
            </li>
            <li class="nav-item">
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
        <h1 class="display-3">Aplikacja DzavaApp</h1>
    </div>
</header>

<main role="main">
    <div class="container">
        <p><#if msg??>${msg}<#else> </#if>
            <div class="row">
            <div class="col-lg-4 col-sm-12">
                <p>
                    Donec id elit non mi porta gravida at eget metus. Fusce dapibus,
                    tellus ac cursus commodo, tortor mauris condimentum nibh, ut
                    fermentum massa justo sit amet risus.
                </p>
                <a role="button" class="btn btn-secondary" href="/registration">
                    Zarejestruj się
                </a>
            </div>
            <div class="col-lg-4 col-sm-12">
                <p>
                    Donec id elit non mi porta gravida at eget metus. Fusce dapibus,
                    tellus ac cursus commodo, tortor mauris condimentum nibh, ut
                    fermentum massa justo sit amet risus.
                </p>
                <a
                        role="button"
                        class="btn btn-secondary"
                        href="/login"
                >
                    Zaloguj się
                </a>
            </div>
            <div class="col-lg-4 col-sm-12">
                <p>
                    Donec id elit non mi porta gravida at eget metus. Fusce dapibus,
                    tellus ac cursus commodo, tortor mauris condimentum nibh, ut
                    fermentum massa justo sit amet risus.
                </p>
                <a
                        role="button"
                        class="btn btn-secondary"
                        href="/contact"
                >
                    Skontaktuj się z nami</a
                >
            </div>
        </div>
    </div>
</main>

<#include "footer.ftlh">

</body>
</html>
</html>