
<%@page import="dwMapMgmt.Tbl_Dtl"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="java.util.HashMap"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page language="java" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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

<select
	id="tableNm" name="tableNm"
	onchange="populateTableDetails(this.value);">
	<option value='Select'>Select</option>
	<%

ArrayList<String> objTblDtl = new ArrayList<String>();

objTblDtl =(ArrayList<String>)request.getAttribute("TBL_LIST"); 

if(objTblDtl!=null && objTblDtl.size()!=0){

      for(String t : objTblDtl)

      {
			
%>
	<option value=<%= t %>><%= t %></option>
	<%

      }

}

%>

</select>
<br>
<br>
<input name="h" type="hidden"  id="h" value="1" />
<table  width="100"  border="2" cellpadding="0" cellspacing="0" id="table1">
<tr>

<td><strong>PHYS_TBL_NM</strong></td>
<td><strong>PHYS_COL_NM</strong> </td>
<td><strong>TRACE_ROUTE</strong></td>
</tr>
</table>
<script type="text/javascript">
function populateTableDetails(selectedValue)
{
	//clear previous rows
    var tblElement = document.getElementById('table1');
    var rowslength = tblElement.rows.length;
    for(var p=rowslength;p>1;p--)
    	{
    	document.getElementById('table1').deleteRow(p-1);
    	}
    
	if(selectedValue!='Select')
		{
		var categoryAndReportsMap = new Object();
	      <% 
	      Map<String,String> categoryAndReportsJ = (Map<String,String>)request.getAttribute("TBL_LIST_DETAILS");
	      for(Map.Entry<String,String> e : categoryAndReportsJ.entrySet()){ %>
	      categoryAndReportsMap[ '<%= e.getKey()%>' ] = '<%= e.getValue()%>';
	      <% } %>
	      var test = categoryAndReportsMap[selectedValue];
	      var str =''+test;
	      var arr = new Array();
	      arr = str.split('#~#');
	      for(var j=0;j<arr.length;j++)
	            {
	    	  		var colum = ''+arr[j];
	    	        var colDet = new Array();
    	  		    colDet = colum.split('~#~');
    	  		  	if(colDet !='undefined')
	    	  		addRow(colDet[0],colDet[1],colDet[2]);
	    	  		//document.getElementById('tbl_field'+j).value=arr[j];
	            }
		}
}

var i=1;

function addCell(cellPosition,elementType,type,name,id,size,maxlen,currentRowPosition,row,val)
{
	//alert('add cell='+val);
	var firstCell = row.insertCell(cellPosition);
    var el = document.createElement(elementType);
    el.type = type;
    el.name = name + currentRowPosition;
    el.id = id + currentRowPosition;
   
    el.size = size;
    el.maxlength = maxlen;
   
    el.value=val;
    el.disabled= "disabled";
    
    firstCell.appendChild(el);
    
}

function addRow(PHYS_TBL_NM,PHYS_COL_NM,TRACE_ROUTE)
{

          i=document.getElementById('h').value;

          var tbl = document.getElementById('table1');

          var lastRow = tbl.rows.length;

          var iteration = lastRow - 1;

          var row = tbl.insertRow(lastRow);

          
  
          addCell(0,'input','text','PHYS_TBL_NM','PHYS_TBL_NM',20,20,i,row,PHYS_TBL_NM);
          addCell(1,'input','text','PHYS_COL_NM','PHYS_COL_NM',20,20,i,row,PHYS_COL_NM);
          addCell(2,'input','text','TRACE_ROUTE','TRACE_ROUTE',200,200,i,row,TRACE_ROUTE);
                              
          i=parseInt(i,10)+1;

          document.getElementById('h').value = i;

}


</script>
</body>
</html>