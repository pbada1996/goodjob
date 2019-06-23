<?php
$hostname="localhost"
$database="goodjob"
$username="root"
$password=""

$json=array();
	if(isset($_GET["Ucorreo"]) && isset($_GET["Upass"])){
		$Ucorreo=$_GET['Ucorreo'];
		$Ucorreo=$_GET['Upass'];
		$Ucorreo=$_GET['Upass'];
		$conexion=mysqli_connect($hostname,$username,$password,$database);

		$sql="SELECT Ucorreo,Upass FROM usuario WHERE Ucorreo= '{$Ucorreo}' AND Upass= '{$Upass}'";
		$result = mysqli_query($conexion,$sql);

		if($sql){
			if ($reg=mysqli_fetch_array($result)) {
				$json['datos'][]=$reg;
			}
			mysqli_close($conexion);
			echo json_encode($json);
		}else{
			$results["Ucorreo"]='';
			$results["Upass"]='';
			$json['datos'][]=$results;
			echo json_encode($json);
		}

	}
?>