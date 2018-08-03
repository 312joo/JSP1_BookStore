/**
 * 회원가입폼 확인
 */
function formCheck(obj){
	if(!obj.customer_id.value||obj.customer_id.value.trim().length==0){
		alert("아이디가 입력되지 않았습니다.");
		obj.customer_id.value="";
		obj.customer_id.focus();
		return false;
	}
	if(!obj.customer_pass.value||obj.customer_pass.value.trim().length==0){
		alert("비밀번호가 입력되지 않았습니다.");
		obj.customer_pass.value="";
		obj.customer_pass.focus();
		return false;
	}
	if(!obj.customer_pass2.value||obj.customer_pass2.value.trim().length==0){
		alert("비밀번호가 입력되지 않았습니다.");
		obj.customer_pass2.value="";
		obj.customer_pass2.focus();
		return false;
	}
	if(!obj.customer_name.value||obj.customer_name.value.trim().length==0){
		alert("이름이 입력되지 않았습니다.");
		obj.customer_name.value="";
		obj.customer_name.focus();
		return false;
	}
	if(!obj.customer_age.value||obj.customer_age.value.trim().length==0){
		alert("나이가 입력되지 않았습니다.");
		obj.customer_age.value="";
		obj.customer_age.focus();
		return false;
	}
	if(!obj.customer_gender.value||obj.customer_gender.value.trim().length==0){
		alert("성별이 입력되지 않았습니다.");
		obj.customer_gender.value="";
		obj.customer_gender.focus();
		return false;
	}
	if(!obj.customer_email.value||obj.customer_email.value.trim().length==0){
		alert("이메일이 입력되지 않았습니다.");
		obj.customer_email.value="";
		obj.customer_email.focus();
		return false;
	}
	
}