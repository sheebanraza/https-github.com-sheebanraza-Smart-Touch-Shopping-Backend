package service;

import model.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.validation.ObjectError;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


/**
 * Created by Sheeban Raza on 27-Apr-16.
 */

@Repository
public class DBHelper {

    @Autowired
    DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Items findByName(String name){
        String query = "SELECT * FROM items WHERE item_name = ?";

        jdbcTemplate = new JdbcTemplate(dataSource);
        try {
            Items fetchedItem  = (Items)jdbcTemplate.queryForObject(query, new Object[]{name}, new RowMapper<Object>() {
                @Override
                public Object mapRow(ResultSet rs, int i1) throws SQLException {
                    Items items = new Items();
                    items.setId(rs.getInt("id"));
                    items.setName(rs.getString("item_name"));
                    items.setLocation(rs.getString("item_location"));
                    return items;
                }
            });
            return fetchedItem;
        }catch (EmptyResultDataAccessException e){
            return null;
        }

    }

}
