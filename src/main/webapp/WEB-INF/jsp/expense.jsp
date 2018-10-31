<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
      <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
      <html>

      <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Expense Manager</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
      </head>

      <body>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
          <a class="navbar-brand" href="#">Expense Manager</a>
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link" href="#">Add expense</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Category List</a>
            </li>
          </ul>
        </nav>

        <div class="jumbotron" style="height:100px; padding:10px; padding-left: 50px;">
          <h2>Expense Manager</h2>
          <p>Simple app to manage your home budget</p>
        </div>

        <div class="container text-center" style="width: 80%">
          <table class="table table-bordered table-hover ">
            <thead class="thead-dark">
              <tr>
                <th>Date</th>
                <th>Description</th>
                <th>Category</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="tempExpense" items="${listOfExpense}">
                <tr>
                  <td>${tempExpense.date}</td>
                  <td>${tempExpense.description}</td>
                  <td>${tempExpense.category.name}</td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
        <!-- Bootstrap js-->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <!-- and of bootstrap js-->
      </body>

      </html>
