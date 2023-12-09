/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ict.dao;
/**
 *
 * @author lala
 */
import ict.bean.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuditLogDAO {

    private Connection connection;

    public AuditLogDAO(Connection connection) {
        this.connection = connection;
    }

    // Retrieve AuditLog by ID from the database
    public AuditLog getAuditLogById(int logID) {
        AuditLog auditLog = null;
        String query = "SELECT * FROM AuditLog WHERE LogID = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, logID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                auditLog = new AuditLog();
                auditLog.setLogID(resultSet.getInt("LogID"));
                auditLog.setUserID(resultSet.getInt("UserID"));
                auditLog.setActivityType(resultSet.getString("ActivityType"));
                auditLog.setTimestamp(resultSet.getTimestamp("Timestamp"));
                auditLog.setDescription(resultSet.getString("Description"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return auditLog;
    }

    // Retrieve all AuditLogs from the database
    public List<AuditLog> getAllAuditLogs() {
        List<AuditLog> auditLogs = new ArrayList<>();
        String query = "SELECT * FROM AuditLog";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                AuditLog auditLog = new AuditLog();
                auditLog.setLogID(resultSet.getInt("LogID"));
                // Set other attributes here
                auditLogs.add(auditLog);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return auditLogs;
    }

    // Insert a new AuditLog into the database
    public boolean insertAuditLog(AuditLog auditLog) {
        boolean success = false;
        String query = "INSERT INTO AuditLog (LogID, UserID, ActivityType, Timestamp, Description) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, auditLog.getLogID());
            preparedStatement.setInt(2, auditLog.getUserID());
            preparedStatement.setString(3, auditLog.getActivityType());
            preparedStatement.setTimestamp(4, auditLog.getTimestamp());
            preparedStatement.setString(5, auditLog.getDescription());

            int rowsAffected = preparedStatement.executeUpdate();
            success = rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    // Update an existing AuditLog in the database
    public boolean updateAuditLog(AuditLog auditLog) {
        boolean success = false;
        String query = "UPDATE AuditLog SET UserID = ?, ActivityType = ?, Timestamp = ?, Description = ? WHERE LogID = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, auditLog.getUserID());
            preparedStatement.setString(2, auditLog.getActivityType());
            preparedStatement.setTimestamp(3, auditLog.getTimestamp());
            preparedStatement.setString(4, auditLog.getDescription());
            preparedStatement.setInt(5, auditLog.getLogID());

            int rowsAffected = preparedStatement.executeUpdate();
            success = rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    // Delete an AuditLog from the database
    public boolean deleteAuditLog(int logID) {
        boolean success = false;
        String query = "DELETE FROM AuditLog WHERE LogID = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, logID);

            int rowsAffected = preparedStatement.executeUpdate();
            success = rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }
}
