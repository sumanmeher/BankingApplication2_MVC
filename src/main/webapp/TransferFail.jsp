<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Transfer Fail</title>
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
        .cross-gif {
            width: 50px;
            height: 50px;
        }

        footer {
            color: #000;
            text-align: center;
            padding:20px;
}
    </style>
</head>
<body>
    <header>
        <h1>Transfer Fail</h1>
    </header>
    <main>
        <img class="cross-gif" src="https://thumbs.gfycat.com/DiligentWastefulGavial-max-1mb.gif" alt="Cross Sign">
        <p>Your transfer was unsuccessful.</p>
        <a href="HomePage.jsp">Go To Home</a>
    </main>
    <footer>
        <p>&copy; 2023 Bank Application. All rights reserved.</p>
    </footer>
</body>
</html>