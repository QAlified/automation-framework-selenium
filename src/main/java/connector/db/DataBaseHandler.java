package connector.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseHandler {
	
	private ResultSet data;
	
	public DataBaseHandler(ResultSet rs) {
		this.data = rs;
	}
	
	public boolean next() throws SQLException {
		return this.data.next();
	}
	public String getStringData(String column) throws SQLException {		
			return data.getString(column);
	}
	
	public int getIntData(String column) throws SQLException {
			return data.getInt(column);
	}
	
	public Float getFloatData(String column) throws SQLException {
		return data.getFloat(column);
	}
	
	public Boolean getBooleanData(String column) throws SQLException {
		return data.getBoolean(column);
	}
	
	public void debugTable(ResultSet rs) throws SQLException {
		while(rs.next()) {
			String column1 = rs.getString("ColumnName");
			System.out.print("ColumnName "+ column1);
		}
	}
	
	

	public void updateNameColumn(ResultSet rs) throws SQLException {
		rs.absolute(0); //I stand on column 0, I can select the column I want
		rs.updateString("OldColumnName", "NewColumnName"); //I modify the name of the column, I enter the new name for the old one
		rs.updateRow(); //Edit the column
	}

	public void insertColumnValue(ResultSet rs) throws SQLException {
		rs.moveToInsertRow();
		rs.updateString(1, "NewValue"); //Edit the value of column 1 by the string "NewValue"
		rs.updateInt(2, 5); //Edit the value of column 2 by integer 5
		rs.updateBoolean(3, true); //Edit the value of column 3 by the boolean TRUE
		rs.insertRow();
		rs.moveToCurrentRow();
	}
}
