<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>News Desk</title>
</head>
   <body>
   <div>
    <h2>${news.title}</h2>
    <hr>
    <div>
	    <img src="${news.img}">
	    <div>
	    	<h4>Date: ${news.date}</h4>
	    	<p>Content: ${news.content}</p>
	    </div>
    </div>
    <hr>
    <a href="javascript:history.go(-1)"><< Back</a>
    
    </div>
    </body>
</html>