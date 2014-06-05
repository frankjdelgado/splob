<%-- 
    Document   : recuperar
    Created on : 02/06/2014, 03:10:34 AM
    Author     : marvin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>gol | Recuperar Cuenta</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link href='http://fonts.googleapis.com/css?family=Swanky+and+Moo+Moo' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Noto+Sans:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="fonts/style.css">
        <link rel="stylesheet" href="css/fullcalendar.css">
        <link rel="stylesheet" href="css/fullcalendar.print.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>

        <header>
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <div class="logo">
                            <h1><a href="Landing">gol</a></h1>
                        </div>
                        <div class="title">
                            <h3><a href="http://www.fifa.com/worldcup/" target="_blank">World Cup 2014</a></h3>
                        </div>
                    </div>
                    <div class="col-md-5">
                        <form action="" class="searchbox">
                            <input type="text" class="searchbox" placeholder="Busqueda" required>
                        </form>
                    </div>
                    <div class="col-md-3">
                        <ul class="sign pull-right">
                            <li><a data-toggle="modal" data-target="#reg">Registrarse</a></li>
                            <li><a data-toggle="modal" data-target="#login">Ingresar</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-1 border light-orange"></div>
                    <div class="col-md-2 border light-green"></div>
                    <div class="col-md-1 border dark-blue"></div>
                    <div class="col-md-2 border dark-orange"></div>
                    <div class="col-md-2 border darker-blue"></div>
                    <div class="col-md-1 border dark-green"></div>
                    <div class="col-md-2 border light-yellow"></div>
                    <div class="col-md-1 border dark-orange"></div>
                </div>
            </div>

            <div class="submenu">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <ul>
                                <li><a href="Calendario">Calendario</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <div class="container vs  box-wrapper">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">

                    <div class="evento">
                        <form action="Recuperacion">
                            <div class="form-group">
                                <label for="email">Correo electrónico</label>
                                <input type="email" class="form-control" name="email" placeholder="ejemplo@hotmail.com" required>
                            </div>
                            <div class="text-right">
                                <button type="submit" class="btn btn-primary">Enviar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Login -->
        <!-- Login -->
        <div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">Ingreso</h4>
                    </div>
                    <form role="form" method="POST" action="IngresarUusario">
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="email">Email address</label>
                                <input type="email" class="form-control" name="email" placeholder="Correo Electronico" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" name="password" placeholder="Contraseña" required>
                            </div>
                            <div class="text-right">
                                <a href="Recuperacion">Recuperar cuenta</a>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-primary" id="loginSubmit">Ingresar</button>
                        </div>
                    </form>

                    <div class="fb-login-button" data-max-rows="1" data-size="large" data-show-faces="false" data-auto-logout-link="true"></div>

                </div>
            </div>
        </div>



        <!-- Registro -->
        <div class="modal fade" id="reg" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">Registro</h4>
                    </div>

                    <form role="form" method="POST" id="regForm" action="RegistrarUsuario">
                        <div class="modal-body">

                            <div class="text-center">
                                <button class="btn btn-lg btn-facebook ">
                                    <span class="icon-facebook"></span>
                                    Registrate con Facebook
                                </button>
                            </div>
                            <hr><br>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" name="email" placeholder="Correo Electronico" required>
                            </div>
                            <div class="form-group">
                                <label for="username">Apodo</label>
                                <input type="text" class="form-control" name="username" placeholder="Nombre de usuario" required >
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" name="password" placeholder="Contraseña" required>
                            </div>
                            <div class="form-group">
                                <label for="password_confirmation">Confirmación</label>
                                <input type="password" class="form-control" name="password2" placeholder="Confirmacion de Contraseña" required>
                            </div>
                            <div class="form-group">
                                <label for="equipo">Equipo favorito</label>
                                <select class="form-control" name="equipo" id="equipo"  required>
                                    <option selected disabled>Seleccione</option>
                                    <option value="1">Equipo 1</option>
                                    <option value="2">Equipo 2</option>
                                    <option value="3">Equipo 3</option>
                                    <option value="4">Equipo 4</option>
                                </select>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                            <!--<a href="registro.html" class="btn btn-primary">Continuar</a>-->
                            <button type="submit" class="btn btn-primary" id="regSubmit">Continuar</button> 
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <script src="js/jquery-1.11.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/fullcalendar.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>