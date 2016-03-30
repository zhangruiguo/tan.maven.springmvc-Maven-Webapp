<html>
<head>
    <title>默认</title> 
    <script src="js/test.js"></script> 
</head>
<body>
<h2>Add Book</h2>
<form method="post" action="<%=request.getContextPath() %>/book.do?method=add">
bookname:<input type="text" name="name" id="name">
author:<input type="text" name="author" id="author">
<input type="submit" value="Add">
</form>
</body>
</html>
