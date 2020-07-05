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

    <form id="rentForm" class="contact-from">
        <div class="row">
            <input type="hidden" value="${rentedRoom.getId()}" name="id">
            <div class="form col-lg-6 col-sm-12">
                <label for="roomTerm">Termin:</label>
                <input type="text" name="roomTerm" id="roomTerm" value="${rentedRoom.getRegistrationTerm()}" required/>
            </div>
            <div class="form col-lg-6 col-sm-12">
                <label for="roomTenant">Osoba:</label>
                <select name="tenant" id="tenant">
                    <#list tenants as tenant>
                        <option value="${tenant.getLogin()}">${tenant.getName()}  ${tenant.getSurname()}</option>
                    </#list>
                </select>
            </div>
            <div class="form col-12">
                <button class="btn btn-primary rnt">
                    Wynajmij Pokój
                </button>
            </div>
        </div>
    </form>

</main>

<#include "footer.ftlh">

<script>
    $('.rnt').click(function rentRoom() {
        $.ajax({url: '/owner-rent-room?rentRoomId='+$(this).data('roomid'), method: "PUT", data:$("#rentForm").serialize()})
            .then( function () {
                location.href="/owner-rooms";
            }).then( function () {
            alert("Pokoj zostal wynajety");
        }).catch(function (err) {
                console.log(err)
            })
    });
</script>
</body>
</html>
</html>