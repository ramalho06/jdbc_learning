package model.dao;

import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;

import java.sql.Connection;

public class DaoFactory {

    private final Connection conn;

    public DaoFactory(Connection conn) {
        this.conn = conn;
    }

    public  SellerDao createSellerDao(){
        return new SellerDaoJDBC(conn);
    }
    public  DepartmentDao createDepartmentDao(){
        return new DepartmentDaoJDBC(conn);
    }
}
