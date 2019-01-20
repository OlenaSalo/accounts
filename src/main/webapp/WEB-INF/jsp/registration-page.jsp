<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>


<jsp:include page="app-header.jsp"/>

<div class="container">

    <div class="card" style="width: 30rem; padding: 20px; margin: 100px auto auto;">

       <jsp:include page="validation-error.jsp"/>

        <form action="/auth/register" method="post">
            <div class="form-group">
                <label for="register.firstName">First Name</label>
                <input type="firstName" class="form-control" id="register.firstName" name="firstName"
                       aria-describedby="firstNameHelp" placeholder="Enter firstName" required>
                <small id="firstNameHelp" class="form-text text-muted">We'll never share your first name with anyone
                    else.
                </small>
            </div>
            <div class="form-group">
                <label for="register.lastName">Last Name</label>
                <input type="lastName" class="form-control" id="register.lastName" name="lastName"
                       aria-describedby="lastNameHelp" placeholder="Enter lastName" required>
                <small id="lastNameHelp" class="form-text text-muted">We'll never share your last name with anyone
                    else.
                </small>
            </div>
            <div class="form-group">
                <label for="register.email">Email address</label>
                <input type="email" class="form-control" id="register.email" name="email"
                       aria-describedby="emailHelp" placeholder="Enter email" required>
                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.
                </small>
            </div>
            <div class="form-group">
                <label for="register.password">Password</label>
                <input type="password" class="form-control" id="register.password" name="password"
                       placeholder="Password" required>
            </div>
            <div class="form-group form-check">
                <input type="checkbox" class="form-check-input" id="register.rememberme" name="rememberMe">
                <label class="form-check-label" for="register.rememberme">Check me out</label>
            </div>
            <button type="submit"
                    id="register.submit"
                    class="btn btn-outline-secondary"
                    style="width: 100%">REGISTER</button>
        </form>
    </div>
</div>

</body>

</html>
