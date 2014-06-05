<%-- 
    Document   : registro
    Created on : 25/05/2014, 12:40:57 PM
    Author     : marvin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>gol | Registro</title>
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
                <div class="col-md-12">
                    <div id='calendar'></div>
                </div>
            </div>
        </div>

        <!-- Login -->
        <div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">Ingreso</h4>
                    </div>
                    <form role="form" method="POST" >
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="email">Email address</label>
                                <input type="email" class="form-control" id="email" placeholder="Correo Electronico" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" id="password" placeholder="Contraseña" required>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-primary">Ingresar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <!-- Registro -->
        <div class="modal fade" id="reg" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">Ingreso</h4>
                    </div>
                    <form role="form" method="POST" >
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" id="email" placeholder="Correo Electronico" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" id="password" placeholder="Contraseña" required>
                            </div>
                            <div class="form-group">
                                <label for="password_confirmation">Confirmación</label>
                                <input type="password" class="form-control" id="password" placeholder="Confirmacion de Contraseña" required>
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
                            <button type="submit" class="btn btn-primary">Registrarse</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <script src="js/jquery-1.11.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>