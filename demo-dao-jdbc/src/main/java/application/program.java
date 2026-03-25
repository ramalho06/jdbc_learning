package application;

import db.DB;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Connection conn = DB.getConnection();
        DaoFactory daoFactory = new DaoFactory(conn);
        int nCase = sc.nextInt();
        SellerDao sellerDao = daoFactory.createSellerDao();
        Department department = new Department(2, null);
        Seller seller;

        List<Seller> list;

        switch (nCase) {

            case 1:
                seller = sellerDao.findById(3);
                System.out.println(seller);
                System.out.println("=====FIND BY DEPARTMENT_ID=====");

                list = sellerDao.findByDepartment(department);
                System.out.println(list);
                break;

            case 2:
                System.out.println("======LIST ALL======");
                list = sellerDao.findAll();
                for (Seller s : list) {
                    System.out.println(s);
                    System.out.println("-----------------");
                }
                break;

            case 3:
                System.out.println("=========INSERT=========");

                Seller seller1 = new Seller(null, "Greg", "greg@gmail.com", LocalDate.of(1999, 8, 8), department, 4000.0);
                sellerDao.insert(seller1);
                System.out.println("new id = " + seller1.getId());
                break;

            case 4:
                System.out.println("==========UPDATE==========");
                seller = sellerDao.findById(1);
                seller.setName("Martha Waine");
                sellerDao.update(seller);
                System.out.println("update completed!!!!!");
                break;

            case 5:
                System.out.println("============REMOVE===========");
                System.out.print("ID to remove: ");
                int n = sc.nextInt();
                System.out.println();
                sellerDao.deleteById(n);
                System.out.println("Delete completed");
                break;

            default:
                System.out.println("erro");
                break;
        }
        sc.close();
        DB.closeConnection();
    }

}
