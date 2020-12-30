<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Quiz</title>
<style >

body {
  margin: 0;
  padding: 0;
  background-color: #004882;
}

.btn {
  background-color: DodgerBlue;
  border: none;
  color: white;
  padding: 12px 30px;
  cursor: pointer;
  font-size: 20px;
   position: absolute;
}
.btn:hover {
  background-color: RoyalBlue;
}
h1 {
  text-shadow: rgba(255, 255, 255, 0.2);
  text-align: center;
  font-size: 40px;
   color: white;
   font-family: "Comic Sans MS", cursive, sans-serif
}

a   {
  float: right;
text-align: right;
  font-size: 20px;
   color: white;
   font-family: "Comic Sans MS", cursive, sans-serif
}
.text {
  text-shadow: rgba(255, 255, 255, 0.2);
  text-align: center;
  font-size: 40px;
   color: white;
   font-family: "Comic Sans MS", cursive, sans-serif
}

.box {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.box select {
  background-color: #0563af;
  color: white;
  padding: 12px;
  width: 250px;
  border: none;
  font-size: 20px;
  box-shadow: 0 5px 25px rgba(0, 0, 0, 0.2);
  -webkit-appearance: button;
  appearance: button;
  outline: none;
}



.box:hover::before {
  color: rgba(255, 255, 255, 0.6);
  background-color: rgba(255, 255, 255, 0.2);
}

.input {
  color: rgba(255, 255, 255, 0.6);
  background-color: rgba(255, 255, 255, 0.2);
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  text-align:center;
  align-self: center;
}

.box select option {
  padding: 30px;
}
</style>
</head>
<body>

<h1>devAndroid.Quiz</h1>
<br>
<a href="https://documenter.getpostman.com/view/8626127/TVmJgyap">Api Documentation</a>
<div class="box">

<form action="/startQuiz">

<select id="quizType" name="quizType">
  <c:forEach items="${list}" var="op">
  <option value="${op}">${op}</option>
  </c:forEach>
</select>
<input type="submit" value="start" class="input">
<br>
<br>

</form>
<form action="">
<button class="btn"><i class="fa fa-download"></i> Download Apk</button>
</form>
</div>
</body>
</html>