package dev.tknapp.eatyoursprouts.items;

import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class JDBCItemDAOImpl implements ItemDAO {
    
    private JdbcTemplate jdbcTemplate;
    
    public JDBCItemDAOImpl(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    
    @Override
    public Item createNewItem(Item newItem) {
        String sql = "INSERT INTO items(name, code, type, price, quantity) " +
                "VALUES(?, ?, ?, ?, ?)";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, newItem.getName(), newItem.getCode(), newItem.getType(), newItem.getPrice(), newItem.getQuantity());
        rows.next();
        newItem.setId(rows.getLong("id"));
        return newItem;
    }
}
