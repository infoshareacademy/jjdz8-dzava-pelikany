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
                <h1 class="text-uppercase text-white font-weight-bold">Dodaj nowy rachunek:</h1>
                <hr class="divider my-2" />
                <p class="text-white-50 mb-4"></p>
            </div>

            <p><input class="btn btn-primary" type ="button" id="myMenu" value="<-- Powrot"/></p>

            <div><p><#if msg??>${msg}<br /><br /><#else> </#if></p></div>
            <form action="/owner-add-bill" method="post" class="contact-from">
                <div class="divider my-2">
                    <div class="form-group mx-sm-3 mb-2">
                        <label for="name" class="sr-only">Adres</label>
                        <input type="text" class="form-control" id="StreetAndNumber" placeholder="Adres" name="StreetAndNumber" required>
                    </div>
                    <div class="form-group mx-sm-3 mb-2">
                        <label for="name" class="sr-only">Typ Opłaty</label>
                        <select name="Description" id="Description">
                            <option value="Energia">Energia</option>
                            <option value="Gaz">Gaz</option>
                            <option value="Woda">Woda</option>
                            <option value="Internet">Internet</option>
                            <option value="Telewizja">Telewizja</option>
                            <option value="Ogrzewanie">Ogrzewanie</option>
                            <option value="Inne">Inne</option>
                        </select>
                    </div>
                    <div class="form-group mx-sm-3 mb-2">
                        <label for="name" class="sr-only">Wysokość rachunku</label>
                        <input type="text" class="form-control" id="amount" placeholder="1,01zł" name="Amount" required>
                    </div>
                    <div class="form-group mx-sm-3 mb-2">
                        <label for="name" class="sr-only">Termin spłaty</label>
                        <input type="date" class="form-control" id="date" name="date" required>
                    </div>
                    <div class="form col-12">
                        <button class="btn btn-primary" type="submit">
                            Dodaj rachunek!
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