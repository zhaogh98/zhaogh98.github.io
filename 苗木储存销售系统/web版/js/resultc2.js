<script type="text/javascript">
	function getcheck()
	{
		var num = document.getElementById("cname3").value;
		var size = document.getElementById("cname4").value;
		
		var user = document.getElementById("cname5").value;
		var pass = document.getElementById("cname6").value;
		alert("cvvcvvv");
		if(isNaN(num)){
			alert("请输入数量");
		}
		if(isNaN(size)||size.replace(/(^\s*)|(\s*$)/g,"")==""){
			alert("请输入口径");
		}
		
		
		
		
	}
</script>