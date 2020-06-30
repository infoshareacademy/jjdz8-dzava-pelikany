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
                <h1 class="text-uppercase text-white font-weight-bold">Dodaj pokój:</h1>
                <hr class="divider my-2" />
                <p class="text-white-50 mb-4">Wypełnij wszystkie pola aby móc dodać pokój!</p>
            </div>
            <p><#if msg??>${msg}<#else> </#if></p>
            <p><input class="btn btn-primary" type ="button" id="myMenu" value="<-- Powrot"/></p>
            <form action="/owner-add-room" method="post" class="contact-from">
                <div class="divider my-2">
                    <div class="form-group mx-sm-3 mb-2">
                        <label for="name" class="sr-only">Nazwa pokoju</label>
                        <input type="text" class="form-control" id="roomLogin" placeholder="Nazwa pokoju" name="roomLogin" required>
                    </div>
                    <div class="form-group mx-sm-3 mb-2">
                        <label for="name" class="sr-only">Adres</label>
                        <input type="text" class="form-control" id="StreetAndNumber" placeholder="Adres" name="StreetAndNumber" required>
                    </div>
                    <div class="form-group mx-sm-3 mb-2">
                        <label for="name" class="sr-only">Miasto</label>
                        <input type="text" class="form-control" id="city" placeholder="Miasto" name="city" required>
                    </div>
                    <div class="form-group mx-sm-3 mb-2">
                        <label for="name" class="sr-only">Metraż</label>
                        <input type="text" class="form-control" id="area" placeholder="Metraż" name="area" required>
                    </div>
                    <div class="form col-12">
                        <button class="btn btn-primary" type="submit">
                            Dodaj pokój!
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