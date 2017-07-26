<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="true" %>
<jsp:include page="_SecurityHeader.jsp"></jsp:include>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href = "https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel = "stylesheet">
        <script src="http://code.jquery.com/jquery-latest.min.js"></script> 
        <script src = "https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Security</title>

        <script>
            
            $(document).ready(function () {
                $("#securityUpdate").click(function (event) {            
              var a="";
              if (document.getElementById("sec1").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec2").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0"; 
              }
              if (document.getElementById("sec3").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec4").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec5").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec6").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec7").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec8").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec9").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec10").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec11").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec12").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec13").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec14").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec15").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec16").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec17").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec18").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec19").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec20").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec21").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec22").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec23").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec24").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec25").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec26").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec27").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec28").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec29").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec30").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec31").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec32").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec33").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec34").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec35").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec36").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec37").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec38").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec39").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec40").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec41").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec42").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec43").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec44").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec45").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec46").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec47").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec48").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec49").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec50").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec51").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec52").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec53").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec54").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec55").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec56").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec57").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec58").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec59").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec60").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec61").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec62").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec63").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec64").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec65").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec66").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec67").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec68").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec69").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec70").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec71").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec72").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec73").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec74").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec75").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec76").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec77").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec78").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec79").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec80").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec81").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec82").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec83").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec84").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec85").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec86").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec87").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec88").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec89").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec90").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec91").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec92").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec93").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec94").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec95").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec96").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec97").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec98").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec99").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec100").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
if (document.getElementById("sec101").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec102").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec103").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec104").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec105").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec106").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec107").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec108").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec109").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec110").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec111").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec112").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec113").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec114").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec115").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec116").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec117").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec118").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec119").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec120").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec121").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec122").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec123").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec124").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec125").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec126").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec127").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec128").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec129").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec130").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec131").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
                            if (document.getElementById("sec132").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec133").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec134").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec135").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
