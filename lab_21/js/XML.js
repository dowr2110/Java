function Fill(req){
      var xmldoc = req.responseXML;
      var  tsnum = xmldoc.getElementsByTagName('num');
      var rc = "";
      for (var i = 0; i < tsnum.length; i++){
         rc += tsnum[i].firstChild.data+" ";         
       }
     return rc;
 };
 
 function OnClick_XML(n, s){
		var req = new XMLHttpRequest();
       var patern = new RegExp(/^[1-9]+[0-9]*$/); 
       if (patern.test(n)){
       if (req){
          req.open("POST","http://localhost:8081/Lab_21/Sss_XML", true);
          req.onreadystatechange = function(){
                                     if (req.readyState == 4){
                                        if (req.status == 200){
                                            s.firstChild.data = Fill(req);
                                            s.className ="h1";
                                        }else alert("status = "+ 
                                         req.status +"\n"+req.statusText);
                                      }
                                   };             
          req.setRequestHeader("XRand-N",  n)
          req.send("null");
       }
      }else alert ("error");    
 };  

 
 function OnClick_XML_sync(n, s){
	   var req = new XMLHttpRequest();
	   var patern = new RegExp(/^[1-9]+[0-9]*$/);
       if (patern.test(n.value)){
       if (req){
          req.open("POST","http://localhost:8081/Lab_21/Sss_XML_sync", true);
          req.onreadystatechange = function(){
                                     if (req.readyState == 4){
                                        if (req.status == 200){
                                            s.firstChild.data = Fill(req);
                                            s.className ="h1";
                                        }else 
                                        	{alert("status = "+ 
                                         req.status +"\n"+req.statusText);
                                        	alert("XML Error");
                                        	}
                                      }
                                   };             
          req.setRequestHeader("XRand-N",  n.value);
          req.send("null");
       }
      }else alert ("error in XML");    
 }; 
