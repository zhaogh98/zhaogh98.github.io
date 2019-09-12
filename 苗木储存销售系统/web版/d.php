<html>
<head>
</head>
<body>
<?php
// 定义变量并设置为空值
$companyErr = $addressErr = $nameErr = $phoneErr = $passnumErr = $checkpassErr = "";
$company = $address = $name = $phone = $passnum = $checkpass = "";
$flag = 0;
if ($_SERVER["REQUEST_METHOD"] == "POST") {
	if (empty($_POST["company"])) {
		$companyErr = "company is required";
		$flag = 1;
	}else {
		$company = test_input($_POST["company"]);
	}

	if (empty($_POST["address"])) {
		$addressErr = "address is required";
		$flag = 1;
	}else {
		$address = test_input($_POST["address"]);
	}
	
	if (empty($_POST["name"])) {
		$nameErr = "name is required";
		$flag = 1;
	} else {
		$name = test_input($_POST["name"]);
	}
	
	if (empty($_POST["phone"])) {
		$phoneErr = "phone is required";
		$flag = 1;
	} else {
		$phone = test_input($_POST["phone"]);
	}
	
	if (empty($_POST["passnum"])) {
		$passnumErr = "passnum is required";
		$flag = 1;
	} else {
		$passnum = test_input($_POST["passnum"]);
	}
	
	$checkpass = test_input($_POST["checkpass"]);
	
	if ($checkpass==$passnum) {
		$checkpassErr = "";
	} else {
		$checkpassErr = "checkpass is wrong";
		$flag = 1;
	}
}

if($flag == 1){
	echo $companyErr;
	echo "<br>";
	echo $addressErr;
	echo "<br>";
	echo $nameErr;
	echo "<br>";
	echo $phoneErr;
	echo "<br>";
	echo $passnumErr;
	echo "<br>";
	echo $checkpassErr;
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
$sql=  "insert into buyer (bname,province,person,phone,passnum)
		values ('$company','$address','$name','$phone','$passnum')";
$query=mysqli_query($conn,$sql);
if(!$query){
	echo "so sad!!!!!";
}
else{
	echo "恭喜你注册成功！";
}
?>
</body>
</html>