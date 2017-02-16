

<html>

<script language="javascript" type="text/javascript">

var i=1;

function addCell(cellPosition,elementType,type,name,id,size,maxlen,currentRowPosition,row)
{
	var firstCell = row.insertCell(cellPosition);
    var el = document.createElement(elementType);
    el.type = type;
    el.name = name + currentRowPosition;
    el.id = id + currentRowPosition;
    el.size = size;
    el.maxlength = maxlen;
    firstCell.appendChild(el);
}

function addRow()

{

          i=document.getElementById('h').value;

          var tbl = document.getElementById('table1');

          var lastRow = tbl.rows.length;

          var iteration = lastRow - 1;

          var row = tbl.insertRow(lastRow);

  
          addCell(0,'input','text','TBL_ID','TBL_ID',20,20,i,row);
          addCell(1,'input','text','TBL_OWN','TBL_OWN',20,20,i,row);
          addCell(2,'input','text','PH_VERS_ID','PH_VERS_ID',20,20,i,row);
          addCell(3,'input','text','LOGIC_TBL_NM','LOGIC_TBL_NM',20,20,i,row);
          addCell(4,'input','text','PHYS_TBL_NM','PHYS_TBL_NM',20,20,i,row);
          addCell(5,'input','text','ETL_LYR','ETL_LYR',20,20,i,row);
          addCell(6,'input','text','LD_SCNRO','LOGIC_TBL_NM',20,20,i,row);
          addCell(7,'input','text','VW_IND','VW_IND',20,20,i,row);
          addCell(8,'input','text','SA_Desc','SA_Desc',20,20,i,row);
          addCell(9,'input','text','ROW_QRY','ROW_QRY',20,20,i,row);
          addCell(10,'input','text','TBL_SGNFC','TBL_SGNFC',20,20,i,row);
          
          i=parseInt(i,10)+1;

          document.getElementById('h').value = i;

}

</script>

  
<head>

<meta http-equiv="content-type" content="text/html; charset=windows-1252">

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

 <H1> Table Detail Insert</H1>

 <form action="LocalFileUpload" method="post" enctype="multipart/form-data">
<p>

<input type="file" name="file" id="file" size="50" />
       <br />
    <input type="submit" value="Upload File" />

</form>
<p align="center"><font face="Arial" size="1">© COPYRIGHT 2001 ALL RIGHTS RESERVED Shiva.com</font></p>
     </td>




      </tbody></table>

 

<table  bgcolor="#000000" border="0" cellpadding="0" cellspacing="0" width="100%">

  <tbody><tr>

    <td valign=bottom width="100%"><font size="1">&nbsp;</font></td>

  </tr>

</tbody></table>
</body></html>
