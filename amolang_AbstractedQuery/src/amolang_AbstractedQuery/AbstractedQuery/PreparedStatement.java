package amolang_AbstractedQuery.AbstractedQuery;

import java.sql.SQLException;
import java.sql.Timestamp;

public interface PreparedStatement {

	public void excuteUpdate() throws SQLException;
	public void excuteQuery() throws SQLException;
	public void pstmt_close() throws SQLException;
	public void setSqlString(int something_index, String something) throws SQLException;
	public void setSqlInt(int something_index, int something) throws SQLException;
	public void setSqlTimestamp(int something_index, Timestamp something) throws SQLException;
	public void setSqlBoolean(int something_index, boolean something) throws SQLException;
}
