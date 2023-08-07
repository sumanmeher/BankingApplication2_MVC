<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Loan Details</title>
    <link rel="stylesheet" type="text/css" href="styles.css"> <!-- Include external CSS -->
    <style>
        body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f0f0f0;
        margin: 0;
        padding: 0;
        text-align: center;
    }
    
    header {
        background: linear-gradient(to right, #56CCF2, #2F80ED);
        color: #fff;
        text-align: center;
        padding: 40px 0;
        margin-bottom: 20px;
    }
    
    h1 {
        margin: 0;
        font-weight: 600;
        font-size: 36px;
    }
    
    main {
        max-width: 800px;
        margin: 0 auto;
        padding: 30px;
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        line-height: 1.6;
    }
    
    select {
        font-size: 16px;
        padding: 10px;
        margin: 10px 0;
        color: #333;
        border: 1px solid #ccc;
        border-radius: 5px;
        background-color: #F3F3F3;
        width: 100%;
    }
    
    select:hover {
        background-color: #EAEAEA;
    }
    
    select:focus {
        outline: none;
        background-color: #EAEAEA;
    }
    
    input[type="submit"] {
        font-size: 16px;
        padding: 10px 20px;
        background-color: #56CCF2;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    
    input[type="submit"]:hover {
        background-color: #2F80ED;
    }
    nav {
            background-color: #fff;
            text-align: center;
            padding: 20px;
        }

        nav a {
            color: #333;
            text-decoration: none;
            padding: 10px 20px;
            margin: 5px;
            border-radius: 5px;
            background-color: #F3F3F3;
            transition: background-color 0.3s ease;
            font-weight: 500;
        }

        nav a:hover {
            background-color: #EAEAEA;
        }

    
    </style>
</head>
<body>
    <%
    session = request.getSession();
    %>
    <header>
        <h1>Loan Details</h1>
    </header>
    <main>
        <p>Your Loan will be <b><%= session.getAttribute("l_type") %></b></p>
        <p>Of Tenure <b><%= session.getAttribute("tenure") %> Years </b></p>
        <p>With Interest <b><%= session.getAttribute("interest") %></b></p>
        <nav>
            <a href="HomePage.jsp">Go to Home</a>
        </nav>
    </main>
    <br>
    <footer>
        <p>&copy; 2023 Bank Application. All rights reserved.</p>
    </footer>
</body>
</html>