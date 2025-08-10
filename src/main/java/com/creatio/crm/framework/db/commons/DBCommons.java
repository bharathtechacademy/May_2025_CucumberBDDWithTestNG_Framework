package com.creatio.crm.framework.db.commons;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.creatio.crm.framework.utilities.DBUtil;

public class DBCommons {
	
	// Common method to convert the raw data into collections data structure
	
		public static List<Map<String, String>> readData(String query) throws SQLException {
			List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();

			// Get the raw data from the DB
			ResultSet dataSet = DBUtil.getData(query);

			// Copy data into list of Map
			while (dataSet.next()) { // Verify whether next row available
				Map<String, String> rowData = new HashMap<String, String>(); // create a empty map to store 1 row data
				for (int c = 1; c <= dataSet.getMetaData().getColumnCount(); c++) { // iterate from column 1 to last column
					String columnName = dataSet.getMetaData().getColumnName(c);
					String columnValue = dataSet.getString(c);
					rowData.put(columnName, columnValue); // store each column name and values in the row record
				}
				dataList.add(rowData); // add entire row data into main list.
			}
			return dataList;
		}

}
