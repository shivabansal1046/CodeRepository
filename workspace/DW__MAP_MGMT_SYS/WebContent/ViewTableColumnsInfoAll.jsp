
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

   <input type="button" name="Export to Excel" value="Export To Excel" onclick="createExcel();return false"/>
<table  width="100"  border="2" cellpadding="0" cellspacing="0" id="table2">

      <blockquote>

      	&nbsp;<br>
      	&nbsp;<br>
      	&nbsp;<br>
      	
   
<select
	id="combobox" name="combobox"
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

</select><br><br><br>
<input name="h" type="hidden"  id="h" value="1" />
<table  width="100"  border="2" cellpadding="0" cellspacing="0" id="table1">
<tr>

<td><strong>ETL_LYR</strong></td>
<td><strong>PH_VERS_ID</strong></td>
<td><strong>SA_Desc</strong></td>
<td><strong>SRC</strong></td>
<td><strong>SCD NON SCD</strong> </td>
<td><strong>RI NOT RI</strong> </td>
<td><strong>LD_SCNRO</strong></td>
<td><strong>VW_IND</strong></td>
<td><strong>PI</strong> </td>
<td><strong>PPI</strong> </td>
<td><strong>KEY COLUMNS</strong> </td>
<td><strong>LOGIC_TBL_NM</strong></td>
<td><strong>LOGIC_COL_NM</strong></td>
<td><strong>PHYS_TBL_NM</strong></td>
<td><strong>PHYS_COL_NM</strong></td>
<td><strong>TBL_OWN</strong></td>
<td><strong>DATATYP</strong></td>
<td><strong>SRC_TBL_NM</strong></td>
<td><strong>SRC_COL_NM</strong></td>
<td><strong>COL_BUS_LOGIC</strong></td>
<td><strong>ROW_QRY</strong></td>
<td><strong>TBL_SGNFC</strong></td>
<td><strong>COMT</strong></td>
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
	      arr = str.split('||||');
	      for(var j=0;j<arr.length;j++)
	            {
	    	  		var colum = ''+arr[j];
	    	        var colDet = new Array();
    	  		    colDet = colum.split('~~');
	    	  		if(colDet !='undefined')
	    	  		addRow(colDet[0],colDet[1],colDet[2],colDet[3],colDet[4],colDet[5],colDet[6],colDet[7],colDet[8]
	    	  		,colDet[9],colDet[10],colDet[11],colDet[12],colDet[13],colDet[14],colDet[15],colDet[16],colDet[17],
	    	  		colDet[18],colDet[19],colDet[20],colDet[21],colDet[22]);
	    	  		//document.getElementById('tbl_field'+j).value=arr[j];
	    	  		
	    	  	
	    	  		
	            }
		}
}

var i=1;

