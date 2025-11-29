package crud.repository;

import crud.conn.ConnectionFactory;
import crud.dominio.Producer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProducerRepository {


    public static List<Producer> findByName(String name) {
        List<Producer> list = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = preparedStatementFindByName(conn, name);
             ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Producer producer = Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();
                list.add(producer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static Producer findById(Integer id) {
        String sql = "SELECT * FROM producer WHERE id like ? ";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Producer producer = Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();
                return producer;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static PreparedStatement preparedStatementFindByName(Connection con, String name) {
        String sql = "SELECT * FROM producer WHERE name like ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, String.format("%%%s%%", name));
            return ps;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void deleteById(int id) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = preparedStatementDeleteById(conn, id)) {

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static PreparedStatement preparedStatementDeleteById(Connection conn, int id) {
        String sql = "DELETE FROM producer WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            return ps;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static int saveProducer(String name) {
        String sql = "INSERT INTO producer (name) VALUES (?) ";
        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, name);
            ps.executeUpdate();

            try(ResultSet rs = ps.getGeneratedKeys()){
               if(rs.next()){
                   return rs.getInt(1);
               }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }


    public static void updateById(int id, String name){
        String sql = "UPDATE producer SET name = ? WHERE id = ? ";


        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, name);
            ps.setInt(2, id);
            int i = ps.executeUpdate();
            if(i == 1){
                System.out.println("Producer atualizado! \n\n");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
