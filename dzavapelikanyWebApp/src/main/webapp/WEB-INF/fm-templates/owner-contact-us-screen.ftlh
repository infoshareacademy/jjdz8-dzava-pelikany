<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="description" content="Strona mojej firmy"/>
    <title>DzavaApp - Kontakt.</title>
    <link rel="stylesheet" href="../../styles.css"/>
    <link href="../../form.css" rel="stylesheet"/>
    <link href='https://fonts.googleapis.com/css?family=Atomic Age' rel='stylesheet'>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand logo" href="/owner-menu"><h2>DzavaApp!</h2></a>
    <button
            class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navigation"
    >
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navigation">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/owner-menu">Menu</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/owner-contact-us">Kontakt</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/logout">Wyloguj</a>
            </li>
        </ul>
    </div>
</nav>

<header class="jumbotron">
    <div class="container my-header">
        <h1 class="display-3">Skontaktuj się z nami</h1>
        <p>
            Mozesz to zrobic bezpośrednio albo skorzystaj z naszego formularza
            kontaktowego
        </p>
    </div>
</header>

<main role="main">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <h3 class="display-5">Formularz kontaktowy</h3>
            </div>
        </div>

        <form action="action" method="post" class="contact-from">
            <div class="row">
                <div class="form col-lg-6 col-sm-12">
                    <label for="name">Imie:</label>
                    <input type="text" name="name" id="name" required />
                </div>
                <div class="form col-lg-6 col-sm-12">
                    <label for="email">Email:</label>
                    <input type="email" name="email" id="email" required />
                </div>
                <div class="form col-12">
                    <label for="description">Wiadomość:</label>
                    <textarea name="description"></textarea>
                </div>
                <div class="form col-12">
                    <button class="btn btn-primary" type="submit">
                        Wyślij wiadomość
                    </button>
                </div>
            </div>
        </form>

        <div class="row">
            <div class="col-lg-4 col-sm-12">
                <p>
                    Donec id elit non mi porta gravida at eget metus. Fusce dapibus,
                    tellus ac cursus commodo, tortor mauris condimentum nibh, ut
                    fermentum massa justo sit amet risus.
                </p>
                <a role="button" class="btn btn-secondary" href="tel:111222333">
                    Zadzwoń
                </a>
            </div>
            <div class="col-lg-4 col-sm-12">
                <p>
                    Donec id elit non mi porta gravida at eget metus. Fusce dapibus,
                    tellus ac cursus commodo, tortor mauris condimentum nibh, ut
                    fermentum massa justo sit amet risus.
                </p>
                <a
                        role="button"
                        class="btn btn-secondary"
                        href="mailto:some@email.com"
                >
                    Napisz Email
                </a>
            </div>
            <div class="col-lg-4 col-sm-12">
                <p>
                    Donec id elit non mi porta gravida at eget metus. Fusce dapibus,
                    tellus ac cursus commodo, tortor mauris condimentum nibh, ut
                    fermentum massa justo sit amet risus.
                </p>
                <a
                        role="button"
                        class="btn btn-secondary"
                        href="https://facebook.com/company"
                >
                    Facebook</a
                >
            </div>
        </div>
    </div>


</main>

<#include "footer.ftlh">

</body>
</html>