function addCell(cellPosition,elementType,type,name,id,size,maxlen,currentRowPosition,row,val)
{
	
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

function addRow(
		ETL_LYR,PH_VERS_ID,SA_Desc,SRC,SCD_NON_SCD,RI_NOT_RI,LD_SCNRO,VW_IND,PI,PPI,KEY_COLUMNS,LOGIC_TBL_NM,
		LOGIC_COL_NM,PHYS_TBL_NM,PHYS_COL_NM,TBL_OWN,DATATYP,SRC_TBL_NM,SRC_COL_NM,COL_BUS_LOGIC,ROW_QRY,TBL_SGNFC,COMT)
{

          i=document.getElementById('h').value;

          var tbl = document.getElementById('table1');
          

          var lastRow = tbl.rows.length;
			
          var iteration = lastRow - 1;

          var row = tbl.insertRow(lastRow);

  
          
          addCell(0,'input','text','ETL_LYR','ETL_LYR',20,20,i,row,ETL_LYR);
          addCell(1,'input','text','PH_VERS_ID','PH_VERS_ID',20,20,i,row,PH_VERS_ID);
          addCell(2,'input','text','SA_Desc','SA_Desc',20,20,i,row,SA_Desc);
          addCell(3,'input','text','SRC','SRC',20,20,i,row,SRC);
          addCell(4,'input','text','SCD_NON_SCD','SCD_NON_SCD',20,20,i,row,SCD_NON_SCD);
          addCell(5,'input','text','RI_NOT_RI','RI_NOT_RI',20,20,i,row,RI_NOT_RI);
          addCell(6,'input','text','LD_SCNRO','LD_SCNRO',20,20,i,row,LD_SCNRO);
          addCell(7,'input','text','VW_IND','VW_IND',20,20,i,row,VW_IND);
          addCell(8,'input','text','PI','PI',20,20,i,row,PI);
          addCell(9,'input','text','PPI','PPI',20,20,i,row,PPI);
          addCell(10,'input','text','KEY_COLUMNS','KEY_COLUMNS',20,20,i,row,KEY_COLUMNS);
          addCell(11,'input','text','LOGIC_TBL_NM','LOGIC_TBL_NM',20,20,i,row,LOGIC_TBL_NM);
          addCell(12,'input','text','LOGIC_COL_NM','LOGIC_COL_NM',20,20,i,row,LOGIC_COL_NM);
          addCell(13,'input','text','PHYS_TBL_NM','PHYS_TBL_NM',20,20,i,row,PHYS_TBL_NM);
          addCell(14,'input','text','PHYS_COL_NM','PHYS_COL_NM',20,20,i,row,PHYS_COL_NM);
          addCell(15,'input','text','TBL_OWN','TBL_OWN',20,20,i,row,TBL_OWN);
          addCell(16,'input','text','DATATYP','DATATYP',20,20,i,row,DATATYP);
          addCell(17,'input','text','SRC_TBL_NM','SRC_TBL_NM',20,20,i,row,SRC_TBL_NM);
          addCell(18,'input','text','SRC_COL_NM','SRC_COL_NM',20,20,i,row,SRC_COL_NM);
          addCell(19,'input','text','COL_BUS_LOGIC','COL_BUS_LOGIC',20,20,i,row,COL_BUS_LOGIC);
          addCell(20,'input','text','ROW_QRY','ROW_QRY',20,20,i,row,ROW_QRY);
          addCell(21,'input','text','TBL_SGNFC','TBL_SGNFC',20,20,i,row,TBL_SGNFC);
          addCell(22,'input','text','COMT','COMT',20,20,i,row,COMT);
          
                    
          i=parseInt(i,10)+1;

          document.getElementById('h').value = i;

}

function createExcel()
{
 var str = "";
 var mytable = document.getElementById("table1");
 var rowCount = mytable.rows.length;
 var colCount = mytable.getElementsByTagName("tr")[0].getElementsByTagName("td").length;
 var ExcelApp = new ActiveXObject("Excel.Application");
 var ExcelSheet = new ActiveXObject("Excel.Sheet");
 ExcelSheet.Application.Visible = true;
 var j=1;
 for (var i = 1; i < rowCount; i++) {
	 j=1;
             var ETL_LYR = document.getElementById("ETL_LYR"+i).value;
             ExcelSheet.ActiveSheet.Cells(i, j).Value = ETL_LYR;
         
             var phyVerId = document.getElementById("PH_VERS_ID"+i).value;
             ExcelSheet.ActiveSheet.Cells(i, j+1).Value = phyVerId;
             
             var phyVerId = document.getElementById("SA_Desc"+i).value;
             ExcelSheet.ActiveSheet.Cells(i, j+2).Value = phyVerId;
             
             var phyVerId = document.getElementById("SRC"+i).value;
             ExcelSheet.ActiveSheet.Cells(i, j+3).Value = phyVerId;
             
             var phyVerId = document.getElementById("SCD_NON_SCD"+i).value;
             ExcelSheet.ActiveSheet.Cells(i, j+4).Value = phyVerId;
             
             var phyVerId = document.getElementById("RI_NOT_RI"+i).value;
             ExcelSheet.ActiveSheet.Cells(i, j+5).Value = phyVerId;
             
             var phyVerId = document.getElementById("LD_SCNRO"+i).value;
             ExcelSheet.ActiveSheet.Cells(i, j+6).Value = phyVerId;
             
             var phyVerId = document.getElementById("VW_IND"+i).value;
             ExcelSheet.ActiveSheet.Cells(i, j+7).Value = phyVerId;
             
             var phyVerId = document.getElementById("PI"+i).value;
             ExcelSheet.ActiveSheet.Cells(i, j+8).Value = phyVerId;
             
             var phyVerId = document.getElementById("PPI"+i).value;
             ExcelSheet.ActiveSheet.Cells(i, j+9).Value = phyVerId;
             
             var phyVerId = document.getElementById("KEY_COLUMNS"+i).value;
             ExcelSheet.ActiveSheet.Cells(i, j+10).Value = phyVerId;
             
             var phyVerId = document.getElementById("LOGIC_TBL_NM"+i).value;
             ExcelSheet.ActiveSheet.Cells(i, j+11).Value = phyVerId;
             
             var phyVerId = document.getElementById("LOGIC_COL_NM"+i).value;
             ExcelSheet.ActiveSheet.Cells(i, j+12).Value = phyVerId;
             
             var phyVerId = document.getElementById("PHYS_TBL_NM"+i).value;
             ExcelSheet.ActiveSheet.Cells(i, j+13).Value = phyVerId;
             
             var phyVerId = document.getElementById("PHYS_COL_NM"+i).value;
             ExcelSheet.ActiveSheet.Cells(i, j+14).Value = phyVerId;
             
             var phyVerId = document.getElementById("TBL_OWN"+i).value;
             ExcelSheet.ActiveSheet.Cells(i, j+15).Value = phyVerId; 
                                      
             var phyVerId = document.getElementById("DATATYP"+i).value;
             ExcelSheet.ActiveSheet.Cells(i, j+16).Value = phyVerId;
             
             var phyVerId = document.getElementById("SRC_TBL_NM"+i).value;
             ExcelSheet.ActiveSheet.Cells(i, j+15).Value = phyVerId;
             
             var phyVerId = document.getElementById("SRC_COL_NM"+i).value;
             ExcelSheet.ActiveSheet.Cells(i, j+16).Value = phyVerId;
             
             var phyVerId = document.getElementById("COL_BUS_LOGIC"+i).value;
             ExcelSheet.ActiveSheet.Cells(i, j+17).Value = phyVerId;
             
             var phyVerId = document.getElementById("ROW_QRY"+i).value;
             ExcelSheet.ActiveSheet.Cells(i, j+18).Value = phyVerId;
             
             var phyVerId = document.getElementById("TBL_SGNFC"+i).value;
             ExcelSheet.ActiveSheet.Cells(i, j+19).Value = phyVerId;
             
 
             var phyVerId = document.getElementById("COMT"+i).value;
             ExcelSheet.ActiveSheet.Cells(i, j+20).Value = phyVerId;
             
 }
 ExcelSheet.autofit;
 ExcelSheet.Application.Visible = true;
 DisplayAlerts = true;
 CollectGarbage();
}


function createExcel1()
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

<link rel="stylesheet" href="./js_re/themes/base/jquery.ui.all.css">
	<script src="./js_re/jquery-1.10.2.js"></script>
	<script src="./js_re/ui/jquery.ui.core.js"></script>
	<script src="./js_re/ui/jquery.ui.widget.js"></script>
	<script src="./js_re/ui/jquery.ui.button.js"></script>
	<script src="./js_re/ui/jquery.ui.position.js"></script>
	<script src="./js_re/ui/jquery.ui.menu.js"></script>
	<script src="./js_re/ui/jquery.ui.autocomplete.js"></script>
	<script src="./js_re/ui/jquery.ui.tooltip.js"></script>
	<link rel="stylesheet" href="./js_re/demos.css">
	<style>
	.custom-combobox {
		position: relative;
		display: inline-block;
	}
	.custom-combobox-toggle {
		position: absolute;
		top: 0;
		bottom: 0;
		margin-left: -1px;
		padding: 0;
		/* support: IE7 */
		*height: 1.7em;
		*top: 0.1em;
	}
	.custom-combobox-input {
		margin: 0;
		padding: 0.3em;
	}
	</style>
	<script>
	(function( $ ) {
		$.widget( "custom.combobox", {
			_create: function() {
				this.wrapper = $( "<span>" )
					.addClass( "custom-combobox" )
					.insertAfter( this.element );

				this.element.hide();
				this._createAutocomplete();
				this._createShowAllButton();
				
			},

			_createAutocomplete: function() {
				var selected = this.element.children( ":selected" ),
					value = selected.val() ? selected.text() : "";

				this.input = $( "<input>" )
					.appendTo( this.wrapper )
					.val( value )
					.attr( "title", "" )
					.addClass( "custom-combobox-input ui-widget ui-widget-content ui-state-default ui-corner-left" )
					.autocomplete({
						delay: 0,
						minLength: 0,
						source: $.proxy( this, "_source" )
					})
					.tooltip({
						tooltipClass: "ui-state-highlight"
					});

				this._on( this.input, {
					autocompleteselect: function( event, ui ) {
						ui.item.option.selected = true;
						this._trigger( "select", event, {
							item: ui.item.option
						});
						populateTableDetails(ui.item.option.value);	
					},

					autocompletechange: "_removeIfInvalid"
				});
			},

			_createShowAllButton: function() {
				var input = this.input,
					wasOpen = false;

				$( "<a>" )
					.attr( "tabIndex", -1 )
					.attr( "title", "Show All Items" )
					.tooltip()
					.appendTo( this.wrapper )
					.button({
						icons: {
							primary: "ui-icon-triangle-1-s"
						},
						text: false
					})
					.removeClass( "ui-corner-all" )
					.addClass( "custom-combobox-toggle ui-corner-right" )
					.mousedown(function() {
						wasOpen = input.autocomplete( "widget" ).is( ":visible" );
					})
					.click(function() {
						input.focus();

						// Close if already visible
						if ( wasOpen ) {
							return;
						}

						// Pass empty string as value to search for, displaying all results
						input.autocomplete( "search", "" );
					});
			},

			_source: function( request, response ) {
				var matcher = new RegExp( $.ui.autocomplete.escapeRegex(request.term), "i" );
				response( this.element.children( "option" ).map(function() {
					var text = $( this ).text();
					if ( this.value && ( !request.term || matcher.test(text) ) )
						return {
							label: text,
							value: text,
							option: this
							
							
						};
						
				}) );
			},

			_removeIfInvalid: function( event, ui ) {

				// Selected an item, nothing to do
					
					
				if ( ui.item ) {
					
					return;
				}

				// Search for a match (case-insensitive)
				var value = this.input.val(),
					valueLowerCase = value.toLowerCase(),
					valid = false;
				this.element.children( "option" ).each(function() {
					if ( $( this ).text().toLowerCase() === valueLowerCase ) {
						this.selected = valid = true;
						return false;
					}
				});

				// Found a match, nothing to do
					
				if ( valid ) {
					return;
				}

				// Remove invalid value
				this.input
					.val( "" )
					.attr( "title", value + " didn't match any item" )
					.tooltip( "open" );
				this.element.val( "" );
				this._delay(function() {
					this.input.tooltip( "close" ).attr( "title", "" );
				}, 2500 );
				this.input.data( "ui-autocomplete" ).term = "";
				
			},

			_destroy: function() {
				this.wrapper.remove();
				this.element.show();
			}
		});
	})( jQuery );

	$(function() {
		$( "#combobox" ).combobox();
		$( "#toggle" ).click(function() {
			$( "#combobox" ).toggle();
			
		});
		
	});
	
	</script>
</body>
</html>