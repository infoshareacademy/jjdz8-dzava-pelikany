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
                <h1 class="text-uppercase text-white font-weight-bold">Szukaj pokoju</h1>
                <hr class="divider my-2" />
                <p class="text-white-50 mb-4">Wybierz kryteria:</p>
                <p><input class="btn btn-primary" type ="button" id="myMenu" value="<-- Powrot"/></p>
            </div>
            <p><#if msg??>${msg}<#else> </#if></p>
            <form action="/tenant-search-room" method="post" class="form-inline">
                <div class="divider my-2">${'\n'}
                    <div class="form-group mx-sm-3 mb-2">
                        <label for="name" class="sr-only">Cena minimalna</label>
                        <input type="number" class="form-control" id="price-min" placeholder="Cena Minimalna" name="price-min" value="0">
                    </div>
                    <div class="form-group mx-sm-3 mb-2">${'\n'}
                        <label for="name" class="sr-only">Cena maksymalna</label>
                        <input type="number" class="form-control" id="price-max" placeholder="Cena maksymalna" name="price-max" value="0">
                    </div>
                    <div class="form-group mx-sm-3 mb-2">${'\n'}
                        <label for="staticEmail2" class="sr-only">Miasto</label>
                        <input type="text" class="form-control" id="city" placeholder="Miasto" name="city" required>
                    </div>
                    <div class="form col-12">${'\n'}
                        <button class="btn btn-primary" type="submit">
                            Szukaj
                        </button>
                        <p>
                            <#if msg??><#list msg as msg>
                        <h5>${msg}</h5>
                        </#list></#if>
                        <#if room??><#list room as room>
                            <ul>
                                <li><h5>        ${room}
                                    </h5></li>
                            </ul>
                        </#list><#else> </#if>
                        </p>
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