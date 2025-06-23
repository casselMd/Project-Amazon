package database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
public class ConexionBD {

    private static final HikariDataSource ds;

    static {
        HikariConfig cfg = new HikariConfig();
        cfg.setJdbcUrl("jdbc:mysql://localhost:3306/amazon_bd?useSSL=false&serverTimezone=UTC");
        cfg.setUsername("root");
        cfg.setPassword("");
        cfg.setMaximumPoolSize(10);
        cfg.setPoolName("HikariPool-Amazon");
        ds = new HikariDataSource(cfg);
    }
    private ConexionBD() {}
    public static DataSource getDataSource() {
        return ds;
    }

}
