<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>


<jsp:include page="app-header.jsp"/>

<div class="container">

    <div class="card" style="width: 30rem; padding: 20px; margin: 100px auto auto;">

     <jsp:include page="validation-error.jsp" />

    <form action="/auth/login" method="post">
        <div class="form-group">
            <label for="login.email">Email address</label>
            <input type="email" class="form-control" id="login.email" name="email" aria-describedby="emailHelp" placeholder="Enter email" required>
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <label for="login.password">Password</label>
            <input type="password" class="form-control" id="login.password" name="password" placeholder="Password" required>
        </div>
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1" name="rememberMe">
            <label class="form-check-label" for="exampleCheck1">Check me out</label>
        </div>
        <button type="submit"
                class="btn btn-outline-secondary"
                id="login.submit"
                style="width: 100%">LOG IN</button>

        <br>
        <a href="/register">REGISTER</a>
    </form>
    </div>
</div>


</body>

</html>
