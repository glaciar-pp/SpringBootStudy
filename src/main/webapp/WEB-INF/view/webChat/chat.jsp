<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <!-- Custom styles for this template -->
    <link href="/css/template.css" rel="stylesheet" />
    <script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
    <script src="/js/bootstrap.bundle.min.js"></script>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <script src="/js/main.js"></script>
     <script src="https://clovachatbot-webkit.line-scdn.net/webchat/webchat-1.2.0.js"></script>
  </head>

  <body>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">CLOVA Chatbot Web Kit</a>
      </div>
    </nav>

        <div class="container">
          <h1 class>Hello, world!</h1>
          <p>
            CLOVA Chatbot is equipped with a powerful conversation model engine
            that applies Naver's data and know-how, so you can develop chatbots
            that satisfy various customer needs.
          </p>
          <p>
            <a class="btn btn-primary btn-open" role="button">Open Web Chat</a>
          </p>
        </div>

    <div id="chat"></div>
    <div id="chat-button">
      <svg
        stroke="currentColor"
        fill="currentColor"
        stroke-width="0"
        viewBox="0 0 16 16"
        height="1em"
        width="1em"
        xmlns="http://www.w3.org/2000/svg"
      >
        <path
          fill-rule="evenodd"
          d="M16 8c0 3.866-3.582 7-8 7a9.06 9.06 0 01-2.347-.306c-.584.296-1.925.864-4.181 1.234-.2.032-.352-.176-.273-.362.354-.836.674-1.95.77-2.966C.744 11.37 0 9.76 0 8c0-3.866 3.582-7 8-7s8 3.134 8 7zM5 8a1 1 0 11-2 0 1 1 0 012 0zm4 0a1 1 0 11-2 0 1 1 0 012 0zm3 1a1 1 0 100-2 1 1 0 000 2z"
          clip-rule="evenodd"
        ></path>
      </svg>
    </div>

  </body>
</html>