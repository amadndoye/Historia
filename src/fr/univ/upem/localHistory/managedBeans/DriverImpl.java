package fr.univ.upem.localHistory.managedBeans;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public class DriverImpl implements Driver{

	private Driver driver;
	
	public DriverImpl(Driver d){
		this.driver = d;
	}
	
	public Connection connect(String u, Properties p) throws SQLException {
		return this.driver.connect(u, p);
	}
	
	public int getMajorVersion() {
		return this.driver.getMajorVersion();
	}
	public int getMinorVersion() {
		return this.driver.getMinorVersion();
	}
	public DriverPropertyInfo[] getPropertyInfo(String u, Properties p) throws SQLException {
		return this.driver.getPropertyInfo(u, p);
	}
	public boolean jdbcCompliant() {
		return this.driver.jdbcCompliant();
}

	@Override
	public boolean acceptsURL(String url) throws SQLException {
		return this.driver.acceptsURL(url);
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return this.driver.getParentLogger();
	}
}
