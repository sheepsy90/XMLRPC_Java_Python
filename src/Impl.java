import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: rkessler
 * Date: 02.01.14
 * Time: 13:18
 * To change this template use File | Settings | File Templates.
 */
public class Impl implements Api{


	private final SqlWrapper sqlWrapper;

	public Impl() throws SQLException {
		sqlWrapper = new SqlWrapper();
		sqlWrapper.open();
		sqlWrapper.setup();
	}

	@Override
	public boolean insert(int id, String name) {
		return sqlWrapper.insert(name);
	}

	@Override
	public String show(int limit) {
		return sqlWrapper.show(limit);
	}

}
