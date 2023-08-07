<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Transaction History</title>
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
            line-height: 1;
        }

        a {
            font-size: 16px;
            padding: 10px 20px;
            background-color: #56CCF2;
            color: #fff;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            display: inline-block;
            margin-top: 20px;
        }

        a:hover {
            background-color: #2F80ED;
        }

        .transaction {
            margin-bottom: 20px;
            padding: 10px;
            border-radius: 5px;
            background-color: #F3F3F3;
        }

        .transaction p {
            margin: 5px 0;
        }

        .sent {
            color: #fd3f34;
        }

        .received {
            color: #4cb74c;
        }
        footer {
            color: #000;
            text-align: center;
            padding: 20px;
        }

    </style>
</head>
<body>
    <header>
        <h1>Transaction History</h1>
    </header>
    <main>
        <%
        int acc_no = (int) session.getAttribute("acc_no");
        String url = "jdbc:mysql://localhost:3306/banking application";
        String user = "root";
        String pwd = "admin@12345";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);

            PreparedStatement pstmt = con.prepareStatement(
            "select * from transfer_status where sender_accno = ? or receiver_accno=? order by t_id desc");
            pstmt.setInt(1, acc_no);
            pstmt.setInt(2, acc_no);

            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getInt("sender_accno") == acc_no) {

                    pstmt = con.prepareStatement("select * from bankapp where acc_no = ?");
                    pstmt.setInt(1, resultSet.getInt("receiver_accno"));
                    ResultSet secondPerson = pstmt.executeQuery();
                    secondPerson.next();

                    
                    out.println("<p><b>Sent:</b></p>");
                    out.println("<p><b>Sent To: " + resultSet.getInt("receiver_accno") + "</b></p>");
                    out.println("<p><b>Receiver Name: " + secondPerson.getString("cust_name") + "</b></p>");
                    out.println("<div class=\"transaction sent\">");
                    out.println("<p><b>Amount: "+resultSet.getInt("amount")+ "</b></p>");
                    out.println("</div>");
                    out.println("--------------------------------------------------------------");

                } else {
                    pstmt = con.prepareStatement("select * from bankapp where acc_no = ?");
                    pstmt.setInt(1, resultSet.getInt("sender_accno"));
                    ResultSet secondPerson = pstmt.executeQuery();
                    secondPerson.next();

                    
                    out.println("<p><b>Received:</b></p>");
                    out.println("<p><b>Received From: " + resultSet.getInt("receiver_accno") + "</b></p>");
                    out.println("<p><b>Sender Name: " + secondPerson.getString("cust_name") + "</b></p>");
                    out.println("<div class=\"transaction received\">");
                    out.println("<p><b>Amount: "+resultSet.getInt("amount")+ "</b></p>");
                    out.println("</div>");
                    out.println("---------------------------------------------------------------");
                }
                

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        %>
        <br><br>
        <a href="HomePage.jsp">Go To Home</a>
    </main>
    <footer>
        <p>&copy; 2023 Bank Application. All rights reserved.</p>
    </footer>
</body>
</html>