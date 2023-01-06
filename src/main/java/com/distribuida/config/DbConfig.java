package com.distribuida.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperties;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jdbi.v3.core.Jdbi;

import java.io.ObjectInputFilter;

@ApplicationScoped
public class DbConfig {
    @Inject
    @ConfigProperty(name="db.user")
    String dbUser;

    @Inject
    @ConfigProperty(name="db.password")
    String dbPasssword;

    @Inject
    @ConfigProperty(name="db.url")
    String dbUrl;

    @PostConstruct
    public void init(){

        //Opcion 1
        System.out.println("*********** post construct");
         Config config= ConfigProvider.getConfig();

         String user = config.getValue("db.user", String.class);
         String passwd = config.getValue("db.password", String.class);
        String url = config.getValue("db.url", String.class);

        System.out.println(" opc1:user "+user);
        System.out.println(" opc1:pwd "+passwd);
        System.out.println(" opc1:url "+url);

        //opcion 2
        System.out.println(" opc2:user "+dbUser);
        System.out.println(" opc2:pwd "+dbPasssword);
        System.out.println(" opc2:url "+dbUrl);

    }
   public Jdbi test() {

       Config config = ConfigProvider.getConfig();

       String user = config.getValue("db.user", String.class);
       String password = config.getValue("db.password", String.class);
       String url = config.getValue("db.url", String.class);
       String driver = config.getValue("db.driver", String.class);
        //Conexion de pull
       HikariConfig conexion = new HikariConfig();
       conexion.setUsername(user);
       conexion.setPassword(password);
       conexion.setJdbcUrl(url);
       conexion.setDriverClassName(driver);
       return Jdbi.create(new HikariDataSource(conexion));
    }

}
