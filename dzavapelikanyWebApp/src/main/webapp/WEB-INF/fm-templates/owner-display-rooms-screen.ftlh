<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="description" content="Strona mojej firmy"/>
    <title>DzavaApp - Menu Właścicela.</title>
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
        <h1 class="display-3">Lista pokoi</h1>
    </div>
</header>



<main role="main" id="rentForm">

    <p><input class="button" type ="button" id="myMenu" value="<-- Powrót"/></p>

    <h1>Wolne pokoje</h1>
    <table width="100%">
    <#list freerooms as room>
        <tr>
            <th>${room.getRoomLogin()}</th>
            <th> <td><button data-roomid="${room.getId()}" class="mvrnt" id="mvrnt" >Wynajmij</button></td></th>
            <th> <td><button data-roomid="${room.getId()}" class="edt" id="edt">Edytuj</button></td></th>
            <th> <td><button data-roomid="${room.getRoomLogin()}" class="rmv" >Usuń</button></td></th>
        </tr>
        <tr>
            <td>Miasto: ${room.getCity()}</td>
        </tr>
        <tr>
            <td>Ulica: ${room.getStreetAndNumber()}</td>
        </tr>
        <tr>
            <td>Metraz: ${room.getArea()}</td>
        </tr>
        <tr>
            <td>Cena: ${room.getPrice()}</td>
        </tr>
        </#list>
        </table>

    <h1>Wynajęte pokoje</h1>
    <table width="100%">
        <#list rentedrooms as room>
            <tr>
                <th>${room.getRoomLogin()}</th>
                <th> <td><button data-roomid="${room.getId()}" class="rvrnt" id="rvrnt">Anuluj</button></td></th>
            </tr>
            <tr>
                <td>Miasto: ${room.getCity()}</td>
            </tr>
            <tr>
                <td>Ulica: ${room.getStreetAndNumber()}</td>
            </tr>
            <tr>
                <td>Metraz: ${room.getArea()}</td>
            </tr>
            <tr>
                <td>Cena: ${room.getPrice()}</td>
            </tr>
            <tr>
                <td>Termin: ${room.getRegistrationTerm()}</td>
            </tr>
            <tr>
                <td>Osoba wynajmujaca: ${room.getTenantLogin()}</td>
            </tr>
        </#list>
    </table>

</main>


<#include "footer.ftlh">
<script>
    $('.rmv').click(function removeRoom() {
        $.ajax({url: '/owner-rooms?roomid='+$(this).data('roomid'), method: "DELETE"})
            .then( function () {
                return confirm('Pokoj zostal usuniety')
            }).then( function () {
            location.reload();
        })
            .catch(function (err) {
                console.log(err)
            })
    });
</script>
<script>
    $('.mvrnt').click(function goToRoomRent() {

        location.href="/owner-rent-room?rentRoomId="+$(this).data('roomid');

    });
</script>
<script>
    $('.rvrnt').click(function rentRoom() {
        $.ajax({url: '/owner-rooms?rentRoomId='+$(this).data('roomid'), method: "PUT", data:$("#rentForm").serialize()})
            .then( function () {
                return confirm('Lokator wyeksmitowany')
            }).then( function () {
                location.reload()
            })
            .catch(function (err) {
                console.log(err)
            })
    });
</script>
<script>
    $('.edt').click(function goToRoomEdit() {

        location.href="/owner-edit-room?editRoomId="+$(this).data('roomid');

    });
</script>
</body>
</html>