package com.tng.tntierverwaltung.logic.db;


import com.tng.tntierverwaltung.model.Tier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DBManager {

    //region Konstanten
    private static DBManager instance;
    private static final String PORT = "3306";
    private static final String USERNAME = "root";
    private static final String SERVER_IP = "localhost";
    private static final String PW = "";
    private static final String CONNECTION_PROTOCOL = "jdbc:mariadb://";
    private static final String DB_NAME = "/tierverwaltung";
    private static final String CONNECTION_URL = CONNECTION_PROTOCOL+SERVER_IP+DB_NAME;

    private TierDao tierDao;
    // endregion

    //region Attribute
    //endregion

    //region Konstruktoren
    private DBManager() {
        tierDao = new TierDao();
    }
    //endregion

    //region Methoden
    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    public Connection getConnection () throws SQLException {
        return DriverManager.getConnection(CONNECTION_URL, USERNAME, PW);
    }

    public void insert(Tier tier){
        tierDao.create(tier);
    }

    public void delete(Tier tier){
        tierDao.delete(tier);
    }

    public void update(Tier tier){
        tierDao.update(tier);
    }

    public List<Tier> fetchALL (){
        return tierDao.readAll();
    }
    //endregion
}
