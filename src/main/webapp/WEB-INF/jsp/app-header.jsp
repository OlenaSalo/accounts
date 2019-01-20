<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>

    <!-- Access the bootstrap Css like this,
        Spring boot will handle the resource mapping automcatically -->
    <link rel="stylesheet" type="text/css"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"/>

    <!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
    <c:url value="/css/main.css" var="jstlCss"/>
    <link href="${jstlCss}" rel="stylesheet"/>

</head>

<!-- Image and text -->
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="#">
        <img src="/img/home-page-accounts.png" width="30" height="30" class="d-inline-block align-top" alt="">
        <c:choose>
            <c:when test="${sessionScope.user.userRole!= 'GUEST'}">
                Hi, ${sessionScope.user.firstName}

                <div id="home.user.menu" class="dropdown justify-content-end">
                    <a class="btn btn-secondary dropdown-toggle " href="#" role="button" id="dropdownMenuLink"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Actions
                    </a>

                    <div class="dropdown-menu dropdown-menu-right " aria-labelledby="dropdownMenuLink">
                        <a class="dropdown-item" href="/accounts/edit/new">Add account</a>
                        <a class="dropdown-item" href="/transactions">Manage transactions</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/auth/logout">Logout</a>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                Accounts
            </c:otherwise>
        </c:choose>

    </a>
</nav>

<script
        src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>

<script type="text/javascript"
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.bundle.min.js"></script>
