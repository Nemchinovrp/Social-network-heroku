<nav class="navbar navbar-default" style="background-color:#EDEEF0">
    <div class="navbar-form navbar-left">
        <ul class="nav navbar-nav">
            <li><a href="logout">Logout</a></li>
            <li><a href="friendsAction">Friend</a></li>
            <li><a href="groupsAction">Groups</a></li>
            <li><a href="edit">Edit</a></li>
            <li><a href="account">Home</a></li>
            <%--<li><a href="searchAjaxPage">Search page</a></li>--%>
        </ul>
    </div>
    <form class="navbar-form navbar-right" role="search" method="post" action="searchAction">
        <div class="form-group">
            <input type="search" id="search" class="form-control" name="search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</nav>




