package com.example.demo.repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Language;

@Repository
public class LanguageRepository {
	
	@Autowired 
	private NamedParameterJdbcTemplate template;

	public final static RowMapper<Language> languageRowMapper = (rs, i) -> {
		Language language = new Language();
		language.setId(rs.getInt("id"));
		language.setLanguage(rs.getString("language"));
		language.setText(rs.getString("text"));
		return language;
	};

	public List<Language> findALll(){
		String sql = "SELECT id, language, text from languages";
		return template.query(sql, languageRowMapper);
	}
}

