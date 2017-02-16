<%@page import="java.lang.reflect.Array"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

<%@page language="java" import="java.util.*" %>

<%@page import="dwMapMgmt.Tbl_Dtl"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html><head>

<meta http-equiv="content-type" content="text/plain; charset=UTF-8"/>

<title>Web Template</title>

</head>

 

<body topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0" style="background-color:white;" marginheight="0" marginwidth="0">

 

<table bgcolor="#999966" border="0" cellpadding="0" cellspacing="0" width="100%" height="1px">

  <tbody><tr>

    <td width="100%"><font color="#000000" face="Arial Black" size="6">Database Management</font></td>

  </tr>

</tbody></table>

<table bgcolor="#000000" border="0" cellpadding="0" cellspacing="0" width="100%">

  <tbody><tr>

    <td width="100%"><font color="#FFFFFF" face="Arial" size="2"><b>DDL management</b></font></td>

  </tr>

</tbody></table>

<table border="0" cellpadding="0" cellspacing="0" width="100%" height="100%">

  <tbody>

  <tr>
     <td bgcolor="#999966" valign="top" width="20%">

      <p style="margin-left: 20"><b><font color="#000000" face="Arial" size="2">

	&nbsp;&nbsp;&nbsp;&nbsp; <a href="http://HYD2-7200013317.ant.amazon.com:8080/DW__MAP_MGMT_SYS/AddTblInfoStart.jsp">Create New Table</a><br>

      	&nbsp;&nbsp;&nbsp;&nbsp; <a href="http://HYD2-7200013317.ant.amazon.com:8080/DW__MAP_MGMT_SYS/UpdateTableInfoStart.jsp">Modify Existing Table</a><br>

      	&nbsp;&nbsp;&nbsp;&nbsp; <a href="http://HYD2-7200013317.ant.amazon.com:8080/DW__MAP_MGMT_SYS/ViewTblInfoStart.jsp">View Tables</a><br>

      	&nbsp;&nbsp;&nbsp;&nbsp; <a href="http://HYD2-7200013317.ant.amazon.com:8080/DW__MAP_MGMT_SYS/ModColInfo.jsp">Add New Columns to table</a><br>

      	&nbsp;&nbsp;&nbsp;&nbsp; <a href="http://HYD2-7200013317.ant.amazon.com:8080/DW__MAP_MGMT_SYS/UpdateColInfoStart.jsp">Modify Existing Columns</a><br>

      	&nbsp;&nbsp;&nbsp;&nbsp; <a href="http://HYD2-7200013317.ant.amazon.com:8080/DW__MAP_MGMT_SYS/ViewTableColumnsStart.jsp">View Columns For a Table</a></font></b></p>
      	&nbsp;&nbsp;&nbsp;&nbsp; <a href="http://HYD2-7200013317.ant.amazon.com:8080/DW__MAP_MGMT_SYS/ViewTableColumnsStartAll.jsp">View All(Table/columns) </a></font></b></p>
      	&nbsp;&nbsp;&nbsp;&nbsp; <a href="http://HYD2-7200013317.ant.amazon.com:8080/DW__MAP_MGMT_SYS/ETLTraceQueryStart.jsp">Column ETL tracking</a></font></b></p>
      	&nbsp;&nbsp;&nbsp;&nbsp; <a href="http://HYD2-7200013317.ant.amazon.com:8080/DW__MAP_MGMT_SYS/DataMappingUpload.jsp">Data Mapping upload</a></font></b></p>
      	&nbsp;&nbsp;&nbsp;&nbsp; <a href="http://HYD2-7200013317.ant.amazon.com:8080/DW__MAP_MGMT_SYS/ExcelPDMGen.jsp">PDM Generate</a></font></b></p>
      	&nbsp;<br>
      	&nbsp;<br>
      	&nbsp;<br>
      	&nbsp;<br>
      	&nbsp;<br>
      	&nbsp;<br>
      	&nbsp;<br>
      	&nbsp;<br>
      	&nbsp;<br>
      	&nbsp;<br>
      	&nbsp;<br>
      	&nbsp;<br>
      	&nbsp;<br>
      	&nbsp;<br>
      	&nbsp;<br>
      	&nbsp;<br>
      	&nbsp;<br>
      	&nbsp;<br>
      	&nbsp;<br>
      	&nbsp;<br>
      	
      	
      	
      	
            </td>

   
	<td  valign="top" width="80%">

      <blockquote>

      	&nbsp;<br>
      	&nbsp;<br>
      	&nbsp;<br>
 <input type="button" name="Export to Excel" value="Export To Excel" onclick="createExcel();return false"/>
