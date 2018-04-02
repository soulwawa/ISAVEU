 function showAlert(){
	  document.getElementById("art").style.display="block";
	  document.getElementById("fireBtn").style.display="block";
	  $.ajax({
	      type: "GET",
	      url: "http://192.168.0.35:9999/locationFireEx.do",
	      dataType: "json",
	      success: function(data) {
	        ob = data;
	        var state = new Array();

	        for(var i = 0; i < 11; i++){
	        	var j = 600 + i;
	            var k = j.toString(); 
	        	state[i] = ob[k];
	        	if(state[i] == 0){
	        		document.getElementById("ex"+i).style.display="none";
	        	}
	        	if(state[i] == 1){
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