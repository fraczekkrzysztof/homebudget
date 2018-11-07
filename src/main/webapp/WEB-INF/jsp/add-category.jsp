<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
      <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
      <html>

        <head>
          <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
          <title>Add expense</title>
          <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        </head>

        <body>
          <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <a class="navbar-brand" href="#">Expense Manager</a>
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/expense/list">Expense List</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/expense/showFormForAdd">Add expense</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/category/list">Category List</a>
              </li>
              <li class="nav-item">
                <a class="nav-link disabled" href="${pageContext.request.contextPath}/category/showFormForAdd">Add Category</a>
              </li>
            </ul>
          </nav>
          <div class="container text-center" style="width:60%; padding-top:10px; padding-bottom: 10px; color:red; font-weight: bold">
            ${addError}
          </div>
          <div class="container text-center">
          <form:form modelAttribute="category" action="saveCategory" method="POST">
            <form:hidden path="id" />
            <!-- -->
            <div class="form-group row">
              <label for="symbol" class="col-sm-2 col-form-label">Symbol</label>
              <div class="col-sm-8">
                <form:input class="form-control" path="symbol" placeholder="Symbol" />
              </div>
              <div class="col-sm-2"> 
                <form:errors path="symbol" style="color:red;" />
              </div>
            </div>
            <!-- -->
            <div class="form-group row">
              <label for="name" class="col-sm-2 col-form-label">Name</label>
              <div class="col-sm-8">
                <form:input class="form-control" path="name" placeholder="Name" />
              </div>
              <div class="col-sm-2"> 
                <form:errors path="name" style="color:red;" />
              </div>
            </div>
            <!-- -->
          <input type="submit" value="Save" class="btn btn-primary" />
          </form:form>  
            
          </div>
        </body>