<!DOCTYPE html>
<html lang="en">
<#include "parts/head.ftlh">
<body id="page-top">
<!-- Navigation-->
<#include "parts/tenant-navbar.ftlh">
<!-- Masthead-->
<header class="masthead">
    <div class="container h-100">
        <div class="row h-100 align-items-center justify-content-center text-center">
            <div class="col-lg-10 align-self-end">
                <h1 class="text-uppercase text-white font-weight-bold">Szukaj po adresie:</h1>
                <hr class="divider my-2" />
                <p class="text-white-50 mb-4"></p>
            </div>
            <p><input class="btn btn-primary" type ="button" id="myMenuTenant" value="<-- Powrot"/></p>
            <div>

            <p><#if msg??><#list msg as msg>
                    <ul><li>${msg}</li></ul></#list></#if></p>
            <p><#if bill??><#list bill as bill>
                <ul>
                <li> <h5> ${bill}</h5></li>
            </ul>
            </#list></#if></p>
            </div>
            <form action="/tenant-view-bills" method="post" class="contact-from">
                <div class="divider my-2">
                    <div class="form-group mx-sm-3 mb-2">
                        <label for="name" class="sr-only">Adres</label>
                        <input type="text" class="form-control" id="address" placeholder="Adres" name="address" required>
                    </div>
                    <div class="form col-12">
                        <button class="btn btn-primary" type="submit">
                            Szukaj
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