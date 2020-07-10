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
                <h1 class="text-uppercase text-white font-weight-bold">Wolne pokoje</h1>
                <hr class="divider my-2" />
                <p class="text-white-50 mb-4">Lista twoich pokoi:</p>
            </div>
            <p><input class="btn btn-primary" type ="button" id="myMenu" value="<-- Powrot"/></p>

         <form role="form" id="rentForm">
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

             <div class="col-lg-10 align-self-end">
                 <h1 class="text-uppercase text-white font-weight-bold">wynajęte pokoje</h1>
                 <hr class="divider my-2" />
                 <p class="text-white-50 mb-4">Lista twoich pokoi:</p>
             </div>
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
         </form>
        </div>
    </div>
</header>

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