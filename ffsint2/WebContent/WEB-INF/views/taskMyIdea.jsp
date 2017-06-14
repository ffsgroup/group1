<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <jsp:include page="_TaskHeader.jsp"></jsp:include>
            <title>Tasks</title>

            <link href = "https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel = "stylesheet">
            <script src="http://code.jquery.com/jquery-latest.min.js"></script> 
            <script src = "https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
            <link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>

            <script>
                $(document).ready(function () {
                    $("#taskIdeaSave").click(function (event) {
                        var temp1 = document.getElementById('taskMyIdeas').value;
                        $.get('TaskUpdateIdea',{myIdea1:document.getElementById('taskMyIdeas').value}, function (responseJson) {
                            if (responseJson != null) {
                                $.each(responseJson, function (key, value) {
                                    var t1 = value['GenericDescriptionEng'];                                 
                                    if (t1 == "success") {
                                        alert("saved success");
                                    } else {
                                        alert("failed");
                                    }
                                });
                            } 
                        });
                    });
                });

            </script>

        </head>

        <body>
            <div>
            <br>
            <label> <textarea id="taskMyIdeas" style="width:775px; height: 500px;">${myIdea}</textarea> </label> 
        <br>    
        <input type ="button" value ="Save" id="taskIdeaSave" style="margin-left:250px;width:75px;">
        </div>
    </body>
    <jsp:include page="_footer.jsp"></jsp:include>
</html>
