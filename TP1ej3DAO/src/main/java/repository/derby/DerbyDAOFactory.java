package repository.derby;

import dao.PersonDAO;
import factory.ConnectionDerby;

import factory.DAOFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class DerbyDAOFactory extends DAOFactory {


    @Override
    public PersonDAO createPersonDAO() throws SQLException {
        return new DerbyDAOFactory(ConnectionDerby.getInstance().getConnection());
    }



}
