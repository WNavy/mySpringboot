package com.whj.dao.impl;

import com.whj.dao.CityJdbcDao;
import com.whj.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by wuhaijun on 2017/8/21.
 */
@Repository("cityJdbcDao")
public class CityJdbcDaoImpl implements CityJdbcDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询所有数据
     * @return
     */
    public List<City> findAll(){

        String sql = "select * from w_city";
        RowMapper<City> rowMapper = new BeanPropertyRowMapper<City>(City.class);
        List<City> lists = jdbcTemplate.query(sql, rowMapper);
        if(lists != null && lists.size() > 0){
            return lists;
        }
        return null;
    }

    /**
     * 查询单条记录
     * @param id
     * @return
     */
    public City findById(int id){
        RowMapper<City> rowMapper = new BeanPropertyRowMapper<City>(City.class);
        String sql = "select * from w_city where id = ?";
        return jdbcTemplate.queryForObject(sql,rowMapper,id);

    }

    /**
     * 更新数据
     * @param city
     * @return
     */
    public int update(City city) {

        String sql = "update w_city set city_name = ? where id = ?";
        int affectedCount = jdbcTemplate.update(sql, new Object[]{city.getCityName(), city.getId()});
        return affectedCount;
    }

    /**
     * 删除数据
     * @param id
     * @return
     */
    public int delete(int id) {

        String sql = "delete from w_city where id = ?";
        int affectedCount = jdbcTemplate.update(sql, id);
        return affectedCount;
    }

    /**
     * 插入数据
     * @param city
     * @return
     */
    public int insert(City city){
        String sql = "insert into w_city(province_id,city_name) values (?,?)";
        int afffectedCount = jdbcTemplate.update(sql,new Object[]{city.getProvinceId(),city.getCityName()});
        return afffectedCount;
    }
}