<table  width="100"  border="2" cellpadding="0" cellspacing="0" id="table1">

  <tr>

    <td><strong>TBL_ID</strong></td>
    <td><strong>TBL_OWN</strong> </td>
    <td><strong>PH_VERS_ID</strong> </td>
    <td><strong>LOGIC_TBL_NM</strong> </td>
    <td><strong>PHYS_TBL_NM</strong> </td>
    <td><strong>ETL_LYR</strong> </td>
    <td><strong>LD_SCNRO</strong> </td>
    <td><strong>VW_IND</strong> </td>
    <td><strong>SA_Desc</strong> </td>
    <td><strong>ROW_QRY</strong> </td>
    <td><strong>TBL_SGNFC</strong> </td></tr>

<%

ArrayList<Tbl_Dtl> objTblDtl = new ArrayList<Tbl_Dtl>();

objTblDtl =(ArrayList<Tbl_Dtl>)request.getAttribute("TBL_LIST"); 

if(objTblDtl!=null && objTblDtl.size()!=0){

      for(Tbl_Dtl t : objTblDtl)

      {
			
            %>
			<tr>
            <td><%=t.getTBL_ID() %></td>
            <td><%= t.getTBL_OWN() %></td>
            <td><%=t.getPH_VERS_ID() %></td>
            <td><%=t.getLOGIC_TBL_NM() %></td>
            <td><%= t.getPHYS_TBL_NM() %></td>
            <td><%= t.getETL_LYR() %></td>
            <td><%= t.getLD_SCNRO() %></td>
            <td><%= t.getVW_IND() %></td>
            <td><%= t.getSA_Desc() %></td>
            <td><%=t.getROW_QRY() %></td>
            <td><%=t.getTBL_SGNFC() %></td>
            
            </tr>

<%

      }

}

%>

</table>

 <p align="center"><font face="Arial" size="1">© COPYRIGHT 2001 ALL RIGHTS RESERVED Shiva.com</font></p>
     </td>




      </tbody></table>



<table  bgcolor="#000000" border="0" cellpadding="0" cellspacing="0" width="100%">

  <tbody><tr>

    <td valign=bottom width="100%"><font size="1">&nbsp;</font></td>

  </tr>

</tbody></table>
<script type="text/javascript">
function createExcel()
{
 var str = "";
 var mytable = document.getElementById("table1");
 var rowCount = mytable.rows.length;
 var colCount = mytable.getElementsByTagName("tr")[0].getElementsByTagName("td").length;
 var ExcelApp = new ActiveXObject("Excel.Application");
 var ExcelSheet = new ActiveXObject("Excel.Sheet");
 //ExcelSheet.Application.Visible = true;
 for (var i = 0; i < rowCount; i++) {
     for (var j = 0; j < colCount; j++) {
         if (i == 0) {
             str = mytable.getElementsByTagName("tr")[i].getElementsByTagName("td")[j].innerText;
         }
         else {
             str = mytable.getElementsByTagName("tr")[i].getElementsByTagName("td")[j].innerText;
         }
         ExcelSheet.ActiveSheet.Cells(i + 1, j + 1).Value = str;
     }
 }
 ExcelSheet.autofit;
 ExcelSheet.Application.Visible = true;
 DisplayAlerts = true;
 CollectGarbage();
}
</script>
</body></html>
