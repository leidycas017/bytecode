package com.spring.bytecode;

import com.spring.bytecode.beans.PostComponent;
import com.spring.bytecode.model.Conexion;
import com.spring.bytecode.service.PostService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@SpringBootApplication
public class BytecodeApplication implements CommandLineRunner {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${bytecode.jdbc.import.ruta}")
	private String ruta;

	@Value("${bytecode.jdbc.import}")
	private String importar;

	Log log = LogFactory.getLog(getClass());

/*
	@Autowired
	@Qualifier("com.spring.bytecode.beans.PostComponent")
	public PostComponent postComponent;

	@Autowired
    @Qualifier("serviceDecorado")
	public PostService postService;
*/

	public static void main(String[] args) {
		SpringApplication.run(BytecodeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(importar.equalsIgnoreCase("true")){
			Path path = Paths.get(ruta);

			//alternativa
			//Path path = Paths.get("src/main/resources/import.sql");

			try(BufferedReader bufferedReader = Files.newBufferedReader(path, Charset.forName("UTF-8"))){
				String line;
				while((line = bufferedReader.readLine()) != null){
					jdbcTemplate.execute(line);
				}
			}catch (IOException ex){

			}
		}
		log.info("Tenemos esta cantidad de permisos: " + jdbcTemplate.queryForObject("SELECT count(*) FROM permiso;", Integer.class));



		/*
		Log log = LogFactory.getLog(BytecodeApplication.class);
		try {
			postService.validation(postComponent.getPost())
					.forEach((post)->{
						//System.out.println(post.getTitulo());
						log.info(post.getTitulo());
					});
		}catch (Exception e){
			log.error(e);
			//System.out.println(e.getMessage());
		}

		 */

		/*
		postComponent.getPost().forEach(p ->{
			System.out.println(p.getDescripcion());
		});
		 */
	}
}
