<%-- 
    Document   : administrareventos
    Created on : 03/06/2014, 12:06:28 PM
    Author     : marvin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title>gol | Eventos</title>
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
					<h1><a href="landing.html">gol</a></h1>
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

					<li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Username <b class="caret"></b></a>
			          <ul class="dropdown-menu">
			            <li><a href="#">Editar Perfil</a></li>
			          </ul>
			        </li>

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
					<ul class="user-options">
						<li><a href="calendar.html">Calendario</a></li>
						<li><a href="eventos.html">Mis Eventos</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</header>

<div class="container vs box-wrapper">
	<div class="row">
		<div class="col-md-7">
			<!-- Condicionar Incluir mensaje -->
			<div class="alert alert-danger alert-dismissable ">
			  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
			  <strong>Warning!</strong> Al parecer hubo un error con tu solicitud =(
			</div>
		</div>
	</div>
	<div class="row">

		<div class="col-md-7 evento-lista">

			<ul>
				<li>
					<div class="evento-desc">
						<h4><strong>Título: </strong> </h4>
						<p><strong>Fecha: </strong> mm/dd/yy</p>
						<p>Descripcion blah blah blah</p>
						<div class="text-right">
							<button class="btn btn-default btn-sm">Editar</button>
						</div>
					</div>
					
					<form action="" class="evento-edit hide">
						<div class="input-group col-md-6">
							<input type="text" class="input-sm form-control" placeholder="Título" required name="titulo">
						</div>

						<div class="input-group col-md-6">
							<input type="date" class="input-sm form-control" placeholder="Fecha Evento" required name="fecha">
						</div>

						<div class="input-group col-md-12">
							<textarea name="" id="" cols="30" rows="5" class="input-sm form-control" placeholder="Descripción" required name="descripcion"
							></textarea>
						</div>

						<input type="hidden" name="id" value="">

						<div class="text-right">
							<input name="eliminar" type="submit" value="Eliminar" class="btn btn-danger btn-sm">

							<input name="guardar" type="submit" value="Guardar" class="btn btn-info btn-sm">
						</div>
					</form>
				</li>
				<li>
					<div class="evento-desc">
						<h4><strong>Título: </strong> </h4>
						<p><strong>Fecha: </strong> mm/dd/yy</p>
						<p>Descripcion blah blah blah</p>
						<div class="text-right">
							<button class="btn btn-default btn-sm">Editar</button>
						</div>
					</div>
					
					<form action="" class="evento-edit hide">
						<div class="input-group col-md-6">
							<input type="text" class="input-sm form-control" placeholder="Título" required name="titulo">
						</div>

						<div class="input-group col-md-6">
							<input type="date" class="input-sm form-control" placeholder="Fecha Evento" required name="fecha">
						</div>

						<div class="input-group col-md-12">
							<textarea name="" id="" cols="30" rows="5" class="input-sm form-control" placeholder="Descripción" required name="descripcion"
							></textarea>
						</div>

						<input type="hidden" name="id" value="">

						<div class="text-right">
							<input name="eliminar" type="submit" value="Eliminar" class="btn btn-danger btn-sm">

							<input name="guardar" type="submit" value="Guardar" class="btn btn-info btn-sm">
						</div>
					</form>
				</li>
			</ul>
			

			

		</div>

		<!-- Solo si esta login -->
		<div class="col-md-offset-1 col-md-4">
			<div class="evento">
				<h4>Evento</h4>
				<form action="#"  role="form" method="post" id="ev">
					<div class="input-group">
					  <span class="input-group-addon"><span class="icon-calendar"></span></span>
					  <input type="date" class="input-sm form-control" placeholder="Fecha Evento" required name="fecha">
					</div>
					<div class="input-group">
					  <span class="input-group-addon icon-paragraph-left"></span>
					  <input type="text" class="input-sm form-control" placeholder="Título" required name="titulo">
					</div>
					<div class="input-group">
					  <span class="input-group-addon icon-paperclip"></span>
					  <input type="file" class="input-sm form-control" name="imagen">
					</div>
					<div class="text-right">
						<input type="submit" value="Publicar" class="btn btn-default btn-sm">
					</div>
				</form>
			</div>
		</div>

	</div>
</div>

	<a href="#" class="icon-arrow-up back-to-top"></a>

	<script src="js/jquery-1.11.0.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/eventos.js"></script>

</body>

</html>