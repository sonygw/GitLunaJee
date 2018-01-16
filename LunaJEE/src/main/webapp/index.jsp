<!DOCTYPE html>
<html lang="en" >
<%@ taglib prefix ="s" uri="/struts-tags" %>
<head>
  <meta charset="UTF-8">
  <title>Projet Luna Jee</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=yes">
  
  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans'>

      <link rel="stylesheet" href="css/style.css">

  
</head>

<body>

  <div class="cont">
  <div class="demo">
    <div class="login">
<!--       <div class="login__check"></div> -->
     <div style="height : 200px "></div>
      <s:form action="login">
        <div class="login__row">

 
          <input type="text" class="login__input name" placeholder="Username"/>
        </div>
        <div class="login__row">
   
          <input type="password" class="login__input pass" placeholder="Password"/>
        </div>
        <s:submit type="button" class="login__submit" >Connexion</s:submit>>
       </s:form>
      </div>
    </div>

  </div>

  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  


</body>

</html>
