<html>
<head>
</head>
<body>
<?php
// 定义变量并设置为空值
$sizeErr = $numErr = $bnameErr = $passnumErr = "";
$tname = $size = $num = $tu = $bname = $passnum = "";
$flag = 0;
if ($_SERVER["REQUEST_METHOD"] == "POST") {
	$tname = test_input($_POST["tname"]);
	
	if (empty($_POST["num"])) {
		$numErr = "num is required";
		$flag = 1; 
	} else {
		$num = intval(test_input($_POST["num"]));
	}

	if (empty($_POST["size"])) {
		$sizeErr = "size is required";
		$flag = 1; 
	}else {
		$size = test_input($_POST["size"]);
	}
	
	$tu = test_input($_POST["tu"]);
	
	if (empty($_POST["bname"])) {
		$bnameErr = "bname is required";
		$flag = 1; 
	} else {
		$bname = test_input($_POST["bname"]);
	}
	
		
	if (empty($_POST["passnum"])) {
		$passnumErr = "passnum is required";
		$flag = 1; 
	} else {
		$passnum = test_input($_POST["passnum"]);
	}
}

if($flag == 1){
	echo $numErr;
	echo "<br>";
	echo $sizeErr;
	echo "<br>";
	echo $bnameErr;
	echo "<br>";
	echo $passnumErr;
	echo "<br>";
	exit;
}

function test_input($data) {
	$data = trim($data);
	$data = stripslashes($data);
	$data = htmlspecialchars($data);
	return $data;
}

include_once("connect.php");
$sql1=	"select passnum from buyer
		where bname = '$bname'";
$query1=mysqli_query($conn,$sql1);
$row = mysqli_fetch_array($query1);
if($row['passnum']==$passnum){}
else{
	echo "买家信息有误！";
	exit;
}
$sql2=	"select num from tree
		where tname = '$tname' and size = '$size' and tu = '$tu'";
$query2=mysqli_query($conn,$sql2);
if(!$query2){
	echo "没有您要的树！";
	exit;
}
else{
	$row = mysqli_fetch_array($query2);
	$hasnum = intval($row['num']);
	if($hasnum < $num){
		echo "没有足够的树！";
		exit;
	}
	else{
		if($havenum==$num){
			$sqld=	"delete from tree 
					where tname = '$tname' and size = '$size' and tu = '$tu'";
			$queryd=mysqli_query($conn,$sqld);
		}
		else{
			$nnum = $hasnum - $num;
			$sqlu=	"update tree set num = ".$nnum."
					where tname = '$tname' and size = '$size' and tu = '$tu'";
			$queryu=mysqli_query($conn,$sqlu);
		}
		$sql3=  "insert into sale (bname,tname,size,num,tu)
				values ('$bname','$tname','$size','$num','$tu')";
		$query3=mysqli_query($conn,$sql3);
		if(!$query3){
			echo "so sad!!!!!";
		}
	}
}
?>
</body>
</html>