<#import "parts/macros/basic.ftlh" as basic/>
<@basic.includeContent scriptsSrc="" currentPosition="home" modal="" role = "GUEST">
    <header class="jumbotron">
        <div class="container">
            <h1 class="display-3">Aplikacja DzavaApp</h1>
        </div>
    </header>

    <main role="main">
        <div class="container">
            <p><#if msg??>${msg}<#else> </#if></p>
            <div class="row">
                <div class="col-lg-4 col-sm-12">
                    <p>
                        Donec id elit non mi porta gravida at eget metus. Fusce dapibus,
                        tellus ac cursus commodo, tortor mauris condimentum nibh, ut
                        fermentum massa justo sit amet risus.
                    </p>
                    <a role="button" class="btn btn-secondary" href="/registration">
                        Zarejestruj się
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
                            href="/login"
                    >
                        Zaloguj się
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
                            href="/contact"
                    >
                        Skontaktuj się z nami</a
                    >
                </div>
            </div>
        </div>
    </main>

<#include "parts/footer.ftlh"/>
</@basic.includeContent>