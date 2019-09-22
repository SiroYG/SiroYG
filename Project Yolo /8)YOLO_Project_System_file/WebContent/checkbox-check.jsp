<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>w</title>

<script>
   function checkedListener(){

      var size = document.getElementsByName("category").length;
       for(var i = 0; i < size; i++){
           if(document.getElementsByName("category")[i].checked == true){
               alert(document.getElementsByName("category")[i].value);
           }
       }

   }
</script>
</head>
<body>

   <form>
      <div>
         <div align="center" id="icon">
            <input type="checkbox" id="chk1" class="checkbox" name="category" value="mountain" /> 
            <input type="checkbox" id="chk2" class="checkbox" name="category" value="beach"> 
            <input type="checkbox" id="chk3" class="checkbox" name="category" value="mt" />
            <input type="checkbox" id="chk4" class="checkbox" name="category" value="spa" /> 
            <input type="checkbox" id="chk5" class="checkbox" name="category" value="swimmingpool" />
            <input type="checkbox" id="chk6" class="checkbox" name="category" value="valley" />
            <input type="button" onClick="checkedListener()"/>
         </div>
      </div>
   </form>


</body>
</html>