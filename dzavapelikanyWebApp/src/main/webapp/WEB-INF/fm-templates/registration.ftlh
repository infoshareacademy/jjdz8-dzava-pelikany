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
                <h1 class="text-uppercase text-white font-weight-bold">Rejestracja</h1>
                <hr class="divider my-2" />
                <p class="text-white-50 mb-4">Zarejestruj się już dziś i miej wszystko w jednym miejscu!</p>
            </div>
            <p><#if msg??>${msg}<#else> </#if></p>
            <div>
            <p><input class="btn btn-primary mb-2" type ="button" id="tenant" value="Zarejestruj jako wynajmujący"/></p>
            </div>
            <div>
            <p><input class="btn btn-primary mb-2" type ="button" id="owner" value="Zarejestruj jako właściciel"/></p>
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
