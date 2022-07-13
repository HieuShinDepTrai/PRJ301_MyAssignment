/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Group;

/**
 *
 * @author Hiếu Shin FPT
 */
public class AccountDBContext extends DBContext {

    public Account getAccountByEmailPassword(String email, String password) {
        try {
            String sql = "SELECT [user].[id] as user_id\n"
                    + "      ,[user].[name] as user_name\n"
                    + "      ,[user].[email]\n"
                    + "      ,[user].[birthday]\n"
                    + "      ,[user].[password]\n"
                    + "	     , [group].[id] as group_id\n"
                    + "	     , [group].[name] as group_name\n"
                    + "  FROM [user] Inner join [user_group] on [user].[id] = [user_group].[userid]\n"
                    + "  inner join [group] on [user_group].[groupid] = [group].[id]\n"
                    + "  WHERE [user].[email] = ? AND [user].[password] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("user_id"));
                account.setName(rs.getString("user_name"));
                account.setEmail(rs.getString("email"));
                account.setBirthday(rs.getDate("birthday"));
                account.setPassword(rs.getString("password"));
                
                Group group = new Group();
                group.setId(rs.getInt("group_id"));
                group.setName(rs.getString("group_name"));
                account.setGroup(group);
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public Boolean isInstructor(int userId) {
        try {
            PreparedStatement stm = connection.prepareStatement("select * from [user], [user_group] where [user].[id] = [user_group].[userid] and [groupid] = 1 and [user].[id] = ?");
            stm.setInt(1, userId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            
        }
        return false;
    }
}
