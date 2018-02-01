<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <link href = "https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel = "stylesheet">
        <script src="http://code.jquery.com/jquery-latest.min.js"></script> 
        <script src = "https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>        
        <jsp:include page="_MembersHeader.jsp"></jsp:include>
            <script src="http://java.com/js/deployJava.js"></script>
            <script>
                $(document).ready(function () {
                    $("#saverec").click(function (event) {
                        //         document.getElementById("message2").innerHTML = "Member will be asked to sign declaration"
                        str1 = document.getElementById("message2").innerHTML;
                        if (str1 == "Member will be asked to sign declaration") {
 //           window.location = "resources/signdec.jsp?member=" + document.getElementById("memno").innerHTML + "&amount=" + document.getElementById("payAmount").innerHTML;
 //           window.location = "MemSignDec.jsp?member=" + document.getElementById("memno").innerHTML + "&amount=" + document.getElementById("payAmount").innerHTML;
              window.location = "resources/launch.jnlp";
//  resources/launch.jnlp
                        } else {
//                             window.location = "resources/signdec.jsp?member=" + document.getElementById("memno").innerHTML + "&amount=" + document.getElementById("payAmount").innerHTML;
              window.location = "resources/launch.jnlp";
                        }
                    });
                });

            </script>    
        </head>
        <body>

        <br> <br>
        <label style="font-size:18pt"> Member receipt issue</label> <br> <br>
        <table>   
            <tr>
                <td>  Member nr : </td> <td> <label id ="memno" >${lidno}</label> </td>
        </tr>
        <tr>
            <td>    Member name :</td> <td> ${name} </td>
        </tr>
        <tr>
            <td>   Premium : </td> <td> <label id="premi" >${premium}</label> </td>
        </tr> 
        <tr> <td> Credit </td>
            <td> ${credit} </td>

        </tr>
        <tr> <td> Paid until : </td>  <td>  ${bettot} </td>  
        </tr> 
        <tr> <td> Minimum payment </td>
            <td> <label id="payAmount"> ${amount}</label> </td>
        </tr>  

    </table>
    <br>
    <label id="message2">${message1}</label>
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
    <input type="button" id="saverec" value="Save" style="width:100px;margin-left:40px;" >
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
    <br>
    start <br>
    <a href="resources/launch.jnlp" > sign </a>
    
        <br>
        end
   <a href="resources/launch1.jnlp " > sign-con </a>     
</body>
</html>    