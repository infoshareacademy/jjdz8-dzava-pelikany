<!DOCTYPE html>
<html lang="en">
<#include "parts/head.ftlh">
<body id="page-top">
<!-- Navigation-->
<#include "parts/navbar-homepage.ftlh">
<!-- Masthead-->
<header class="masthead">
    <div class="container h-100">
        <div class="row h-100 align-items-center justify-content-center text-center">
            <div class="col-lg-10 align-self-end">
                <h1 class="text-uppercase text-white font-weight-bold">Edycja pokoju</h1>
                <hr class="divider my-2" />
                <p class="text-white-50 mb-4">Formularz pozwala zmienić dane pokoju.</p>
            </div>
            <p><input class="btn btn-primary" type ="button" id="myMenu" value="<-- Powrot"/></p>
            <form id="editForm" class="contact-from">
                <div class="row">
                    <input type="hidden" value="${editedRoom.getId()}" name="id">
                    <div class="form col-lg-6 col-sm-12">
                        <label for="roomLogin">Twoja nazwa pokoju:</label>
                        <input type="text" value="${editedRoom.getRoomLogin()}" name="roomLogin" id="roomLogin" required/>
                    </div>
                    <div class="form col-lg-6 col-sm-12">
                        <label for="adress">Adres:</label>
                        <input type="text" value="${editedRoom.getStreetAndNumber()}" name="streetAndNumber" id="streetAndNumber" required/>
                    </div>
                    <div class="form col-lg-6 col-sm-12">
                        <label for="city">Miasto:</label>
                        <input type="text" value="${editedRoom.getCity()}" name="city" id="city" required/>
                    </div>
                    <div class="form col-lg-6 col-sm-12">
                        <label for="area">Metraż:</label>
                        <input type="text" value="${editedRoom.getArea()}" name="area" id="area" required/>
                    </div>
                    <div class="form col-lg-6 col-sm-12">
                        <label for="price">Cena:</label>
                        <input type="text" value="${editedRoom.getPrice()}" name="price" id="price" required/>
                    </div>
                    <div class="form col-12">
                        <button class="btn btn-primary subedt">
                            Edytuj Pokój
                        </button>
                    </div>
                </div>
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
    $('.subedt').click(function editRoom() {
        $.ajax({url: '/owner-edit-room?editRoomId='+$(this).data('roomid'), method: "PUT", data:$("#editForm").serialize()})
            .then( function () {
                location.href="/owner-rooms";
            }).then( function () {
            return confirm('Pokoj zaktualizowany')
        }).catch(function (err) {
            console.log(err)
        })
    });
</script>
</body>
</html>