package application;

import com.sun.source.tree.TryTree;
import com.sun.source.tree.WhileLoopTree;
import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Connection conn = DB.getConnection();
        DaoFactory daoFactory = new DaoFactory(conn);

        SellerDao sellerDao = daoFactory.createSellerDao();
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("============");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        System.out.println(list);

        System.out.println("============");

        list = sellerDao.findAll();
        for (Seller s : list){
            System.out.println(s);
            System.out.println("-----------------");
        }

        System.out.println("==================");

        Seller seller1 = new Seller(null, "Greg", "greg@gmail.com", LocalDate.of(1999, 8, 8), department, 4000.0);
        sellerDao.insert(seller1);
        System.out.println("new id = " + seller1.getId());

        System.out.println("====================");

        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("update completed!!!!!");

        System.out.println("=======================");
        System.out.print("ID to remove: ");
        int n =sc.nextInt();
        System.out.println();
        sellerDao.deleteById(n);
        System.out.println("Delete completed");

        sc.close();
        DB.closeConnection();
    }

}
