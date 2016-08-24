

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%-- <spring:url value="/resources/style.css" var="Acss" />
        <spring:url value="/resources/jquery.js" var="Qjs" />
        <link href="${Acss}" rel="stylesheet" />
        <script src="${Qjs}"></script> --%>
        
        
    </head>
    <body>
        
        <table border="1" class="table" style="name:detail-table">
            <tr>
               
                <td colspan="2" id="i2" style="width:200px; height:250px; background-color:#ffcc99;text-align:center; vertical-align:middle">
  			<img src="../ListStaffs/resources/img/${detail_staff.avatar_staff}" alt="Updating ..." style="max-height:100%; max-width:100%;align:center"/>
  		
                
            
            </tr>
            <tr>
                <td>Company</td>
                <td align="center">${detail_staff.id_staff}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td align="center">${detail_staff.name_staff}</td>
            </tr>
           
            <tr>
                <td>Reference</td>
                <td align="center"><textarea style="text-align:justify; width:100%;" disabled>${detail_staff.info_staff}</textarea></td>
            </tr>
            
        </table>
            <table class="button-modal" style="width:100%; resize: none;">
            <tr>
                <td width="50%"></td>
                <td width="50%" align="right"><button type="button" class="btn btn-default" data-dismiss="modal" id="close-button">Close</button></td>
            </tr>
        </table>
    </body>
</html>
