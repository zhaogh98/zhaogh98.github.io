<?php
//设置编码格式
header("Content-type:text/html;charset=utf-8");
//定义数据库主机地址
$host="localhost";
//定义mysql数据库登录用户名
$user="root";
//定义mysql数据库登录密码
$password="001215";
//定义选择的数据库
$dbname="qsls";
//链接数据库
$conn=mysqli_connect($host,$user,$password);
//选择数据库
mysqli_select_db($conn,$dbname);
//设置数据库编码格式
mysqli_query($conn,"SET names UTF8");
//设置头部样式
header("Content-Type: text/html; charset=utf-8");
?>