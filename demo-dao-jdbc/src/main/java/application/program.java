package application;

import com.sun.source.tree.TryTree;
import com.sun.source.tree.WhileLoopTree;
import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.entities.Department;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class program {

    public static void main(String[] args) {

        Department obj = new Department(1, "Books");
        System.out.println(obj);
    }

}
