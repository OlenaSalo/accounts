<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<body>

<jsp:include page="app-header.jsp"/>

<div class="container">

    <h1 class="display-4">${sessionScope.user.firstName}'s accounts</h1>
    <table class="table">
        <thead>
        <tr>
            <th></th>
            <th scope="col">Code</th>
            <th scope="col">Account</th>
            <th scope="col">Balance</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${accounts}" var="acc">
            <tr id="home.accounts.${acc.code}">
                <th scope="row" style="text-align: center">
                    <img style="width: 70px; height: auto; margin: auto" src="<c:out value = "${acc.img}"/>">
                </th>
                <th id="" scope="row"><c:out value = "${acc.code}"/></th>
                <td id="home.accounts.${acc.code}.name"><c:out value = "${acc.name}"/></td>
                <td id="home.accounts.${acc.code}.balance"><c:out value = "${acc.balance}"/></td>
                <td id="home.accounts.${acc.code}.transactions"
                    style="text-align: center;"
                    onclick="window.location.href='/accounts/${acc.code}/transactions'" >
                    <img style="width: 25px; height: 25px; margin: auto; vertical-align: center"
                         src="https://cdn1.iconfinder.com/data/icons/finance-solid-icons-vol-1/48/035-512.png"/>
                </td>
                <td id="home.accounts.${acc.code}.edit"
                    style="text-align: center;"
                    onclick="window.location.href='/accounts/edit/${acc.code}'" >
                    <img style="width: 25px; height: 25px; margin: auto; vertical-align: center"
                         src="https://cdn0.iconfinder.com/data/icons/thin-essentials/57/thin-053_settings_gear_preferences-512.png"/>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

</div>

</body>

</html>
