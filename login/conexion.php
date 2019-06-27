<?php

	$con = mysqli_connect("localhost", "root", "", "goodjod");

	$Ucorreo = $_POST["Ucorreo"];
	$Upass = $_POST["Upass"];

	$statement = mysqli_prepare("SELECT * FROM usuario WHERE Ucorreo = ? AND Upass = ?");
	mysqli_stmt_bind_param($statement, "ss", $Ucorreo, $Upass);
	mysqli_stmt_execute($statement);

	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_result($statement,
		$idUsuario,
		$UFoto,
		$Unombre,
		$UPaterno,
		$UMaterno,
		$Udni,
		$Upasaporte,
		$UfechaNacimiento,
		$Ucelular,
		$idPerfilP,
		$Ucorreo,
		$idDistrito,
		$Udireccion,
		$Upass,
		$idTipoPremiun,
		$UfechaRegistro,
		$Uestado);

	$response = array();
	$response["sucess"] = false;

	while (mysqli_stmt_fetch($statement)) {

		$response["sucess"] = true;
		//responder datos si quiero
	}

	echo json_encode($response);
?>