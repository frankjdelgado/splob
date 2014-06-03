<%@page import="model.TUsuario"%>
<% TUsuario user = (TUsuario) session.getAttribute("usuario");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>gol | Pérfil</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link href='http://fonts.googleapis.com/css?family=Swanky+and+Moo+Moo' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Noto+Sans:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="fonts/style.css">
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

                            <!-- Condicionar -->
                            <!-- <li><a data-toggle="modal" data-target="#reg">Registrarse</a></li>
                            <li><a data-toggle="modal" data-target="#login">Ingresar</a></li> -->

                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><%=user.getAlias()%><b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="ActualizarUsuario">Editar Perfil</a></li>
                                    <li><a href="CerrarSesion">Cerrar sesión</a></li>
                                </ul>
                            </li>
                            <!-- Condicionar -->

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
                                <li><a href="calendar.html">Calendario</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </header>


        <div class="container vs box-wrapper">
            <div class="row">
                <div class="col-md-7">
                    <% if (request.getAttribute("myerror") != null) {%>
                    <div class="alert alert-danger alert-dismissable ">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <!--<strong>Warning!</strong> Al parecer hubo un error con tu solicitud =(-->
                        <%=request.getAttribute("myerror")%>
                    </div>
                    <%}%>
                    <% if (request.getAttribute("exito") != null) {%>
                    <div class="alert alert-success alert-dismissable ">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <strong>Cambios realizada satisfactoriamente</strong>.
                    </div>
                    <%}%>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">

                    <div class="panel-title">
                        <h4>Datos de Pérfil</h4>
                    </div>

                    <br>
                    <form role="form" method="POST" action="ActualizarUsuario">

                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" id="email" placeholder="Correo Electronico" required name="email" value="<%=user.getEmail()%>">
                        </div>

                        <div class="form-group">
                            <label for="username">Apodo</label>
                            <input type="text" class="form-control" id="username" placeholder="Nombre de usuario" required name="username" value="<%=user.getAlias()%>">
                        </div>

                        <div class="form-group">
                            <div>
                                <label for="equipo">Equipos favoritos</label>
                            </div>

                            <div class="col-md-3">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Brasil
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Argentina
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Colombia
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Uruguay
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Belgica
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Alemania
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        España
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Suiza
                                    </label>
                                </div>
                            </div>

                            <div class="col-md-3">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Algeria
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Camerun
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Costa de Marfil
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Ghana
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Nigeria
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Chile
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Ecuador
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Australia
                                    </label>
                                </div>
                            </div>

                            <div class="col-md-3">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Japon
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Iran
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Korea del Sur
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Costa Rica
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Honduras
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        México
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Estados Unidos
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Boznia y Herzegovina
                                    </label>
                                </div>
                            </div>

                            <div class="col-md-3">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Croacia
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Inglaterra
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Francia
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Grecia
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Italia
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Holanda
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Portugal
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">
                                        Rusia
                                    </label>
                                </div>
                            </div>

                        </div>

                        <div class="text-right">
                            <button type="submit" class="btn btn-primary">Guardar Cambios</button>
                        </div>

                    </form>
                    <br>
                    <div class="panel-title">
                        <h4>Cambiar Contraseña</h4>
                    </div>
                    <br>
                    <form action="ActualizarUsuario" role="form" method="POST">
                        <div class="form-group">
                            <label for="pwd">Nueva Contraseña</label>
                            <input type="password" class="form-control" id="pwd" placeholder="Contraseña" required name="password">
                        </div>

                        <div class="form-group">
                            <label for="pwd">Confirmar Contraseña</label>
                            <input type="password" class="form-control" id="pwd_c" placeholder="Confirmar Contraseña" required name="password2">
                        </div>

                        <div class="text-right">
                            <button type="submit" class="btn btn-primary">Actualizar</button>
                        </div>


                    </form>

                </div>
            </div>
        </div>

        <a href="#" class="icon-arrow-up back-to-top"></a>

        <script src="js/jquery-1.11.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>

    </body>

</html>