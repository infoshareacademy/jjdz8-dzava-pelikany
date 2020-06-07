<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="description" content="Strona mojej firmy"/>
    <title>DzavaApp - Dodaj pokój.</title>
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
        <h1 class="display-3">Dodaj pokój</h1>
    </div>
</header>

<main role="main">

    <p><input class="button" type ="button" id="myMenu" value="<-- Powrót"/></p>

    <form id="editForm" class="contact-from">
        <div class="row">
            <input type="hidden" value="${editedRoom.getId()}" name="id">
            <div class="form col-lg-6 col-sm-12">
                <label for="name">Twoja nazwa pokoju:</label>
                <input type="text" value="${editedRoom.getRoomLogin()}" name="roomLogin" id="roomLogin" required/>
            </div>
            <div class="form col-lg-6 col-sm-12">
                <label for="surname">Adres:</label>
                <input type="text" value="${editedRoom.getStreetAndNumber()}" name="streetAndNumber" id="streetAndNumber" required/>
            </div>
            <div class="form col-lg-6 col-sm-12">
                <label for="email">Miasto:</label>
                <input type="text" value="${editedRoom.getCity()}" name="city" id="city" required/>
            </div>
            <div class="form col-lg-6 col-sm-12">
                <label for="login">Metraż:</label>
                <input type="text" value="${editedRoom.getArea()}" name="area" id="area" required/>
            </div>
            <div class="form col-12">
                <button class="btn btn-primary subedt">
                    Edytuj Pokój
                </button>
            </div>
        </div>
    </form>

</main>

<#include "footer.ftlh">


</body>
</html>
</html>