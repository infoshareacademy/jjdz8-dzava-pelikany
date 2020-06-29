<!DOCTYPE html>
<html lang="en">
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
        <h1 class="display-3">Wyszukaj pokój</h1>
    </div>
</header>

<main role="main">
    <main role="main">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h3 class="display-5">Szukaj Pokoju</h3>
                </div>
            </div>

            <form class="form-inline" method="post" action="/tenant-search-room">
                <div class="form-group mb-2">Cena Minimalna: ${'\n'}
                    <label for="staticEmail2" class="sr-only">Cena Minimalna</label>
                    <input type="number" class="form-control" id="login"  name="price-min" value="0">
                </div> ${'\n'}
                <div class="form-group mx-sm-3 mb-2">Cena Maksymalna: ${'\n'}
                    <label for="inputPassword2" class="sr-only">Cena Maksymalna</label>
                    <input type="number" class="form-control" id="login"  name="price-max" value="0">
                </div> ${'\n'}
                <div class="form-group mb-2">Miasto: ${'\n'}
                    <label for="staticEmail2" class="sr-only">Miasto</label>
                    <input type="text" class="form-control" id="login" name="city" placeholder="Miasto" required>
                </div>${'\n'}
                <div>
                <button type="submit" class="btn btn-primary mb-2">Szukaj</button>
                </div>
            </form>
        </div>

    <p>
        <#if msg??><#list msg as msg>
            <h5>${msg}</h5>
        </#list></#if>
         <#if room??><#list room as room>
        <ul>
            <li><h5>        ${room}
                </h5></li>
        </ul>
        </#list><#else> </#if>
    </p>

</main>
</main>

<#include "parts/footer.ftlh">

</body>
</html>