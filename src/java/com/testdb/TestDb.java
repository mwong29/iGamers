/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author eventurino
 */
public class TestDb {
  public static void main(String[] args) throws Exception {
    MySqlAccess dao = new MySqlAccess();
    dao.readDataBase();
  }

}
