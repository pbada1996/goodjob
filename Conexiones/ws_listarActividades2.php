<?php

	define('DB_HOST', 'localhost');
	define('DB_USER', 'root');
	define('DB_PASS', '');
	define('DB_NAME', 'goodjod');
	
	$con = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);
	
	if(mysqli_connect_errno())
	{
		die('Unable to connect to database' . mysqli_connect_error());
	}
	
	$consulta = $con -> prepare("select a.id, titulo, a.descripcion, concat(Unombre, ' ', UPaterno) as 'NombreCompleto', fecha_creacion, fecha_fin 
		, participantes_actuales, participantes_requeridos, foto, t.descripcion as 'TipoRecompensa', recompensa, estado 
		from actividad a inner join usuario u 
		on a.id_usuario = u.idUsuario 
		inner join tipo_recompensa t 
		on t.id = a.tipo_recompensa 
		where estado = 1;");
		
	$consulta -> execute();
	
	$consulta -> bind_result($id, $titulo, $descripcion, $nombreCompleto, $fecha_creacion, $fecha_fin, 
	$participantes_actuales, $participantes_requeridos, $foto, $tipo_recompensa, $recompensa, $estado);
	
	$actividad = array();
	
	while ($consulta -> fetch())
	{
		$temp = array();
		$temp['id'] = $id;
		$temp['titulo'] = $titulo;
		$temp['descripcion'] = $descripcion;
		$temp['nombreCompleto'] = $nombreCompleto;
		$temp['fecha_creacion'] = $fecha_creacion;
		$temp['fecha_fin'] = $fecha_fin;
		$temp['participantes_actuales'] = $participantes_actuales;
		$temp['participantes_requeridos'] = $participantes_requeridos;
		$temp['foto'] = $foto;
		$temp['tipo_recompensa'] = $tipo_recompensa;
		$temp['recompensa'] = $recompensa;
		$temp['estado'] = $estado;
		
		array_push($actividad, $temp);
	}
	
	mysqli_close($con);
	
	echo json_encode($actividad);
?>