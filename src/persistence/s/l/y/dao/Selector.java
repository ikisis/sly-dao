package s.l.y.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import s.l.y.dao.util.CloseableUtils;

public class Selector {

	public static void fetch(Connection conn, Fetchable fetchable) throws SQLException{
		
		PreparedStatement p = null;
		
		ResultSet r = null;
		
		try {
			
			p = conn.prepareStatement(fetchable.sql());
			
			fetchable.set(p);
			
			r = p.executeQuery();
			
			while(r.next() && fetchable.use(r));
			
			
		} catch (SQLException e) {
			throw e;
		} finally{
			
			CloseableUtils.close(p, r);
			
		}
		
	}
	
	public static interface Fetchable{
		public String sql();
		public void set(PreparedStatement p) throws SQLException;
		public boolean use(ResultSet r) throws SQLException;
	}
	
}
