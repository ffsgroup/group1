<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <link href = "https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel = "stylesheet">
        <script src="http://code.jquery.com/jquery-latest.min.js"></script> 
        <script src = "https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>        
        <jsp:include page="_MembersHeader.jsp"></jsp:include>
        </head>
        <body>
            <br> <br>
            <label style="font-size:18pt"> Member receipt issue</label> <br> <br>
            <table>   
                <tr>
                    <td>  Member nr : </td> <td> ${lidno} </td>
            </tr>
            <tr>
                <td>    Member name :</td> <td> ${name} </td>
            </tr>
            <tr>
                <td>   Premium : </td> <td> ${premium} </td>
            </tr> 
            <tr> <td> Credit </td>
                <td> ${credit} </td>
                
            </tr>
            <tr> <td> Paid until : </td>  <td>  ${bettot} </td>  
            </tr> 
            <tr> <td> Minimum payment </td>
                <td> ${amount}</td>
            </tr>  

        </table>
        <br>
        ${message1}
        <br> <br>
        <table>
            <tr>
                <td> Amount Paid </td> <td> <input type ="text" style="widht:80px;" id="ampaid" > </td>
            </tr>
            <tr> <td> Payer Name </td> <td> <input type= "text" size="20" id="payername" </td>
            </tr>
            <tr>
                <td> Relation </td>
                <td> <input type="text" size ="20" list="list1" id="payerrel" >
                    <datalist id="list1" >
                        <option value="Main Member" ></option>
                        <option value="Parent" ></option>
                        <option value="Child" ></option>
                        <option value="Spouse" ></option>
                        <option value="Neighbour" ></option>
                        <option value="Friend" ></option>                                
                    </datalist>
            </tr>
        </table>
        <br>
        <input type="button" value="Save" style="width:100px;margin-left:40px;" >
        <script>
            var a = ${canchange}
            if (a == "1") {
                document.getElementById("ampaid").value = ${amount};
                document.getElementById("ampaid").readOnly = true;
            }
            var b = ${status}
            if (b == "6") {
              document.getElementById("ampaid").value = "0";  
              document.getElementById("ampaid").readOnly = true;   
            } 
            if (b == "7") {
              document.getElementById("ampaid").value = "0";  
              document.getElementById("ampaid").readOnly = true;   
            }
            
        </script>

    </body>
</html>    