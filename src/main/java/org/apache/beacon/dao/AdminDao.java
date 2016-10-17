package org.apache.beacon.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository("playerDAO")
public class AdminDao {
	private DataSource dataSource;

}
