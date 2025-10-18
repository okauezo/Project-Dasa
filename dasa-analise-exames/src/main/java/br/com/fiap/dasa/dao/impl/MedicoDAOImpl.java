package br.com.fiap.dasa.dao.impl;


import br.com.fiap.dasa.config.ConnectionFactory;
import br.com.fiap.dasa.dao.MedicoDAO;
import br.com.fiap.dasa.model.Medico;

import java.sql.*; import java.util.*;


public class MedicoDAOImpl implements MedicoDAO {
    @Override
    public Long create(Medico m) {
        try (Connection c = ConnectionFactory.getConnection()) {

            Long uid;
            try (PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO usuario (nome,email,senha,tipo) VALUES (?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, m.getNome()); ps.setString(2, m.getEmail()); ps.setString(3, m.getSenha()); ps.setString(4, "MEDICO");
                ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys()) { rs.next(); uid = rs.getLong(1);} }

            try (PreparedStatement ps = c.prepareStatement("INSERT INTO medico (id,crm,especialidade) VALUES (?,?,?)")) {
                ps.setLong(1, uid); ps.setString(2, m.getCrm()); ps.setString(3, m.getEspecialidade()); ps.executeUpdate();
            }
            return uid;
        } catch (Exception e) { throw new RuntimeException(e); }
    }


    @Override
    public Optional<Medico> findById(Long id) {
        String sql = "SELECT u.*, m.crm, m.especialidade FROM usuario u JOIN medico m ON u.id=m.id WHERE u.id=?";
        try (Connection c = ConnectionFactory.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, id); try (ResultSet rs = ps.executeQuery()) { if (rs.next()) return Optional.of(map(rs)); }
            return Optional.empty();
        } catch (Exception e) { throw new RuntimeException(e); }
    }


    @Override
    public List<Medico> findAll() {
        String sql = "SELECT u.*, m.crm, m.especialidade FROM usuario u JOIN medico m ON u.id=m.id";
        try (Connection c = ConnectionFactory.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            List<Medico> list = new ArrayList<>(); while (rs.next()) list.add(map(rs)); return list;
        } catch (Exception e) { throw new RuntimeException(e); }
    }


    @Override
    public boolean update(Medico m) {
        String su = "UPDATE usuario SET nome=?, email=?, senha=? WHERE id=?";
        String sm = "UPDATE medico SET crm=?, especialidade=? WHERE id=?";
        try (Connection c = ConnectionFactory.getConnection()) {
            try (PreparedStatement ps = c.prepareStatement(su)) {
                ps.setString(1, m.getNome()); ps.setString(2, m.getEmail()); ps.setString(3, m.getSenha()); ps.setLong(4, m.getId()); ps.executeUpdate();
            }
            try (PreparedStatement ps = c.prepareStatement(sm)) {
                ps.setString(1, m.getCrm()); ps.setString(2, m.getEspecialidade()); ps.setLong(3, m.getId());
                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) { throw new RuntimeException(e); }
    }


    @Override
    public boolean delete(Long id) {
        try (Connection c = ConnectionFactory.getConnection()) {
            try (PreparedStatement ps = c.prepareStatement("DELETE FROM medico WHERE id=?")) { ps.setLong(1, id); ps.executeUpdate(); }
            try (PreparedStatement ps = c.prepareStatement("DELETE FROM usuario WHERE id=?")) { ps.setLong(1, id); return ps.executeUpdate() > 0; }
        } catch (Exception e) { throw new RuntimeException(e); }
    }


    private Medico map(ResultSet rs) throws Exception {
        return new Medico(
                rs.getLong("id"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"), rs.getString("crm"), rs.getString("especialidade")
        );
    }
}