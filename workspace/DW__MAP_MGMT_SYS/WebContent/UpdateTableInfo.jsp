
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

</select>
</blockquote>

<form id="updateInfo" action="UpdateTableInfo" method="get" onsubmit="return confirm('Are you sure you want to submit?')">
<input type="Hidden" id="pagefrom" value="updatesubmitpage"/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Table ID : &nbsp;<input type="text" id="tbl_field0" name="TBL_ID"/><br/>
</br>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Phase Version Id : <select   style="width: 200px;" id="tbl_field1" name="PH_VERS_ID" >
	<option value='Select'>Select</option>
	<%

ArrayList<String> ent_typ_ref = new ArrayList<String>();

	ent_typ_ref =(ArrayList<String>)request.getAttribute("ent_typ_ref"); 

if(ent_typ_ref!=null && ent_typ_ref.size()!=0){

      for(String t : ent_typ_ref)

      {
    	  String Val="";
    	  if(t.substring(t.indexOf("|")+1).equals("PHASE VERSION")){
    	  Val=t.substring(0,t.indexOf("|"));
    	  
    	  %>
    	  <option value=<%= Val %> ><%= Val %></option>
    	  <% }
    
	

      }

}

%>

</select>

</br></br>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Source :&nbsp; <input type="text" id="tbl_field2" name="SRC" /><br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Table Owner : &nbsp;<input type="text" id="tbl_field3" name="TBL_OWN"/><br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Logical Table Name :&nbsp; <input type="text" id="tbl_field4" name="LOGIC_TBL_NM"/><br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Physical Table Name : &nbsp;<input type="text" id="tbl_field5" name="PHYS_TBL_NM" /><br/><br/>
</br>


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;View Ind :&nbsp; <select	id="tbl_field6" name="VW_IND">
	<option value='Select'>Select</option>
	<%

	 ent_typ_ref = new ArrayList<String>();

	ent_typ_ref =(ArrayList<String>)request.getAttribute("ent_typ_ref"); 

if(ent_typ_ref!=null && ent_typ_ref.size()!=0){

      for(String t : ent_typ_ref)

      {
    	  String Val="";
    	  if(t.substring(t.indexOf("|")+1).equals("VIEW_IND")){
    		  Val=t.substring(0,t.indexOf("|"));
        	  %>
        	  <option value=<%= Val %> ><%= Val %></option>
        	  <% }
        
    	

          }

    }

    %>

    </select>
   </br>
</br> 
    

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

ETL Layer :&nbsp; <select	id="tbl_field7" name="ETL_LYR">
	<option value='Select'>Select</option>
	<%

	 ent_typ_ref = new ArrayList<String>();

	ent_typ_ref =(ArrayList<String>)request.getAttribute("ent_typ_ref"); 

if(ent_typ_ref!=null && ent_typ_ref.size()!=0){

      for(String t : ent_typ_ref)

      {
    	  String Val="";
    	  if(t.substring(t.indexOf("|")+1).equals("ETL LAYER")){
    		  Val=t.substring(0,t.indexOf("|"));
        	  %>
        	  <option value=<%= Val %> ><%= Val %></option>
        	  <% }
        
    	

          }

    }

    %>

    </select>
    <br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Row Query :&nbsp; <textarea rows="3"  id="tbl_field8" name="ROW_QRY" ></textarea><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Table Significance : &nbsp;<input type="text" id="tbl_field9" name="TBL_SGNFC"/><br/>
</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Load Scenario :&nbsp; <select	id="tbl_field10" name="LD_SCNRO">
	<option value='Select'>Select</option>
	<%

	 ent_typ_ref = new ArrayList<String>();

	ent_typ_ref =(ArrayList<String>)request.getAttribute("ent_typ_ref"); 

if(ent_typ_ref!=null && ent_typ_ref.size()!=0){

      for(String t : ent_typ_ref)

      {
    	  String Val="";
    	  if(t.substring(t.indexOf("|")+1).equals("CODE SCENARIO")){
    		  Val=t.substring(0,t.indexOf("|"));
        	  %>
        	  <option value=<%= Val %> ><%= Val %></option>
        	  <% }
        
    	

          }

    }

    %>

    </select>

</br>
</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SA Description :&nbsp; <input type="text" id="tbl_field11" name="SA_Desc" /><br/>
<input type="submit"  value="Submit" name="Submit"/>

</form>


<script type="text/javascript">

	


function populateTableDetails(selectedValue)
{
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
	      arr = str.split('~#~');
	      for(var j=0;j<arr.length;j++)
	            {
	    	  	document.getElementById('tbl_field'+j).value=arr[j];
	            }
		}
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