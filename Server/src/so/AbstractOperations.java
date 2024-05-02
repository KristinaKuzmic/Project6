/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import db.DBConnection;
import domain.AbstractDomainObject;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Kristina
 */
public abstract class AbstractOperations {

    protected final DBBroker broker;

    public AbstractOperations() throws  Exception {
        this.broker = new DBBroker(DBConnection.getInstance().pop());
    }

    private void startTransaction() throws Exception {
        broker.getConnection();
    }

    private void commitTransaction() throws Exception {
        broker.getConnection().commit();
    }

    private void rollbackTransaction() throws Exception {
        broker.getConnection().rollback();
    }

    private void disconnect() throws Exception {
        broker.getConnection().close();
    }

    public final void execute(Object object) throws Exception {
        try {
            preconditions(object);
            startTransaction();
            executeOperation(object);
            commitTransaction();
        } catch (Exception ex) {
            ex.printStackTrace();
            rollbackTransaction();
            throw ex;
        } finally {
            DBConnection.getInstance().push(broker.getConnection());
            disconnect();
        }
    }

    protected abstract void preconditions(Object object) throws Exception;

    protected abstract void executeOperation(Object object) throws Exception;

}
