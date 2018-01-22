<!DOCTYPE html>
<html lang="en" >
<%@ taglib prefix ="s" uri="/struts-tags" %>
<head>
  <meta charset="UTF-8">
  <title>Projet Luna Jee - Login</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=yes">
  
  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans'>

      <link rel="stylesheet" href="css/style.css">

  
</head>

<body>

  <div class="cont" style="background-image: url(images/pleine-lune.jpg)">
  <div class="demo">
    <div class="login">
<!--       <div class="login__check"></div> -->
     <div style="height : 200px ; font-size: 65px ;border-style: solid; border-width: 50px; border-color: transparent;"> <center>Luna</center></div>
      <s:form action="accueil">
        <div class="login__row">

 
          <input type="text" class="login__input name" placeholder="Username"/>
        </div>
        <div class="login__row">
   
          <input type="password" class="login__input pass" placeholder="Password"/>
        </div>
        <div style="align-content: right 100%;">
        <s:submit type="button" class="login__submit"  >Connexion</s:submit>
        </div>
       </s:form>
      </div>
    </div>

  </div>

  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  


</body>

</html>
