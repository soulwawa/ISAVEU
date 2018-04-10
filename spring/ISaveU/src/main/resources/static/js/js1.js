check();
var alwayscheck = setInterval(function () {
    check();
  }, 9900);
function check() {
	$.ajax({
	      type: "GET",
	      url: "http://192.168.0.35:9999/admin/Dispatcher",
	      dataType: "json",
	      success: function(data) {
	        live = data;
	        var issuenow = live.issue;
	        if(issuenow == 1) {
	        	document.getElementById("art").style.background="rgba(255,0,0,0.8);";
	        	document.getElementById("art").innerHTML = "화재발생 </n><br/> <div id='fireBtn' onclick='closeAlert()'>위치확인</div>" ;
	        	showAlert()
	        }else if(issuenow == 2){
	        	document.getElementById("art").style.background="rgba(255,255,0,0.8);";
	        	document.getElementById("art").innerHTML = "지진발생";
	        	showAlert()
	        }else if(issuenow == 3){
	        	document.getElementById("art").style.background="rgba(255,255,0,0.8);";
	        	document.getElementById("art").innerHTML = "화재 / 지진 발생 </n><br/> <div id='fireBtn' onclick='closeAlert()'>위치확인</div>";
	        	showAlert()
	        }
	        //아래에 경고 발동조건이 위치하고 조건이 성립하면  showAlert() 실행
	      }
	    });
}


function showAlert(){
	  document.getElementById("art").style.display="block";
	  document.getElementById("fireBtn").style.display="block";
	  $.ajax({
	      type: "GET",
	      url: "http://192.168.0.35:9999/admin/locationFireEx.do?loc=6",
	      dataType: "json",
	      success: function(data2) {
	        obj = data2;
	        for (var i = 0; i < obj.value.length; i++){
	        	var counter = obj.value[i];
	        	if(counter.fire_ex_status == 0){
	        		document.getElementById("ex"+i).style.display="none";
	        	}
	        	if(counter.fire_ex_status == 1){
	        		document.getElementById("ex"+i).style.display="block";
	        	}
	        	
	        }
	      }
	    });
  }
  function closeAlert(){
	  showLocation();
	  document.getElementById("art").style.display="none";
	  document.getElementById("fireBtn").style.display="none";
  }
  function showLocation(){
	  document.getElementById("lct").style.display="block";
  }
  function closeLocation(){
	  document.getElementById("lct").style.display="none";
  }
  
  function goReplace(str){
	  location.replace(str); 
  }
  var b = 0;
  function showBtn(){
	  if(b == 0){
		  document.getElementById("views").style.display="display";
	  }
	  if(b == 1){
		  document.getElementById("views").style.display="none";
	  }
  }
var box1 = document.getElementById("btnSensor");

if(box1){
	box1.addEventListener('mouseover',function(){
		box.setAttribute('class','hover');
	});
	}
if(box1){
	box1.addEventListener('mouseout',function(){
		box.removeAttribute('class');
	});
	}

