<?php

	$hostname_localhost="localhost";
	$database_localhost="goodjod";
	$username_localhost="root";
	$password_localhost="";

	$json=array();

	if (isset($_GET["idUsuario"]) && isset($_GET["UFoto"]) && isset($_GET["Unombre"]) && isset($_GET["UPaterno"]) && isset($_GET["UMaterno"]) && isset($_GET["Udni"]) && isset($_GET["UPasaporte"]) && isset($_GET["UfechaNacimiento"]) && isset($_GET["Ucelular"]) && isset($_GET["idPerfilP"]) && isset($_GET["Ucorreo"]) && isset($_GET["idDistrito"]) && isset($_GET["Udireccion"]) && isset($_GET["Upass"]) && isset($_GET["idTipoPremiun"]) && isset($_GET["UfechaRegistro"]) && isset($_GET["Uestado"])) {
		
		$idUsuario=$_GET['idUsuario'];
		$UFoto=$_GET['UFoto'];
		$Unombre=$_GET['Unombre'];
		$UPaterno=$_GET['UPaterno'];
		$UMaterno=$_GET['UMaterno'];
		$Udni=$_GET['Udni'];
		$UPasaporte=$_GET['UPasaporte'];
		$UfechaNacimiento=$_GET['UfechaNacimiento'];
		$Ucelular=$_GET['Ucelular'];
		$idPerfilP=$_GET['idPerfilP'];
		$Ucorreo=$_GET['Ucorreo'];
		$idDistrito=$_GET['idDistrito'];
		$Udireccion=$_GET['Udireccion'];
		$Upass=$_GET['Upass'];
		$idTipoPremiun=$_GET['idTipoPremiun'];
		$UfechaRegistro=$_GET['UfechaRegistro'];
		$Uestado=$_GET['Uestado'];

		$conexion=mysqli_connect($hostname_localhost,$username_localhost,$password_localhost,$database_localhost);

		$insert="INSERT INTO usuario(idUsuario, UFoto, Unombre, UPaterno, UMaterno, Udni, UPasaporte, UfechaNacimiento, Ucelular, idPerfilP, Ucorreo, idDistrito, Udireccion, Upass, idTipoPremiun, UfechaRegistro, Uestado) VALUES('{$idUsuario}','{$UFoto}','{$Unombre}','{$UPaterno}','{$UMaterno}','{$Udni}','{$UPasaporte}','{$UfechaNacimiento}','{$Ucelular}','{$idPerfilP}','{$Ucorreo}','{$idDistrito}','{$Udireccion}','{$Upass}','{$idTipoPremiun}','{$UfechaRegistro}','{$Uestado}')";

		$resultado_insert=mysqli_query($conexion,$insert);

		if ($resultado_insert) {
			$consulta="SELECT * FROM usuario WHERE idUsuario= '{$idUsuario}'";
			$resultado=mysqli_query($conexion,$consulta);

			if ($registro=mysqli_fetch_array($resultado)) {
				$json['usuario'][]=$registro;
			}
			mysqli_close($conexion);
			echo json_encode($json);
		}else{
			$resulta["idUsuario"]=0;
			$resulta["UFoto"]=0;
			$resulta["Unombre"]='No Registra';
			$resulta["UPaterno"]='No Registra';
			$resulta["UMaterno"]='No Registra';
			$resulta["Udni"]=0;
			$resulta["UPasaporte"]=0;
			$resulta["UfechaNacimiento"]='No Registra';
			$resulta["Ucelular"]=0;
			$resulta["idPerfilP"]=0;
			$resulta["Ucorreo"]='No Registra';
			$resulta["idDistrito"]=0;
			$resulta["Udireccion"]='No Registra';
			$resulta["Upass"]='No Registra';
			$resulta["idTipoPremiun"]=0;
			$resulta["UfechaRegistro"]='No Registra';
			$resulta["Uestado"]=0;
			$json['usuario'][]=$resulta;
			echo json_encode($json);
		}
		

	}else{
			$resulta["idUsuario"]=0;
			$resulta["UFoto"]=0;
			$resulta["Unombre"]='WSNo Registra';
			$resulta["UPaterno"]='WS No Registra';
			$resulta["UMaterno"]='WS No Registra';
			$resulta["Udni"]=0;
			$resulta["UPasaporte"]=0;
			$resulta["UfechaNacimiento"]='WS No Registra';
			$resulta["Ucelular"]=0;
			$resulta["idPerfilP"]=0;
			$resulta["Ucorreo"]='WS No Registra';
			$resulta["idDistrito"]=0;
			$resulta["Udireccion"]='WS No Registra';
			$resulta["Upass"]='WS No Registra';
			$resulta["idTipoPremiun"]=0;
			$resulta["UfechaRegistro"]='WS No Registra';
			$resulta["Uestado"]=0;
			$json['usuario'][]=$resulta;
			echo json_encode($json);
		}

?>