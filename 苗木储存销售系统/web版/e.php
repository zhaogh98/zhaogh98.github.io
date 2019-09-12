<html>
<head>
</head>
<body>
<table border = '1' width = 500>
<tr><th>用户名</th><th>品种</th><th>口径</th><th>数量</th><th>土球情况</th><tr>
<?php
// 定义变量并设置为空值
$bnameErr = $passnumErr = $bname = $passnum = $flag = "";
if ($_SERVER["REQUEST_METHOD"] == "POST") {
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
$sql2=	"select * from sale
		where bname = '$bname'";
$query2=mysqli_query($conn,$sql2);
if(!$query2){
	echo "null!!!!!!";
	exit;
}
else{
	$hnum=intval(mysqli_num_rows($query2));
	for ($i=0; $i <$hnum ; $i++) { 
    	$row=mysqli_fetch_assoc($query2);
		$bname=$row['bname'];
    	$tname=$row['tname'];
    	$size=$row['size'];
		$num=$row['num'];
		$tu=$row['tu'];
    	echo "<tr><td>$bname</td><td>$tname</td><td>$size</td><td>$num</td><td>$tu</td><tr>";
    }
}
?>
</body>
</html>