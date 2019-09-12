<html>
<head>
</head>
<body>
<table border = '1' width = 500>
<tr><th>品种</th><th>口径</th><th>数量</th><th>土球情况</th><tr>
<?php
// 定义变量并设置为空值
$ftname = "";
if ($_SERVER["REQUEST_METHOD"] == "POST") {
	$ftname = test_input($_POST["ftname"]);
}

function test_input($data) {
	$data = trim($data);
	$data = stripslashes($data);
	$data = htmlspecialchars($data);
	return $data;
}

include_once("connect.php");
$sql=	"select * from tree
		where tname = '$ftname'";
$query=mysqli_query($conn,$sql);
if(!$query){
	echo "null!!!!!!";
	exit;
}
else{
	$hnum=intval(mysqli_num_rows($query));
	for ($i=0; $i <$hnum ; $i++) { 
    	$row=mysqli_fetch_assoc($query);
    	$tname=$row['tname'];
    	$size=$row['size'];
		$num=$row['num'];
		$tu=$row['tu'];
    	echo "<tr><td>$tname</td><td>$size</td><td>$num</td><td>$tu</td><tr>";
    }
}
?>
</body>
</html>