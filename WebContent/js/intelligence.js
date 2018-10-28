function submitForm(){
	if($("#jrTime").val() != ""){
		$("#jrTimeForm").submit();
	}else{
		alert("请输入");
	}
}
function uploadFile(){
	$("#uploadFile").click();
}