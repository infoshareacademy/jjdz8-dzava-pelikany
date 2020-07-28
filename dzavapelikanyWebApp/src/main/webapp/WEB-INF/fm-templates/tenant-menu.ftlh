<!DOCTYPE html>
<html lang="en">
<#include "parts/head.ftlh">
<body id="page-top">
<!-- Navigation-->
<#include "parts/tenant-navbar.ftlh">
<!-- Masthead-->
<header class="masthead">
    <div class="container h-75">
        <div class="row h-100 align-items-center justify-content-center text-center">
            <div class="col-lg-10 align-self-end">
                <h1 class="text-uppercase text-white font-weight-bold">Witaj!</h1>
                <hr class="divider my-4" />
                <p class="text-white-50 mb-4">Teraz masz pełny dostęp do naszej aplikacji!</p>
                <p class="text-white-50 mb-4">Wybierz z menu co chcesz zrobić!</p>
                <p><input class="btn btn-primary mb-2" type ="button" id="myRoom" value="Twój pokój"/></p>
                <p><input class="btn btn-primary mb-2" type ="button" id="searchRoom" value="Szukaj pokoju"/></p>
                <p><input class="btn btn-primary mb-2" type ="button" id="editMyData" value="Edytuj dane"/></p>
            </div>
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