package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class program2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Connection conn = DB.getConnection();
        DaoFactory daoFactory = new DaoFactory(conn);
        DepartmentDao departmentDao = daoFactory.createDepartmentDao();

        System.out.println("1 - FIND BY ID | 2 - FIND ALL | 3 - INSERT | 4 - UPDATE | 5 - DELETE");

        int n = sc.nextInt();

        switch (n){
            case 1:
                System.out.println("=== TEST 1: findById =======");
                Department dep = departmentDao.findById(1);
                System.out.println(dep);
                break;

            case 2:
                System.out.println("\n=== TEST 2: findAll =======");
                List<Department> list = departmentDao.findAll();
                for (Department d : list) {
                    System.out.println(d);
                }
                break;

            case 3:
                System.out.println("\n=== TEST 3: insert =======");
                Department newDepartment = new Department(null, "Music");
                departmentDao.insert(newDepartment);
                System.out.println("Inserted! New id: " + newDepartment.getId());
                break;

            case 4:
                System.out.println("\n=== TEST 4: update =======");
                Department dep2 = departmentDao.findById(1);
                dep2.setName("Food");
                departmentDao.update(dep2);
                System.out.println("Update completed");
                break;

            case 5:
                System.out.println("\n=== TEST 5: delete =======");
                System.out.print("Enter id for delete test: ");
                int id = sc.nextInt();
                departmentDao.deleteById(id);
                System.out.println("Delete completed");

        }

    }

}
