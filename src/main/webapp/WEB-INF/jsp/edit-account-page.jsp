<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>

<jsp:include page="app-header.jsp"/>


<div class="container">


    <h1 class="display-4">
        <c:choose>
            <c:when test="${acc == null}">
                New account set up
            </c:when>
            <c:otherwise>
                ${acc.name}
            </c:otherwise>
        </c:choose>
        </h1>


    <div class="card" style="width: 100%; padding: 20px; margin: 20px auto auto;">

        <jsp:include page="validation-error.jsp"/>

        <form action="/accounts/edit" method="post">

            <div class="form-group">
                <label for="account.edit.code">Account Code</label>
                <input type="text" class="form-control"
                       id="account.edit.code"
                       name="accountCode"
                       value="${acc.code}"
                       aria-describedby="accountCodeHelp"
                       placeholder="Enter unique account code without spaces, e.g. sport-wear-account" required
                <c:if test="${acc!=null}">
                       readonly="readonly"
                </c:if>
                >
            </div>

            <div class="form-group">
                <label for="account.edit.name">Account Name</label>
                <input type="text" class="form-control"
                       id="account.edit.name"
                       name="accountName"
                       value="${acc.name}"
                       aria-describedby="accountNameHelp"
                       placeholder="Enter account name" required>
            </div>

            <div class="form-group">
                <label for="imgUrl">Image url</label>
                <input type="text"
                       class="form-control"
                       id="imgUrl"
                       name="accountImage"
                       value="${acc.img}"
                       aria-describedby="imgHelp"
                       placeholder="Enter account image url" required>
            </div>

            <div>
                <img id="accountImg" style="width: 200px; height: auto; margin-top: 50px"
                <c:choose>
                    <c:when test="${acc == null}">
                         src="http://www.ctejagroup.com/img/icon.png"
                    </c:when>
                    <c:otherwise>
                         src="${acc.img}"
                    </c:otherwise>
                </c:choose>

                >
            </div>

            <button type="submit"
                    id="account.edit.submit"
                    class="btn btn-outline-secondary"
                    style="width: 100%; margin-top: 50px">
                <c:choose>
                    <c:when test="${acc == null}">
                        CREATE
                    </c:when>
                    <c:otherwise>
                        UPDATE
                    </c:otherwise>
                </c:choose>
                ACCOUNT
            </button>

            <br>
            <a href="/">Back toAccount accounts</a>
        </form>


    </div>

</div>

<script>
    $("#imgUrl").change(function () {
        $("#accountImg").attr("src", $("#imgUrl").val());
    });
</script>