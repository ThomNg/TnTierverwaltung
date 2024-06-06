package com.tng.tntierverwaltung.logic.db;

import com.tng.tntierverwaltung.model.Tier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class TierDao implements Dao<Tier> {

    //region Konstanten
    public static final String SQL_INSERT_TIER = "INSERT INTO tier (name, tierart, tieralter, farbe, datum) VALUES(?,?,?,?,?)";
    public static final String SQL_UPDATE_TIER = "UPDATE tier SET name = ?, tierart = ?, tieralter = ?, farbe = ?, datum = ? WHERE id = ?";
    public static final String SQL_DELETE_TIER = "DELETE FROM tier WHERE id = ?";
    public static final String SQL_ALL_QUERY = "SELECT * FROM tier";
    // endregion

    //region Attribute
    //endregion

    //region Konstruktoren
    //endregion

    //region Methoden
    @Override
    public void create(Tier tier) {
        try (
                Connection connection = DBManager.getInstance().getConnection();
                PreparedStatement preStatement = connection.prepareStatement(
                        SQL_INSERT_TIER,
                        Statement.RETURN_GENERATED_KEYS)
            ){
            preStatement.setString(1, tier.getName());
            preStatement.setString(2, tier.getTierart());
            preStatement.setInt(3, tier.getAlter());
            preStatement.setString(4, tier.getFarbe());
            preStatement.setDate(5, Date.valueOf(tier.getDate()));

            preStatement.executeUpdate(); //Statement tätigen

            // result züruck von DB
            ResultSet genKey = preStatement.getGeneratedKeys();
            if(genKey.next()){
                int id = genKey.getInt(1);
                tier.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Tier tier) {
        try (
                Connection connection = DBManager.getInstance().getConnection();
                PreparedStatement preStatement = connection.prepareStatement(
                        SQL_UPDATE_TIER)
        ){
            preStatement.setString(1, tier.getName());
            preStatement.setString(2, tier.getTierart());
            preStatement.setInt(3, tier.getAlter());
            preStatement.setString(4, tier.getFarbe());
            preStatement.setDate(5, Date.valueOf(tier.getDate()));
            preStatement.setInt(6, tier.getId());

            preStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Tier tier) {
        try (
                Connection connection = DBManager.getInstance().getConnection();
                PreparedStatement preStatement = connection.prepareStatement(
                        SQL_DELETE_TIER)
        ){
            preStatement.setInt(1, tier.getId());
            preStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Tier> readAll() {
        List<Tier> tierOut = new ArrayList<>();
        try (
                Connection connection = DBManager.getInstance().getConnection();
                PreparedStatement preStatement = connection.prepareStatement(
                        SQL_ALL_QUERY)
        ){
            // insert delete update
            //preStatement.executeUpdate();
            preStatement.execute();
            ResultSet resultSet = preStatement.getResultSet();

            while(resultSet.next()){
                Tier tier = new Tier(resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getDate(6).toLocalDate());

                tier.setId(resultSet.getInt(1));
                tierOut.add(tier);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return tierOut;
    }
    //endregion
}
