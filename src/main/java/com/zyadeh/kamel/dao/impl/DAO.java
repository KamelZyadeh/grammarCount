package com.zyadeh.kamel.dao.impl;

import com.zyadeh.kamel.entities.Text;
import com.zyadeh.kamel.exceptions.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static com.zyadeh.kamel.statics.ConstantHolder.STRING_INSERT;

public class DAO extends com.zyadeh.kamel.dao.DAO<Text> {

    @Override
    public boolean update(Text entity) throws DAOException {
        return false;
    }

    @Override
    public int insert(Text entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(STRING_INSERT)) {
            preparedStatement.setString(1, entity.getText());
            preparedStatement.executeUpdate();
            return getLastInsertId();
        } catch (SQLException e) {
            System.out.println("error dao" + e.getMessage());
            throw new DAOException("couldn't insert the text to DB");
        }
    }

    public Text selectAll() throws DAOException {
        Text text = new Text();
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from text order by id desc limit 1")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                text.setText(resultSet.getString("txt"));
                text.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            throw new DAOException("getting text back from db");
        }
        return text;
    }

    @Override
    public void delete(Text entity) throws DAOException {

    }

    @Override
    public Text selectById(int id) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from text WHERE id = (?)")) {
            System.out.println("in actual dao" + id);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Text text = new Text();
                text.setText(resultSet.getString("txt"));
                text.setId(resultSet.getInt("id"));
                System.out.println("printing text in dao " + text.getText());
                System.out.println("printing text ... in dao " + text.getText().toString());
                System.out.println(text.getId());
                return text;
            }
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Text> select() throws DAOException {
        return null;
    }

    @Override
    protected int getLastInsertId() throws DAOException {
        try (Statement statement = connection.createStatement()) {
            String query = String.format("SELECT currval(pg_get_serial_sequence('%s','id'))", "text");
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return resultSet.getInt("currval");
            }
            throw new DAOException("no Id has ben founded");
        } catch (SQLException e) {
            throw new DAOException("no Id has ben founded");
        }
    }
}
