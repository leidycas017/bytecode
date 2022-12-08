package com.spring.bytecode.beans;

import com.spring.bytecode.model.Conexion;
import com.spring.bytecode.model.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class CreandoConexion {

    @Bean(name = "beanUsuario")
    public Usuario getUsuario(){
        return new Usuario();
    }

    @Bean(name = "beanConexion")
    public Conexion getConexion(){
        Conexion conexion = new Conexion();
        conexion.setDb("mysql");
        conexion.setUrl("localhost");
        return conexion;
    }

    @Bean
    public DataSource getDtaSource(){
        DriverManagerDataSource dataSoruce = new DriverManagerDataSource();
        dataSoruce.setDriverClassName("com.mysql.jdbc.Driver");
        dataSoruce.setUrl("jdbc:mysql://localhost:3306/blog");
        dataSoruce.setUsername("bytecode");
        dataSoruce.setPassword("root1234");
        return dataSoruce;
    }
}
