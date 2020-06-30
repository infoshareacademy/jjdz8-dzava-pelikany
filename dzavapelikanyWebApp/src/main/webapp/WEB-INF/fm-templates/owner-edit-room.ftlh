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
            <form action="/owner-edit-room" method="post" class="contact-from">
                <div class="divider my-2">
                    <input type="hidden" value="${editedRoom.getId()}" name="id">
                    <div class="form-group mx-sm-3 mb-2">
                        <label for="name" class="sr-only">Nazwa pokoju</label>
                        <input type="text" value="${editedRoom.getRoomLogin()}" class="form-control" id="roomLogin" placeholder="Nazwa pokoju" name="roomLogin" required>
                    </div>
                    <div class="form-group mx-sm-3 mb-2">
                        <label for="name" class="sr-only">Adres</label>
                        <input type="text" value="${editedRoom.getStreetAndNumber()}" class="form-control" id="StreetAndNumber" placeholder="Adres" name="StreetAndNumber" required>
                    </div>
                    <div class="form-group mx-sm-3 mb-2">
                        <label for="name" class="sr-only">Miasto</label>
                        <input type="text" value="${editedRoom.getCity()}" class="form-control" id="city" placeholder="Miasto" name="city" required>
                    </div>
                    <div class="form-group mx-sm-3 mb-2">
                        <label for="name" class="sr-only">Metraż</label>
                        <input type="text" value="${editedRoom.getArea()}" class="form-control" id="area" placeholder="Metraż" name="area" required>
                    </div>
                    <div class="form col-12">
                        <button class="btn btn-primary" type="submit">
                            Edytuj pokój
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
</body>
</html>