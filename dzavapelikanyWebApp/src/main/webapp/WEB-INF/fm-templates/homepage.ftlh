
<!DOCTYPE html>
<html lang="en">
  <#include "parts/head.ftlh">
    <body id="page-top">
        <!-- Navigation-->
        <#include "parts/navbar-homepage.ftlh">
        <!-- Masthead-->
        <#include "parts/header.ftlh">
        <!-- About-->
        <section class="page-section bg-primary" id="logowanie">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-8 text-center">
                        <h2 class="text-white mt-0">Mamy wszystko, czego potrzebujesz!</h2>
                        <hr class="divider light my-4" />
                        <p class="text-white-50 mb-4">Zaloguj się już dziś i miej wszystko w jednym miejscu!</p>
                        <a class="btn btn-light btn-xl js-scroll-trigger" href="/login">Logowanie</a>
                    </div>
                </div>
            </div>
        </section>
        <!-- Services-->
        <section class="page-section" id="about">
            <div class="container">
                <h2 class="text-center mt-0">Oferujemy:</h2>
                <hr class="divider my-4" />
                <div class="row">
                    <div class="col-lg-3 col-md-6 text-center">
                        <div class="mt-5">
                            <i class="fas fa-4x fa-gem text-primary mb-4"></i>
                            <h3 class="h4 mb-2">Najlepszą obsługę</h3>
                            <p class="text-muted mb-0">Jesteśmy zawsze do Waszej dyspozycji!</p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 text-center">
                        <div class="mt-5">
                            <i class="fas fa-4x fa-laptop-code text-primary mb-4"></i>
                            <h3 class="h4 mb-2">Łatwa komunikacja</h3>
                            <p class="text-muted mb-0">Komunikacja pomiędzy właścicielami a lokatorami!</p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 text-center">
                        <div class="mt-5">
                            <i class="fas fa-4x fa-globe text-primary mb-4"></i>
                            <h3 class="h4 mb-2">Bogata wyszukiwarka</h3>
                            <p class="text-muted mb-0">Możliwość wyszukania pokoju w każdym miejscu w Polsce!</p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 text-center">
                        <div class="mt-5">
                            <i class="fas fa-4x fa-heart text-primary mb-4"></i>
                            <h3 class="h4 mb-2">Przyjemne zarządzanie</h3>
                            <p class="text-muted mb-0">Łatwe i przyjemne zarządzanie nieruchomościami!</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Portfolio-->
        <div id="portfolio">
            <div class="container-fluid p-0">
                <div class="row no-gutters">
                    <div class="col-lg-4 col-sm-6">
                        <a class="portfolio-box" href="../../assets/img/portfolio/fullsize/1.jpg">
                            <img class="img-fluid" src="../../assets/img/portfolio/thumbnails/1.jpg" alt="" />
                            <div class="portfolio-box-caption">
                                <div class="project-category text-white-50">booking.com</div>
                                <div class="project-name">Gdańsk</div>
                            </div>
                        </a>
                    </div>
                    <div class="col-lg-4 col-sm-6">
                        <a class="portfolio-box" href="../../assets/img/portfolio/fullsize/2.jpg">
                            <img class="img-fluid" src="../../assets/img/portfolio/thumbnails/2.jpg" alt="" />
                            <div class="portfolio-box-caption">
                                <div class="project-category text-white-50">booking.com</div>
                                <div class="project-name">Gdynia</div>
                            </div>
                        </a>
                    </div>
                    <div class="col-lg-4 col-sm-6">
                        <a class="portfolio-box" href="../../assets/img/portfolio/fullsize/3.jpg">
                            <img class="img-fluid" src="../../assets/img/portfolio/thumbnails/3.jpg" alt="" />
                            <div class="portfolio-box-caption">
                                <div class="project-category text-white-50">booking.com</div>
                                <div class="project-name">Sopot</div>
                            </div>
                        </a>
                    </div>
                    <div class="col-lg-4 col-sm-6">
                        <a class="portfolio-box" href="../../assets/img/portfolio/fullsize/4.jpg">
                            <img class="img-fluid" src="../../assets/img/portfolio/thumbnails/4.jpg" alt="" />
                            <div class="portfolio-box-caption">
                                <div class="project-category text-white-50">booking.com</div>
                                <div class="project-name">Warszawa</div>
                            </div>
                        </a>
                    </div>
                    <div class="col-lg-4 col-sm-6">
                        <a class="portfolio-box" href="../../assets/img/portfolio/fullsize/5.jpg">
                            <img class="img-fluid" src="../../assets/img/portfolio/thumbnails/5.jpg" alt="" />
                            <div class="portfolio-box-caption">
                                <div class="project-category text-white-50">booking.com</div>
                                <div class="project-name">Bydgoszcz</div>
                            </div>
                        </a>
                    </div>
                    <div class="col-lg-4 col-sm-6">
                        <a class="portfolio-box" href="../../assets/img/portfolio/fullsize/6.jpg">
                            <img class="img-fluid" src="../../assets/img/portfolio/thumbnails/6.jpg" alt="" />
                            <div class="portfolio-box-caption p-3">
                                <div class="project-category text-white-50">booking.com</div>
                                <div class="project-name">Wrocław</div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Call to action-->
        <section class="page-section bg-dark text-white">
            <div class="container text-center">
                <h2 class="mb-4">Załóż darmowe konto już dziś!</h2>
                <a class="btn btn-light btn-xl" href="/registration" id=>REJESTRACJA!</a>
            </div>
        </section>
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