if (document.getElementById("sec136").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec137").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec138").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec139").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec140").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              
              if (document.getElementById("sec141").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec142").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec143").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec144").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec145").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec146").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec147").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec148").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec149").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              if (document.getElementById("sec150").checked == true) {
                  a = a+"1";
              } else {
                  a=a+"0";
              }
              
                    $.get('SecurityUpdateUser', {name: document.getElementById("username").innerHTML ,secure:a}, function (responseJson) {
                        if (responseJson != null) {
                            $.each(responseJson, function (key, value) {
                                if (value["GenericDescriptionEng"] == "success") {
                                    document.getElementById("newname").value = "";
                                    document.getElementById("newuser").value = "";
                                    alert("User was updated.");
                                } else {
                                    alert("An error ocurred. This user was not updated");
                                }
                            });
                        }
                    });
                    //     }
                });
            });
            
            $(document).ready(function () {
                $("#logoff").click(function (event) {
                    if (document.getElementById("username").innerHTML.length > 1) {
                        //        if (document.getElementById("newname").value.length > 5 && document.getElementById("newuser").value.length > 5 && document.getElementById("newbranch").value.length > 5 ) {
                        $.get('SecurityLogoff', {name: document.getElementById("username").innerHTML}, function (responseJson) {
                            if (responseJson != null) {
                                $.each(responseJson, function (key, value) {
                                    if (value["GenericDescriptionEng"] == "success") {
                                        document.getElementById("newpass").value = "";
                                        alert("User logged off.");
                                    } else {
                                        alert("An error ocurred. User not logged off. " + value["GenericDescriptionEng"]);
                                    }
                                });
                            }
                        });

                    } else {
                        alert('Select user first');
                    }

                });
            });

            $(document).ready(function () {
                $("#changepass").click(function (event) {
                    if (document.getElementById("username").innerHTML.length > 1) {
                        //        if (document.getElementById("newname").value.length > 5 && document.getElementById("newuser").value.length > 5 && document.getElementById("newbranch").value.length > 5 ) {
                        $.get('SecurityChangePass', {name: document.getElementById("username").innerHTML, passw: document.getElementById("newpass").value}, function (responseJson) {
                            if (responseJson != null) {
                                $.each(responseJson, function (key, value) {
                                    if (value["GenericDescriptionEng"] == "success") {
                                        document.getElementById("newpass").value = "";
                                        alert("Password changed.");
                                    } else {
                                        alert("An error ocurred. Password not changed. " + value["GenericDescriptionEng"]);
                                    }
                                });
                            }
                        });

                    } else {
                        alert('Select user first');
                    }

                });
            });


            $(document).ready(function () {
                $("#deleteuser").click(function (event) {
                    //        if (document.getElementById("newname").value.length > 5 && document.getElementById("newuser").value.length > 5 && document.getElementById("newbranch").value.length > 5 ) {
                    $.get('SecurityDelUser', {name: document.getElementById("deluser").value}, function (responseJson) {
                        if (responseJson != null) {
                            $.each(responseJson, function (key, value) {
                                if (value["GenericDescriptionEng"] == "success") {
                                    document.getElementById("deluser").value = "";
                                    alert("User was deleted.");
                                } else {
                                    alert("An error ocurred. This user was not deleted");
                                }
                            });
                        }
                    });
                    //     }
                });
            });

            $(document).ready(function () {
                $("#createuser").click(function (event) {
                    //        if (document.getElementById("newname").value.length > 5 && document.getElementById("newuser").value.length > 5 && document.getElementById("newbranch").value.length > 5 ) {
                    $.get('SecurityNewUser', {name: document.getElementById("newname").value, user: document.getElementById("newuser").value, branch: document.getElementById("newbranch").value}, function (responseJson) {
                        if (responseJson != null) {
                            $.each(responseJson, function (key, value) {
                                if (value["GenericDescriptionEng"] == "success") {
                                    document.getElementById("newname").value = "";
                                    document.getElementById("newuser").value = "";
                                    alert("User was created.");
                                } else {
                                    alert("An error ocurred. This user was not created");
                                }
                            });
                        }
                    });
                    //     }
                });
            });

            function loadMemberDel() {
                var count = $("#deluser option").length;
                if (count.valueOf() < 1) {
                    $.get('SecurityGetAllUser', function (responseJson) {
                        if (responseJson != null) {
                            $.each(responseJson, function (key, value) {
                                $('#deluser').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                            });
                        }
                    });
                }
            }

            function newMemberBranch() {
                var count = $("#newbranch option").length;
                if (count.valueOf() < 1) {
                    $.get('SecurityGetBranch', function (responseJson) {
                        if (responseJson != null) {
                            $.each(responseJson, function (key, value) {
                                $('#newbranch').append('<option value="' + value['GenericDescriptionEng'] + '">' + value['GenericDescriptionEng'] + '</option>');
                            });
                        }
                    });
                }
            }

            $(document).ready(function () {
                $("#countrytable").click(function (event) {
                    var target = $(event.target);
                    $td = target.closest('td');
                    var col = $td.index();
                    var row = $td.closest('tr').index();

                    $.get('SecurityGetUser', {tranid: document.getElementById("countrytable").rows[row + 1].cells[3].innerHTML}, function (responseJson) {
                        if (responseJson != null) {
                            $.each(responseJson, function (key, value) {
                                document.getElementById("username").innerHTML = value['userName'];
                                document.getElementById("userid").innerHTML = value['tranid'];
                                if (value['securestr'].substring(3, 4) == "1") {
                                    document.getElementById("sec4").checked = true;
                                } else {
                                    document.getElementById("sec4").checked = false;
                                }
                                if (value['securestr'].substring(9, 10) == "1") {
                                    document.getElementById("sec10").checked = true;
                                } else {
                                    document.getElementById("sec10").checked = false;
                                }
                                if (value['securestr'].substring(4, 5) == "1") {
                                    document.getElementById("sec5").checked = true;
                                } else {
                                    document.getElementById("sec5").checked = false;
                                }
                                if (value['securestr'].substring(41, 42) == "1") {
                                    document.getElementById("sec42").checked = true;
                                } else {
                                    document.getElementById("sec42").checked = false;
                                }
                                if (value['securestr'].substring(43, 44) == "1") {
                                    document.getElementById("sec44").checked = true;
                                } else {
                                    document.getElementById("sec44").checked = false;
                                }
                                if (value['securestr'].substring(2, 3) == "1") {
                                    document.getElementById("sec3").checked = true;
                                } else {
                                    document.getElementById("sec3").checked = false;
                                }
                                if (value['securestr'].substring(1, 2) == "1") {
                                    document.getElementById("sec2").checked = true;
                                } else {
                                    document.getElementById("sec2").checked = false;
                                }
                                if (value['securestr'].substring(70, 71) == "1") {
                                    document.getElementById("sec71").checked = true;
                                } else {
                                    document.getElementById("sec71").checked = false;
                                }
                                if (value['securestr'].substring(10, 11) == "1") {
                                    document.getElementById("sec11").checked = true;
                                } else {
                                    document.getElementById("sec11").checked = false;
                                }
                                if (value['securestr'].substring(11, 12) == "1") {
                                    document.getElementById("sec12").checked = true;
                                } else {
                                    document.getElementById("sec12").checked = false;
                                }
                                if (value['securestr'].substring(45, 46) == "1") {
                                    document.getElementById("sec46").checked = true;
                                } else {
                                    document.getElementById("sec46").checked = false;
                                }
                                if (value['securestr'].substring(42, 43) == "1") {
                                    document.getElementById("sec43").checked = true;
                                } else {
                                    document.getElementById("sec43").checked = false;
                                }
                                if (value['securestr'].substring(15, 16) == "1") {
                                    document.getElementById("sec16").checked = true;
                                } else {
                                    document.getElementById("sec16").checked = false;
                                }
                                if (value['securestr'].substring(7, 8) == "1") {
                                    document.getElementById("sec8").checked = true;
                                } else {
                                    document.getElementById("sec8").checked = false;
                                }
                                if (value['securestr'].substring(71, 72) == "1") {
                                    document.getElementById("sec72").checked = true;
                                } else {
                                    document.getElementById("sec72").checked = false;
                                }
                                if (value['securestr'].substring(72, 73) == "1") {
                                    document.getElementById("sec73").checked = true;
                                } else {
                                    document.getElementById("sec73").checked = false;
                                }
                                if (value['securestr'].substring(58, 59) == "1") {
                                    document.getElementById("sec59").checked = true;
                                } else {
                                    document.getElementById("sec59").checked = false;
                                }
                                if (value['securestr'].substring(59, 60) == "1") {
                                    document.getElementById("sec60").checked = true;
                                } else {
                                    document.getElementById("sec60").checked = false;
                                }
                                if (value['securestr'].substring(60, 61) == "1") {
                                    document.getElementById("sec61").checked = true;
                                } else {
                                    document.getElementById("sec61").checked = false;
                                }
                                if (value['securestr'].substring(61, 62) == "1") {
                                    document.getElementById("sec62").checked = true;
                                } else {
                                    document.getElementById("sec62").checked = false;
                                }
                                if (value['securestr'].substring(67, 68) == "1") {
                                    document.getElementById("sec68").checked = true;
                                } else {
                                    document.getElementById("sec68").checked = false;
                                }
                                if (value['securestr'].substring(73, 74) == "1") {
                                    document.getElementById("sec74").checked = true;
                                } else {
                                    document.getElementById("sec74").checked = false;
                                }
                                if (value['securestr'].substring(76, 77) == "1") {
                                    document.getElementById("sec77").checked = true;
                                } else {
                                    document.getElementById("sec77").checked = false;
                                }
                                if (value['securestr'].substring(77, 78) == "1") {
                                    document.getElementById("sec78").checked = true;
                                } else {
                                    document.getElementById("sec78").checked = false;
                                }
                                if (value['securestr'].substring(102, 103) == "1") {
                                    document.getElementById("sec103").checked = true;
                                } else {
                                    document.getElementById("sec103").checked = false;
                                }
                                if (value['securestr'].substring(103, 104) == "1") {
                                    document.getElementById("sec104").checked = true;
                                } else {
                                    document.getElementById("sec104").checked = false;
                                }
                                if (value['securestr'].substring(126, 127) == "1") {
                                    document.getElementById("sec127").checked = true;
                                } else {
                                    document.getElementById("sec127").checked = false;
                                }
                                if (value['securestr'].substring(147, 148) == "1") {
                                    document.getElementById("sec148").checked = true;
                                } else {
                                    document.getElementById("sec148").checked = false;
                                }
                                if (value['taskenq'] == "Y") {
                                    document.getElementById("taskenq").checked = true;
                                } else {
                                    document.getElementById("taskenq").checked = false;
                                }
                                if (value['taskclaim'] == "Y") {
                                    document.getElementById("taskclaim").checked = true;
                                } else {
                                    document.getElementById("taskclaim").checked = false;
                                }
                                if (value['taskpay'] == "Y") {
                                    document.getElementById("taskpay").checked = true;
                                } else {
                                    document.getElementById("taskpay").checked = false;
                                }
                                if (value['securestr'].substring(34, 35) == "1") {
                                    document.getElementById("sec35").checked = true;
                                } else {
                                    document.getElementById("sec35").checked = false;
                                }
                                if (value['securestr'].substring(33, 34) == "1") {
                                    document.getElementById("sec34").checked = true;
                                } else {
                                    document.getElementById("sec34").checked = false;
                                }
                                if (value['securestr'].substring(6, 7) == "1") {
                                    document.getElementById("sec7").checked = true;
                                } else {
                                    document.getElementById("sec7").checked = false;
                                }
                                if (value['securestr'].substring(5, 6) == "1") {
                                    document.getElementById("sec6").checked = true;
                                } else {
                                    document.getElementById("sec6").checked = false;
                                }
                                if (value['securestr'].substring(13, 14) == "1") {
                                    document.getElementById("sec14").checked = true;
                                } else {
                                    document.getElementById("sec14").checked = false;
                                }
                                if (value['securestr'].substring(14, 15) == "1") {
                                    document.getElementById("sec15").checked = true;
                                } else {
                                    document.getElementById("sec15").checked = false;
                                }
                                if (value['securestr'].substring(26, 27) == "1") {
                                    document.getElementById("sec27").checked = true;
                                } else {
                                    document.getElementById("sec27").checked = false;
                                }
                                if (value['securestr'].substring(25, 26) == "1") {
                                    document.getElementById("sec26").checked = true;
                                } else {
                                    document.getElementById("sec26").checked = false;
                                }
                                if (value['securestr'].substring(24, 25) == "1") {
                                    document.getElementById("sec25").checked = true;
                                } else {
                                    document.getElementById("sec25").checked = false;
                                }
                                if (value['securestr'].substring(23, 24) == "1") {
                                    document.getElementById("sec24").checked = true;
                                } else {
                                    document.getElementById("sec24").checked = false;
                                }
                                if (value['securestr'].substring(22, 23) == "1") {
                                    document.getElementById("sec23").checked = true;
                                } else {
                                    document.getElementById("sec23").checked = false;
                                }
                                if (value['securestr'].substring(74, 75) == "1") {
                                    document.getElementById("sec75").checked = true;
                                } else {
                                    document.getElementById("sec75").checked = false;
                                }
                                if (value['securestr'].substring(81, 82) == "1") {
                                    document.getElementById("sec82").checked = true;
                                } else {
                                    document.getElementById("sec82").checked = false;
                                }
                                if (value['securestr'].substring(35, 36) == "1") {
                                    document.getElementById("sec36").checked = true;
                                } else {
                                    document.getElementById("sec36").checked = false;
                                }
                                if (value['securestr'].substring(37, 38) == "1") {
                                    document.getElementById("sec38").checked = true;
                                } else {
                                    document.getElementById("sec38").checked = false;
                                }
                                if (value['securestr'].substring(36, 37) == "1") {
                                    document.getElementById("sec37").checked = true;
                                } else {
                                    document.getElementById("sec37").checked = false;
                                }
                                if (value['securestr'].substring(62, 63) == "1") {
                                    document.getElementById("sec63").checked = true;
                                } else {
                                    document.getElementById("sec63").checked = false;
                                }
                                if (value['securestr'].substring(63, 64) == "1") {
                                    document.getElementById("sec64").checked = true;
                                } else {
                                    document.getElementById("sec64").checked = false;
                                }
                                if (value['securestr'].substring(64, 65) == "1") {
                                    document.getElementById("sec65").checked = true;
                                } else {
                                    document.getElementById("sec65").checked = false;
                                }
                                if (value['securestr'].substring(65, 66) == "1") {
                                    document.getElementById("sec66").checked = true;
                                } else {
                                    document.getElementById("sec66").checked = false;
                                }
                                if (value['securestr'].substring(66, 67) == "1") {
                                    document.getElementById("sec67").checked = true;
                                } else {
                                    document.getElementById("sec67").checked = false;
                                }
                                if (value['securestr'].substring(133, 134) == "1") {
                                    document.getElementById("sec134").checked = true;
                                } else {
                                    document.getElementById("sec134").checked = false;
                                }
                                if (value['securestr'].substring(84, 85) == "1") {
                                    document.getElementById("sec85").checked = true;
                                } else {
                                    document.getElementById("sec85").checked = false;
                                }
                                if (value['securestr'].substring(85, 86) == "1") {
                                    document.getElementById("sec86").checked = true;
                                } else {
                                    document.getElementById("sec86").checked = false;
                                }
                                if (value['securestr'].substring(86, 87) == "1") {
                                    document.getElementById("sec87").checked = true;
                                } else {
                                    document.getElementById("sec87").checked = false;
                                }
                                if (value['securestr'].substring(87, 88) == "1") {
                                    document.getElementById("sec88").checked = true;
                                } else {
                                    document.getElementById("sec88").checked = false;
                                }
                                if (value['securestr'].substring(97, 98) == "1") {
                                    document.getElementById("sec98").checked = true;
                                } else {
                                    document.getElementById("sec98").checked = false;
                                }
                                if (value['securestr'].substring(88, 89) == "1") {
                                    document.getElementById("sec89").checked = true;
                                } else {
                                    document.getElementById("sec89").checked = false;
                                }
                                if (value['securestr'].substring(89, 90) == "1") {
                                    document.getElementById("sec90").checked = true;
                                } else {
                                    document.getElementById("sec90").checked = false;
                                }
                                if (value['securestr'].substring(90, 91) == "1") {
                                    document.getElementById("sec91").checked = true;
                                } else {
                                    document.getElementById("sec91").checked = false;
                                }
                                if (value['securestr'].substring(91, 92) == "1") {
                                    document.getElementById("sec92").checked = true;
                                } else {
                                    document.getElementById("sec92").checked = false;
                                }
                                if (value['securestr'].substring(92, 93) == "1") {
                                    document.getElementById("sec93").checked = true;
                                } else {
                                    document.getElementById("sec93").checked = false;
                                }
                                if (value['securestr'].substring(93, 94) == "1") {
                                    document.getElementById("sec94").checked = true;
                                } else {
                                    document.getElementById("sec94").checked = false;
                                }
                                if (value['securestr'].substring(94, 95) == "1") {
                                    document.getElementById("sec95").checked = true;
                                } else {
                                    document.getElementById("sec95").checked = false;
                                }
                                if (value['securestr'].substring(95, 96) == "1") {
                                    document.getElementById("sec96").checked = true;
                                } else {
                                    document.getElementById("sec96").checked = false;
                                }
                                if (value['securestr'].substring(96, 97) == "1") {
                                    document.getElementById("sec97").checked = true;
                                } else {
                                    document.getElementById("sec97").checked = false;
                                }
                                if (value['securestr'].substring(98, 99) == "1") {
                                    document.getElementById("sec99").checked = true;
                                } else {
                                    document.getElementById("sec99").checked = false;
                                }
                                if (value['securestr'].substring(105, 106) == "1") {
                                    document.getElementById("sec106").checked = true;
                                } else {
                                    document.getElementById("sec106").checked = false;
                                }
                                if (value['securestr'].substring(46, 47) == "1") {
                                    document.getElementById("sec47").checked = true;
                                } else {
                                    document.getElementById("sec47").checked = false;
                                }
                                if (value['securestr'].substring(40, 41) == "1") {
                                    document.getElementById("sec41").checked = true;
                                } else {
                                    document.getElementById("sec41").checked = false;
                                }
                                if (value['securestr'].substring(39, 40) == "1") {
                                    document.getElementById("sec40").checked = true;
                                } else {
                                    document.getElementById("sec40").checked = false;
                                }
                                if (value['securestr'].substring(38, 39) == "1") {
                                    document.getElementById("sec39").checked = true;
                                } else {
                                    document.getElementById("sec39").checked = false;
                                }
                                if (value['securestr'].substring(8, 9) == "1") {
                                    document.getElementById("sec9").checked = true;
                                } else {
                                    document.getElementById("sec9").checked = false;
                                }
                                if (value['securestr'].substring(112, 113) == "1") {
                                    document.getElementById("sec113").checked = true;
                                } else {
                                    document.getElementById("sec113").checked = false;
                                }
                                if (value['securestr'].substring(16, 17) == "1") {
                                    document.getElementById("sec17").checked = true;
                                } else {
                                    document.getElementById("sec17").checked = false;
                                }
                                if (value['securestr'].substring(17, 18) == "1") {
                                    document.getElementById("sec18").checked = true;
                                } else {
                                    document.getElementById("sec18").checked = false;
                                }
                                if (value['securestr'].substring(18, 19) == "1") {
                                    document.getElementById("sec19").checked = true;
                                } else {
                                    document.getElementById("sec19").checked = false;
                                }
                                if (value['securestr'].substring(120, 121) == "1") {
                                    document.getElementById("sec121").checked = true;
                                } else {
                                    document.getElementById("sec121").checked = false;
                                }
                                if (value['securestr'].substring(121, 122) == "1") {
                                    document.getElementById("sec122").checked = true;
                                } else {
                                    document.getElementById("sec122").checked = false;
                                }
                                if (value['securestr'].substring(51, 52) == "1") {
                                    document.getElementById("sec52").checked = true;
                                } else {
                                    document.getElementById("sec52").checked = false;
                                }
                                if (value['securestr'].substring(52, 53) == "1") {
                                    document.getElementById("sec53").checked = true;
                                } else {
                                    document.getElementById("sec53").checked = false;
                                }
                                if (value['securestr'].substring(57, 58) == "1") {
                                    document.getElementById("sec58").checked = true;
                                } else {
                                    document.getElementById("sec58").checked = false;
                                }
                                if (value['securestr'].substring(122, 123) == "1") {
                                    document.getElementById("sec123").checked = true;
                                } else {
                                    document.getElementById("sec123").checked = false;
                                }
                                if (value['securestr'].substring(123, 124) == "1") {
                                    document.getElementById("sec124").checked = true;
                                } else {
                                    document.getElementById("sec124").checked = false;
                                }
                                if (value['securestr'].substring(21, 22) == "1") {
                                    document.getElementById("sec22").checked = true;
                                } else {
                                    document.getElementById("sec22").checked = false;
                                }
                                if (value['securestr'].substring(20, 21) == "1") {
                                    document.getElementById("sec21").checked = true;
                                } else {
                                    document.getElementById("sec21").checked = false;
                                }
                                if (value['securestr'].substring(19, 20) == "1") {
                                    document.getElementById("sec20").checked = true;
                                } else {
                                    document.getElementById("sec20").checked = false;
                                }
                                if (value['securestr'].substring(48, 49) == "1") {
                                    document.getElementById("sec49").checked = true;
                                } else {
                                    document.getElementById("sec49").checked = false;
                                }
                                if (value['securestr'].substring(47, 48) == "1") {
                                    document.getElementById("sec48").checked = true;
                                } else {
                                    document.getElementById("sec48").checked = false;
                                }
                                if (value['securestr'].substring(56, 57) == "1") {
                                    document.getElementById("sec57").checked = true;
                                } else {
                                    document.getElementById("sec57").checked = false;
                                }
                                if (value['securestr'].substring(104, 105) == "1") {
                                    document.getElementById("sec105").checked = true;
                                } else {
                                    document.getElementById("sec105").checked = false;
                                }
                                if (value['securestr'].substring(148, 149) == "1") {
                                    document.getElementById("sec149").checked = true;
                                } else {
                                    document.getElementById("sec149").checked = false;
                                }
                                if (value['securestr'].substring(49, 50) == "1") {
                                    document.getElementById("sec50").checked = true;
                                } else {
                                    document.getElementById("sec50").checked = false;
                                }
                                if (value['securestr'].substring(12, 13) == "1") {
                                    document.getElementById("sec13").checked = true;
                                } else {
                                    document.getElementById("sec13").checked = false;
                                }
                                if (value['securestr'].substring(0, 1) == "1") {
                                    document.getElementById("sec1").checked = true;
                                } else {
                                    document.getElementById("sec1").checked = false;
                                }
                                if (value['securestr'].substring(44, 45) == "1") {
                                    document.getElementById("sec45").checked = true;
                                } else {
                                    document.getElementById("sec45").checked = false;
                                }
                                if (value['securestr'].substring(108, 109) == "1") {
                                    document.getElementById("sec109").checked = true;
                                } else {
                                    document.getElementById("sec109").checked = false;
                                }
                                if (value['securestr'].substring(79, 80) == "1") {
                                    document.getElementById("sec80").checked = true;
                                } else {
                                    document.getElementById("sec80").checked = false;
                                }
                                if (value['securestr'].substring(78, 79) == "1") {
                                    document.getElementById("sec79").checked = true;
                                } else {
                                    document.getElementById("sec79").checked = false;
                                }
                                if (value['securestr'].substring(50, 51) == "1") {
                                    document.getElementById("sec51").checked = true;
                                } else {
                                    document.getElementById("sec51").checked = false;
                                }
                                if (value['securestr'].substring(53, 54) == "1") {
                                    document.getElementById("sec54").checked = true;
                                } else {
                                    document.getElementById("sec54").checked = false;
                                }
                                if (value['securestr'].substring(54, 55) == "1") {
                                    document.getElementById("sec55").checked = true;
                                } else {
                                    document.getElementById("sec55").checked = false;
                                }
                                if (value['securestr'].substring(55, 56) == "1") {
                                    document.getElementById("sec56").checked = true;
                                } else {
                                    document.getElementById("sec56").checked = false;
                                }
                                if (value['securestr'].substring(100, 101) == "1") {
                                    document.getElementById("sec101").checked = true;
                                } else {
                                    document.getElementById("sec101").checked = false;
                                }
                                if (value['securestr'].substring(107, 108) == "1") {
                                    document.getElementById("sec108").checked = true;
                                } else {
                                    document.getElementById("sec108").checked = false;
                                }
                                if (value['securestr'].substring(68, 69) == "1") {
                                    document.getElementById("sec69").checked = true;
                                } else {
                                    document.getElementById("sec69").checked = false;
                                }
                                if (value['securestr'].substring(69, 70) == "1") {
                                    document.getElementById("sec70").checked = true;
                                } else {
                                    document.getElementById("sec70").checked = false;
                                }
                                if (value['securestr'].substring(75, 76) == "1") {
                                    document.getElementById("sec76").checked = true;
                                } else {
                                    document.getElementById("sec76").checked = false;
                                }
                                if (value['securestr'].substring(80, 81) == "1") {
                                    document.getElementById("sec81").checked = true;
                                } else {
                                    document.getElementById("sec81").checked = false;
                                }
                                if (value['securestr'].substring(82, 83) == "1") {
                                    document.getElementById("sec83").checked = true;
                                } else {
                                    document.getElementById("sec83").checked = false;
                                }
                                if (value['securestr'].substring(109, 110) == "1") {
                                    document.getElementById("sec110").checked = true;
                                } else {
                                    document.getElementById("sec110").checked = false;
                                }
                                if (value['securestr'].substring(111, 112) == "1") {
                                    document.getElementById("sec112").checked = true;
                                } else {
                                    document.getElementById("sec112").checked = false;
                                }
                                if (value['securestr'].substring(127, 128) == "1") {
                                    document.getElementById("sec128").checked = true;
                                } else {
                                    document.getElementById("sec128").checked = false;
                                }
                                if (value['securestr'].substring(141, 142) == "1") {
                                    document.getElementById("sec142").checked = true;
                                } else {
                                    document.getElementById("sec142").checked = false;
                                }
                                if (value['securestr'].substring(143, 144) == "1") {
                                    document.getElementById("sec144").checked = true;
                                } else {
                                    document.getElementById("sec144").checked = false;
                                }
                                if (value['securestr'].substring(145, 146) == "1") {
                                    document.getElementById("sec146").checked = true;
                                } else {
                                    document.getElementById("sec146").checked = false;
                                }
                                if (value['securestr'].substring(32, 33) == "1") {
                                    document.getElementById("sec33").checked = true;
                                } else {
                                    document.getElementById("sec33").checked = false;
                                }
                                if (value['securestr'].substring(31, 32) == "1") {
                                    document.getElementById("sec32").checked = true;
                                } else {
                                    document.getElementById("sec32").checked = false;
                                }
                                if (value['securestr'].substring(30, 31) == "1") {
                                    document.getElementById("sec31").checked = true;
                                } else {
                                    document.getElementById("sec31").checked = false;
                                }
                                if (value['securestr'].substring(29, 30) == "1") {
                                    document.getElementById("sec30").checked = true;
                                } else {
                                    document.getElementById("sec30").checked = false;
                                }
                                if (value['securestr'].substring(28, 29) == "1") {
                                    document.getElementById("sec29").checked = true;
                                } else {
                                    document.getElementById("sec29").checked = false;
                                }
                                if (value['securestr'].substring(27, 28) == "1") {
                                    document.getElementById("sec28").checked = true;
                                } else {
                                    document.getElementById("sec28").checked = false;
                                }
                                if (value['securestr'].substring(99, 100) == "1") {
                                    document.getElementById("sec100").checked = true;
                                } else {
                                    document.getElementById("sec100").checked = false;
                                }
                                if (value['securestr'].substring(101, 102) == "1") {
                                    document.getElementById("sec102").checked = true;
                                } else {
                                    document.getElementById("sec102").checked = false;
                                }
                                if (value['securestr'].substring(106, 107) == "1") {
                                    document.getElementById("sec107").checked = true;
                                } else {
                                    document.getElementById("sec107").checked = false;
                                }
                                if (value['securestr'].substring(110, 111) == "1") {
                                    document.getElementById("sec111").checked = true;
                                } else {
                                    document.getElementById("sec111").checked = false;
                                }
                                if (value['securestr'].substring(128, 129) == "1") {
                                    document.getElementById("sec129").checked = true;
                                } else {
                                    document.getElementById("sec129").checked = false;
                                }
                                if (value['securestr'].substring(113, 114) == "1") {
                                    document.getElementById("sec114").checked = true;
                                } else {
                                    document.getElementById("sec114").checked = false;
                                }
                                if (value['securestr'].substring(114, 115) == "1") {
                                    document.getElementById("sec115").checked = true;
                                } else {
                                    document.getElementById("sec115").checked = false;
                                }
                                if (value['securestr'].substring(115, 116) == "1") {
                                    document.getElementById("sec116").checked = true;
                                } else {
                                    document.getElementById("sec116").checked = false;
                                }
                                if (value['securestr'].substring(116, 117) == "1") {
                                    document.getElementById("sec117").checked = true;
                                } else {
                                    document.getElementById("sec117").checked = false;
                                }
                                if (value['securestr'].substring(117, 118) == "1") {
                                    document.getElementById("sec118").checked = true;
                                } else {
                                    document.getElementById("sec118").checked = false;
                                }
                                if (value['securestr'].substring(118, 119) == "1") {
                                    document.getElementById("sec119").checked = true;
                                } else {
                                    document.getElementById("sec119").checked = false;
                                }
                                if (value['securestr'].substring(135, 136) == "1") {
                                    document.getElementById("sec136").checked = true;
                                } else {
                                    document.getElementById("sec136").checked = false;
                                }
                                if (value['securestr'].substring(136, 137) == "1") {
                                    document.getElementById("sec137").checked = true;
                                } else {
                                    document.getElementById("sec137").checked = false;
                                }
                                if (value['securestr'].substring(119, 120) == "1") {
                                    document.getElementById("sec120").checked = true;
                                } else {
                                    document.getElementById("sec120").checked = false;
                                }
                                if (value['securestr'].substring(124, 125) == "1") {
                                    document.getElementById("sec125").checked = true;
                                } else {
                                    document.getElementById("sec125").checked = false;
                                }
                                if (value['securestr'].substring(83, 84) == "1") {
                                    document.getElementById("sec84").checked = true;
                                } else {
                                    document.getElementById("sec84").checked = false;
                                }
                                if (value['securestr'].substring(125, 126) == "1") {
                                    document.getElementById("sec126").checked = true;
                                } else {
                                    document.getElementById("sec126").checked = false;
                                }
                                if (value['securestr'].substring(129, 130) == "1") {
                                    document.getElementById("sec130").checked = true;
                                } else {
                                    document.getElementById("sec130").checked = false;
                                }
                                if (value['securestr'].substring(130, 131) == "1") {
                                    document.getElementById("sec131").checked = true;
                                } else {
                                    document.getElementById("sec131").checked = false;
                                }
                                if (value['securestr'].substring(137, 138) == "1") {
                                    document.getElementById("sec138").checked = true;
                                } else {
                                    document.getElementById("sec138").checked = false;
                                }
                                if (value['securestr'].substring(138, 139) == "1") {
                                    document.getElementById("sec139").checked = true;
                                } else {
                                    document.getElementById("sec139").checked = false;
                                }
                                if (value['securestr'].substring(131, 132) == "1") {
                                    document.getElementById("sec132").checked = true;
                                } else {
                                    document.getElementById("sec132").checked = false;
                                }
                                if (value['securestr'].substring(132, 133) == "1") {
                                    document.getElementById("sec133").checked = true;
                                } else {
                                    document.getElementById("sec133").checked = false;
                                }
                                if (value['securestr'].substring(133, 134) == "1") {
                                    document.getElementById("sec134").checked = true;
                                } else {
                                    document.getElementById("sec134").checked = false;
                                }
                                if (value['securestr'].substring(139, 140) == "1") {
                                    document.getElementById("sec140").checked = true;
                                } else {
                                    document.getElementById("sec140").checked = false;
                                }
                                if (value['securestr'].substring(140, 141) == "1") {
                                    document.getElementById("sec141").checked = true;
                                } else {
                                    document.getElementById("sec141").checked = false;
                                }
                                if (value['securestr'].substring(142, 143) == "1") {
                                    document.getElementById("sec143").checked = true;
                                } else {
                                    document.getElementById("sec143").checked = false;
                                }
                                if (value['securestr'].substring(144, 145) == "1") {
                                    document.getElementById("sec145").checked = true;
                                } else {
                                    document.getElementById("sec145").checked = false;
                                }
                                if (value['securestr'].substring(146, 147) == "1") {
                                    document.getElementById("sec147").checked = true;
                                } else {
                                    document.getElementById("sec147").checked = false;
                                }
                                if (value['securestr'].substring(149, 150) == "1") {
                                    document.getElementById("sec150").checked = true;
                                } else {
                                    document.getElementById("sec150").checked = false;
                                }

                            });

                        }
                    });
                });
            });

        </script>                 


        <style type="text/css">
            html {
                font-family: verdana;
                font-size: 10pt;
                line-height: 25px;
            }
            table.userGrid {
                border-collapse: collapse;
                width: 50%;
                overflow-x: scroll;
                display: block;
            }
            thead {
                background-color: #EFEFEF;
            }
            thead, tbody{
                display: block;
            }
            td.userGrid, th {
                min-width: 100px;
                height: 25px;
                border: solid 1px grey;
            }
            tbody.userGrid {
                overflow-y: scroll;
                overflow-x: hidden;
                height: 85%;
            }
        </style> 
    </head>
    <body>
        <div id="tablediv" style="position:relative;height:220px;">

            <table class = "userGrid" cellspacing="0" id="countrytable" margin-right:20px> 
                <thead>
                    <tr> 
                        <th style="min-width:200px; width:200px" scope="col">Name</th> 
                        <th style="min-width:130px; width:130px" scope="col">Login</th> 
                        <th style="min-width:100px; width:100px" scope="col">Branch</th> 
                        <th style="min-width:45px; width:45px" scope="col">ID</th> 
                    </tr>
                </thead>
                <tbody style = "overflow-y: scroll;overflow-x: hidden; height: 85%;">
                <p>${errorString}</p>

                </tbody>
            </table>
        </div>
        <br>
        <div id="tabs" style="width:80%;">
            <ul>       
                <li><a href="#tabs-1">Password</a></li>
                <li><a href="#tabs-2">Policies</a></li>
                <li><a href="#tabs-3">Claims</a></li>
                <li><a href="#tabs-4">Vehicle</a></li>
                <li><a href="#tabs-5">Reports</a></li>
                <li><a href="#tabs-6">Misc</a></li>
                <li><a href="#tabs-7">Tasks</a></li>
                <li><a href="#tabs-8">Tombstone</a></li>
                <li><a href="#tabs-9">Other</a></li>
                <li><a href="#tabs-10">Codes</a></li>

            </ul>
            <div id="tabs-1" style="height:220px;color:black">
                User : <label id="username"> </label>
                <input type ="button" id = "securityUpdate" value="Update" style="margin-left:80px; width:80px;" >
                <br>
                Id : <label id="userid"> </label>
                <br>
                Change password : <input type ="text" id="newpass" style="width:80px;">
                <input type="button" id="changepass" value="Change" style="width:80px;">
                <br>
                Log off user <input type="button" value="Log Off" id="logoff" style="width:80px;">
                <br><br>
                <div style="border:1px solid grey; width:300px; float:left">
                    <label style="font-weight:bold">Create User </label> <br>
                    User Name <input type="text" id="newname" style="width:100px">
                    <br>
                    Login <input type="text" id="newuser" style="width:100px; margin-left:32px;">
                    <br>
                    Branch <select id="newbranch" style="width:100px;margin-left:22px;" onClick="newMemberBranch();" > </select>
                    <input type="button" value="Create" id="createuser" style="float:right;">
                    <br>
                </div>  

                <div style="border:1px solid grey; width:300px; float:left; margin-left:50px">
                    <label style="font-weight:bold">Delete User</label>
                    <br>
                    Select User <select id="deluser" style="width:150" onClick="loadMemberDel();"></select>
                    <br>
                    <br>
                    <input type="button" value="Delete" id="deleteuser" style="float:right;">

                </div>
            </div>
            <div id="tabs-2">

                <table class="table newtable1" style="border:none; width:75%;">
                    <tbody>
                        <tr>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec4" >Update Accounts </label></td>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec11">Issue Alert </label></td>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec59">View All OP </label></td>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec103">Print Offline </label></td>
                        </tr>
                        <tr>    
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec10"> Update Notes </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec12"> Remove Alert</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec60"> Edit OP</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec104"> Auth Bank Fees</label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec5"> Update Members </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec46"> Accept Changes</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec61"> New Complaint</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec127"> Other Alerts</label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec42"> Create Member </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec43"> Import Payments</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec62"> Edit Complaint</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec148"> Import Cancel File</label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec44"> Update Additionals</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec16"> Cancel Receipt</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec68"> Reprint Receipt</label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec3"> Update Dependants </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec8"> Issue Receipt</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec74"> Export SMS</label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec2"> Update Contacts </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec72"> Print Multiple</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec77"> Grocery</label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec71"> Print Member Card</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec73"> Mailing List</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec78"> Post Back</label></td>
                        </tr>
                    <br>
                    </tbody>
                </table>
                <br>

            </div>        
            <div id="tabs-3">
                <table class="table newtable1" style="border:none; width:75%;">
                    <tbody>
                        <tr>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec35" > Beneficiary Name </label></td>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec27"> Funeral Receipt </label></td>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="taskenq"> Enq Task </label></td>
                        </tr>
                        <tr>    
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec34"> Claim Comments </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec26"> Edit After Auth</label></td>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="taskclaim"> Claim Task </label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec7"> Update Claims </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec25"> Auth Funeral</label></td>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="taskpay"> Pay Task </label></td>  
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec6"> View Claims </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec24"> New Funeral</label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec14"> Submit Claim Note</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec23"> View Funeral</label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec15"> Accept Claim Note </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec75"> Manual Trips</label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec82"> Trip Passenger</label></td>
                        </tr>                       
                    <br>
                    </tbody>
                </table>                
            </div>  
            <div id="tabs-4">
                <table class="table newtable1" style="border:none; width:75%;">
                    <tbody>
                        <tr>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec36" > View Vehicle </label></td>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec85"> Check Battery </label></td>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec92"> Update Insurance </label></td>
                        </tr>
                        <tr>    
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec38"> Remove Vehicle </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec86"> Check Tyre</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec93"> Consumables</label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec37"> Add Vehicle </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec87"> Warrantee Claims </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec94"> Order Parts </label></td>    
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec63"> Create Trip </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec88"> Add Damages </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec95"> Netstar Battery </label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec64"> Admin Trip </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec98"> Update Registration </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec96"> Netstar Test </label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec65"> Accept Claim Note </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec89"> Manual Trips</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec97"> Update General</label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec66"> Accept Claim Note </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec90"> Trip Passenger</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec99"> Update Odometer</label></td>
                        </tr>                       
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec67"> Vehicle Reports </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec91"> Update Finance </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec106"> Sell Vehicle </label></td>
                        </tr>                       
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec134"> Complete Event </label></td>
                        </tr>                        
                    <br>
                    </tbody>
                </table>                
            </div>  
            <div id="tabs-5">
                <table class="table newtable1" style="border:none; width:75%;">
                    <tbody>
                        <tr>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec47" > Monitor Cashier </label></td>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec17"> Edit Stock </label></td>                            
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec52"> New Orders </label></td>

                        </tr>
                        <tr>    
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec41"> Reports Branch </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec18"> Transfer stock</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec53"> Accept Orders</label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec40"> Reports Other </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec19"> View Stock </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec58"> Auth Orders </label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec39"> Reports Financial </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec121"> Transfer Item </label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec9"> Reports Policies </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec122"> Transfer Driver </label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec113"> StockTake </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec123"> Management Transfer </label></td>
                        </tr>                       
                        <tr>
                            <td> </td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec124"> Cancel Transfer </label></td>
                        </tr>                        
                    <br>
                    </tbody>
                </table>
            </div>  
            <div id="tabs-6">
                <table class="table newtable1" style="border:none; width:75%;">
                    <tbody>
                        <tr>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec22" > Service Device </label></td>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec50"> LogOff Users </label></td>                            
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec51"> Asset Management </label></td> 

                        </tr>
                        <tr>    
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec21"> Edit Device </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec13"> Create User </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec54"> Bodies </label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec20"> View Device </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec1"> Login Enabled </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec55"> Upload Images </label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec49"> Send Message </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec45"> Policy Info </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec56"> View Images </label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec48"> Cash Sales </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec109"> Vigil Trips </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec101"> Generator </label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec57"> Print Letters </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec80"> Document Request </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec108"> Confirm Gen Run </label></td>
                        </tr>                       
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec105"> Upload Contracts </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec79"> TeleSales </label></td>
                        </tr>                        
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec149"> Remove Claim Doc </label></td>
                        </tr>      
                        <tr>
                            <td> UserLock <input type="text" style="width:100px">  </td>
                        </tr>
                    <br>
                    </tbody>
                </table>
            </div> 
            <div id="tabs-7">
                <table class="table newtable1" style="border:none; width:75%;">
                    <tbody>
                        <tr>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec69" > Assign Task </label></td>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec112"> Train Users </label></td>   
                        </tr>
                        <tr>    
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec70"> Accept Task </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec128"> Print Task </label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec76"> Task Report </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec142"> Delete Image </label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec81"> Change Task From </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec144"> See All </label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec83"> Report Only Own </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec146"> Create Urgent </label></td>
                        </tr>  
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec110"> View Incidents </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec150"> Show Location </label></td>
                        </tr>  
                    <br>
                    </tbody>
                </table>
            </div> 
            <div id="tabs-8">
                <table class="table newtable1" style="border:none; width:75%;">
                    <tbody>
                        <tr>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec33" > Tombstone Receipt </label></td>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec107"> Back To Stock </label></td>   
                        </tr>
                        <tr>    
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec32"> Erect Tombstone </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec111"> Print Order </label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec31"> Cut Tombstone </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec129"> Late fees </label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec30"> Authorize Tombstone </label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec29"> New Tombstone </label></td>
                        </tr>  
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec28"> View Tombstone </label></td>
                        </tr>  
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec100"> Return Uncollected </label></td>
                        </tr>  
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec102"> Marketing </label></td>
                        </tr>  
                    <br>
                    </tbody>
                </table>
            </div> 
            <div id="tabs-9">
                <table class="table newtable1" style="border:none; width:75%;">
                    <tbody>
                        <tr>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec114" > SM Trips </label></td>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec120"> Policy Amend </label></td>   
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec132"> Banking </label></td>   
                        </tr>
                        <tr>    
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec115"> Keys </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec125"> Coffin Inspect </label></td>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec133"> Accept Banking </label></td>   
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec116"> Register CV </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec84"> Alarm Code </label></td>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec135"> Stop / Debit Dates </label></td>   
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec117"> Pol Change Vote 1 </label></td>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec126"> Safe Code </label></td>   
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec140"> Auth Trips </label></td>   
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec118"> Pol Change Vote 2 </label></td>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec130"> Ex Mun Auth </label></td>   
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec141"> Auth Receipt </label></td>   
                        </tr>  
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec119"> Pol Change Vote 3 </label></td>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec131"> Sign Post </label></td>   
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec143"> Receipt Utils </label></td>   
                        </tr>  
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec136"> Delete Notes </label></td>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec138"> Delete Images </label></td>   
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec145"> Task Log </label></td>   
                        </tr>  
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec137"> Auth Cash Claim </label></td>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec139"> Del Pol History </label></td>   
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec147"> Mem Age Auth </label></td>   
                        </tr>  
                    <br>
                    </tbody>
                </table>
            </div> 
            <div id="tabs-10">
            </div> 
        </div> 
        <br>

        <br>
        <script>
            $(function () {
                $("#tabs").tabs();
            });
        </script>    

        <script>
            $('table.userGrid').on('scroll', function () {
                $("table > *").width($("table").width() + $("table").scrollLeft());
            });
        </script>
    </body>
</html>
