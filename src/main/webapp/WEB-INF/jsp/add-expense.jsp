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
              <a class="nav-link" href="${pageContext.request.contextPath}/expense">Expense List</a>
            </li>
            <li class="nav-item">
              <a class="nav-link disabled" href="${pageContext.request.contextPath}/showFormForAdd">Add expense</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Category List</a>
            </li>
          </ul>
        </nav>
        <div class="container text-center" style="width:60%; padding-top:10px; padding-bottom: 10px; color:red; font-weight: bold">
          ${addError}
        </div>
        <div class="container text-center" style="width:60%;">
          <form:form action="saveExpense" modelAttribute="expense" method="POST">
            <form:hidden path="id" />
            <!-- -->
            <div class="form-group row">
              <label for="description" class="col-sm-2 col-form-label">Description</label>
              <div class="col-sm-8">
                <form:input class="form-control" path="description" placeholder="Description" />
              </div>
              <div class="col-sm-2"> 
                <form:errors path="description" style="color:red;" />
              </div>

            </div>
            <!-- -->
            <div class="form-group row">
              <label for="category" class="col-sm-2 col-form-label">Category</label>
              <div class="col-sm-8">
                <form:select class="custom-select" path="categoryId">
                  <form:option value="-1" label="---chooseOne---" />
                  <form:options items="${categories}" />
                </form:select>
              </div>
              <div class="col-sm-2"> 
                <form:errors path="categoryId" style="color:red;" />
              </div>
            </div>
            <!-- -->
            <div class="form-group row">
              <label for="date" class="col-sm-2 col-form-label">Date</label>
              <div class="col-sm-8">
                <form:input type="date" class="form-control" path="date" placeholder="Description" />
              </div>
              <div class="col-sm-2"> 
                <form:errors path="date" style="color:red;" />
              </div>
            </div>
            <!-- -->
            <input type="submit" value="Save" class="btn btn-primary" />
          </form:form>
        </div>
        <!-- Bootstrap js-->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <!-- and of bootstrap js-->
      </body>

      </html>
