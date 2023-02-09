<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
  <head>
    <style>
      table {
        border-collapse: collapse;
        width: 90%;
        margin: 0 auto;
      }
      th, td {
        border: 1px solid black;
        padding: 8px;
        text-align: center;
      }
      th {
        background-color: #f2f2f2;
      }
    </style>
    <script>
      function showCalendar(month, year) {
        var table = document.getElementById("calendar-table");
        var months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
        document.getElementById("month-year").innerHTML = months[month] + " " + year;
        var date = new Date(year, month, 1);
        var daysInMonth = new Date(year, month + 1, 0).getDate();
        var firstDayOfMonth = date.getDay();
        for (var i = table.rows.length - 1; i > 1; i--) {
          table.deleteRow(i);
        }
        var row = table.insertRow();
        var cell = row.insertCell();
        cell.colSpan = firstDayOfMonth;
        for (var i = 1; i <= daysInMonth; i++) {
          if (cell.colSpan == 7) {
            row = table.insertRow();
            cell = row.insertCell();
          }
          cell.innerHTML = i;
          cell = row.insertCell();
        }
      }
    </script>
  </head>
  <body onload="showCalendar(new Date().getMonth(), new Date().getFullYear());">
    <h2 id="month-year" align="center"></h2>
    <table id="calendar-table">
      <tr>
        <th>Sun</th>
        <th>Mon</th>
        <th>Tue</th>
        <th>Wed</th>
        <th>Thu</th>
        <th>Fri</th>
        <th>Sat</th>
      </tr>
    </table>
  </body>
</html>

