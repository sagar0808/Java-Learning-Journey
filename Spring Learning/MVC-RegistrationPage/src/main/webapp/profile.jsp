<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="in.master.model.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>

    <link rel="stylesheet" href="style.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
	<%
		User user = (User) session.getAttribute("sessionKey");
	%>
    <div class="profile-card">
        <div class="image">
            <img src="profileimage.jpg" alt="Profile-Picture" class="profile-img">
        </div>

        <div class="text-data">
            <span class="name"><%= user.getName() %></span>
            <span class="job">Student</span>
        </div>

        <div class="media-buttons">
            <a href="https://www.linkedin.com/in/sagar-ram-632528297" style="background: #174de2;" class="link">
                <i class='bx bxl-linkedin' ></i>
            </a>
            <a href="https://x.com/Master_thedev_" style="background: #3968e9;" class="link">
                <i class='bx bxl-twitter' ></i>
            </a>
            <a href="https://github.com/sagar0808" style="background: #f04040;" class="link">
                <i class='bx bxl-github' ></i>
            </a>
            <a href="#" style="background: #ff0000;" class="link">
                <i class='bx bxl-instagram' ></i>
            </a>
        </div>

        <div class="buttons">
            <button class="button">Subscribe</button>
            <button class="button">Message</button>
        </div>

        <div class="analtical-data">
            <div class="data">
                <i class='bx bx-like' ></i>
                <span class="number">60k</span>
            </div>
            <div class="data">
                <i class='bx bx-share' ></i>
                <span class="number">30k</span>
            </div>
            <div class="data">
                <i class='bx bx-comment' ></i>
                <span class="number">10k</span>
            </div>
        </div>
    </div>
</body>
</html>