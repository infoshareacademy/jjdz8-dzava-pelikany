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
                <h1 class="text-uppercase text-white font-weight-bold">Logowanie</h1>
                <hr class="divider my-4" />
                <p class="text-white-50 mb-4">Zaloguj się już dziś i miej wszystko w jednym miejscu!</p>
            </div>
            <form action="/owner-login" method="post" class="contact-from">
                <div class="divider my-2">
                    <div class="form-group mx-sm-3 mb-2">
                        <label for="name" class="sr-only">Login</label>
                        <input type="text" class="form-control" id="login" placeholder="Login" name="login" required>
                    </div>
                    <div class="form-group mx-sm-3 mb-2">
                        <label for="inputPassword2" class="sr-only">Password</label>
                        <input type="password" class="form-control" id="inputPassword2" placeholder="Hasło" name="password" required>
                    </div>
                    <div class="form col-12">
                        <button class="btn btn-primary" type="submit">
                            Zaloguj
                        </button>
                    </div>
                </div>
            </form>
            <#include "parts/signin-google-button.ftlh">
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