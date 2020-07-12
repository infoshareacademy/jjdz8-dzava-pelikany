<!DOCTYPE html>
<html lang="en">
<#include "parts/head.ftlh">
<body id="page-top">
<!-- Navigation-->
<#include "parts/owner-navbar.ftlh">
<!-- Masthead-->
<header class="masthead">
    <div class="container h-100">
        <div class="row h-100 align-items-center justify-content-center text-center">
            <div class="col-lg-10 align-self-end">
                <h1 class="text-uppercase text-white font-weight-bold">Dodaj pokój</h1>
                <hr class="divider my-2" />
                <p class="text-white-50 mb-4">Formularz pozwala zmienić dane pokoju.</p>
            </div>
            <p><input class="btn btn-primary" type ="button" id="myMenu" value="<-- Powrot"/></p>
        </div>
    </div>
</header>
<main role="main">
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

<!-- Contact-->
<#include "parts/contact.ftlh">
<!-- Footer-->
<#include "parts/footer.ftlh">
<!-- Bootstrap core JS-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"></script>
<!-- Third party plugin JS-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/jquery.magnific-popup.min.js"></script>
<!-- Core theme JS-->
<script src="../../js/scripts.js"></script>
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