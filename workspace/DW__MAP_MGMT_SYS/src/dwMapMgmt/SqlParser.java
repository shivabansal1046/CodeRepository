package dwMapMgmt;
import java.io.*;
public class SqlParser {

	
	public static void main(String[] args){
		
		String SQL="select a.id,a.name from emp a where a.dept='aq' and a.sal>1000 group by id";
		String sql=SQL.toLowerCase();
		int select_pos=sql.indexOf("select ");
		int from_pos=sql.indexOf(" from ");
		int on_pos=sql.indexOf(" on ");
		int where_pos=sql.indexOf(" where ");
		int group_pos=sql.indexOf(" group by ");
		int order_pos=sql.indexOf(" order by ");
		String column_names=sql.substring(select_pos+6, from_pos);
		String table_names=sql.substring(from_pos+5, where_pos);
		String filter_columns=(((sql.substring(where_pos+5)).replaceFirst("='.*'","")).replaceAll("and", "")).replaceAll(">.*","" );
		
		System.out.println(column_names+":"+table_names+":"+filter_columns);
		
	}
}
