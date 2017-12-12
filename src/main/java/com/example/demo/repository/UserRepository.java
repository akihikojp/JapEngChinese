package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.User;

@Repository
public class UserRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	public final static RowMapper<User> userRowMapper = (rs, i) -> {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setDefaultLanguage(rs.getString("default_language"));
		return user;
	};

	public List<User> findALll() {
		String sql = "SELECT id, name, default_language from users";
		return template.query(sql, userRowMapper);
	}
	
	public User findById(Integer id) {
		String sql = "SELECT id, name, default_language from users WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		return template.queryForObject(sql, param, userRowMapper);
	}
}
