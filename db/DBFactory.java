package com.securecloud.db;

import com.securecloud.db.AbstractDataAccessObject;

public class DBFactory {
	public DBFactory() {
		new AbstractDataAccessObject().getConnection();
	}
}
