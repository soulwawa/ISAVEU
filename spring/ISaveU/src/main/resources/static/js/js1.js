 function showAlert(){
	  document.getElementById("art").style.display="block";
	  document.getElementById("fireBtn").style.display="block";
	  $.ajax({
	      type: "GET",
	      url: "http://192.168.0.35:9999/admin/locationFireEx.do?loc=6",
	      dataType: "json",
	      success: function(data2) {
	        obj = data2;
	        for (var i = 0; i < obj.list.length; i++){
	        	var counter = obj.list[i];
	        	console.log(counter.location);
	        	console.log(counter.fire_ex_status);
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
var alwayscheck = setInterval(function () {
    $.ajax({
      type: "GET",
      url: "http://192.168.0.35:9999/admin/Dispatcher",
      dataType: "json",
      success: function(data) {
        live = data;
        //아래에 경고 발동조건이 위치하고 조건이 성립하면  showAlert() 실행
      }
    });
  }, 9900);
