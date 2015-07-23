package amolang_AbstractedQuery.AbstractedQuery;

import java.sql.SQLException;
import java.sql.Timestamp;

public interface ResultSet {

	public boolean next() throws SQLException;
	public String getString(int columnIndex) throws SQLException;
	public int getInt(int columnIndex) throws SQLException;
	public boolean getBoolean(int columnIndex) throws SQLException;
	public Timestamp getTimestamp(int columnIndex) throws SQLException;
}
