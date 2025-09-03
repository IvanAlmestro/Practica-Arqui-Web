package repository.mysql;

import dao.PersonDAO;
import factory.ConnectionMySQL;
import factory.DAOFactory;

import java.sql.SQLException;

public class MySQLDAOFactory extends DAOFactory {
    @Override
    public PersonDAO createPersonDAO() throws SQLException {
        return new MySQLPersonDAO (ConnectionMySQL.getInstance().getConnection());
    }



}
