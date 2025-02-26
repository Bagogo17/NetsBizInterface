package com.nets.netsbiz.qri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class Repository {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    MobUserDAO mobUserDAO;

//    public List<String> getUserIdBasedStatus(String status) {
//        String sql = "SELECT id FROM mob_user WHERE status=:status";
//        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
//        parameterSource.addValue("status",status);
//        return namedParameterJdbcTemplate.queryForList(sql,parameterSource, String.class);
//    }

    public List<UUID> getUserIdBasesOnStatus(String status) {
        List<JpaMobUser> jpaMobUser = mobUserDAO.findByStatus(status);
        return jpaMobUser.stream().map(JpaMobUser::getId).collect(Collectors.toList());
    }
}
