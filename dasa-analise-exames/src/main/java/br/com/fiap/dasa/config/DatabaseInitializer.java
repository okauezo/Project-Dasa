package br.com.fiap.dasa.config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;
import java.util.stream.Collectors;


public class DatabaseInitializer {
    public static void init() {
        try (Connection conn = ConnectionFactory.getConnection();
             Statement st = conn.createStatement()) {
            String ddl = new BufferedReader(new InputStreamReader(
                    DatabaseInitializer.class.getResourceAsStream("/schema.sql")))
                    .lines().collect(Collectors.joining("\n"));
            st.execute(ddl);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inicializar o banco", e);
        }
    }
}