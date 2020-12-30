<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,height=device-height,initial-scale=1.0" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>

body {
  margin: 0;
  padding: 0;
    background-color: #004882;
}

h1{
font-size:40px;
 text-align: center;
  text-transform: uppercase;
  color: #ffffff;
}

.useDiv {
   border: 2px #ffffff;
  padding: 25px;
   background-repeat: no-repeat;
  background-size: 100% 100%;
  
}

.colorTexture{
font-size:40px;
 text-align: center;
  text-transform: uppercase;
  color: #ffffff;
}

.OptioncolorTexture{
font-size:25px;
  color: #000000;
}

.normal {
  font-weight: normal;
}
.center {
  border: 1px solid;
  padding: 10px;
  box-shadow: 5px 10px ;
}



.nextbutton {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}

.submit {
  background-color: #f44336; /* RED */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}
</style>
<meta charset="ISO-8859-1">

<title>Quiz</title>
</head>
<body>
<div class="useDiv">
<div class="center">
<form action="/checkingResultForWebsite" method="get" >
<c:if test="${empty quizOver}">
<div class="colorTexture">
<c:out  value="${list.get(initially).question }"/>
</div>
<div class="OptioncolorTexture">
  <c:forEach items="${list.get(initially).option}" var="op">
  <br>
  <br>
   <c:out value="${op}" />
  <input type="radio"  name="value" value="${op}">
  </c:forEach>
      <input type="hidden"  name="indexNumber" value="${list.indexOf(list.get(initially))}">
      <br>
      <br>
<input type="submit" class="submit">
<c:out value="${result}"></c:out>
</div>
</c:if>
<div class="colorTexture">
 <c:out value="${quizOver}" />
 </div>
  </form>
  <br>
  <br>
  <form action="/nextQuestion" method="post">
  <c:if test="${empty quizOver}">
  <input type="submit" value="Next Question" class="nextbutton">
       <input type="hidden"  name="currentValue" value="${list.indexOf(list.get(initially))}">
       </c:if>
  </form>
  <form action="/backToMenu" method="post">
    <c:if test="${!empty quizOver }">
    <input type="submit"  name ="back" value="Return To Main Menu" class="nextbutton">
    </c:if>
  </form>
  
  </div>
</div>
</body>
</html>