package br.com.fiap.dasa.dao.impl;

import br.com.fiap.dasa.config.ConnectionFactory;
import br.com.fiap.dasa.dao.ExameDAO;
import br.com.fiap.dasa.model.Exame;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;


public class ExameDAOImpl implements ExameDAO {
    @Override
    public Long create(Exame e) {
        String sql = "INSERT INTO exame (tipo,data,status,paciente_id) VALUES (?,?,?,?)";
        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, e.getTipo());
            ps.setDate(2, Date.valueOf(e.getData()));
            ps.setString(3, e.getStatus());
            ps.setLong(4, e.getPacienteId());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) { if (rs.next()) return rs.getLong(1); }
            return null;
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }


    @Override public Optional<Exame> findById(Long id) {
        try (Connection c = ConnectionFactory.getConnection(); PreparedStatement ps = c.prepareStatement("SELECT * FROM exame WHERE id=?")) {
            ps.setLong(1, id); try (ResultSet rs = ps.executeQuery()) { if (rs.next()) return Optional.of(map(rs)); }
            return Optional.empty();
        } catch (Exception e) { throw new RuntimeException(e); }
    }


    @Override public List<Exame> findAll() {
        try (Connection c = ConnectionFactory.getConnection(); PreparedStatement ps = c.prepareStatement("SELECT * FROM exame"); ResultSet rs = ps.executeQuery()) {
            List<Exame> list = new ArrayList<>(); while (rs.next()) list.add(map(rs)); return list;
        } catch (Exception e) { throw new RuntimeException(e); }
    }


    @Override public boolean update(Exame e) {
        String sql = "UPDATE exame SET tipo=?, data=?, status=?, paciente_id=? WHERE id=?";
        try (Connection c = ConnectionFactory.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, e.getTipo()); ps.setDate(2, Date.valueOf(e.getData())); ps.setString(3, e.getStatus()); ps.setLong(4, e.getPacienteId()); ps.setLong(5, e.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }


    @Override public boolean delete(Long id) {
        try (Connection c = ConnectionFactory.getConnection(); PreparedStatement ps = c.prepareStatement("DELETE FROM exame WHERE id=?")) {
            ps.setLong(1, id); return ps.executeUpdate() > 0;
        } catch (Exception e) { throw new RuntimeException(e); }
    }


    private Exame map(ResultSet rs) throws Exception {
        return new Exame(
                rs.getLong("id"), rs.getString("tipo"), rs.getDate("data").toLocalDate(), rs.getString("status"), rs.getLong("paciente_id")
        );
    }
}