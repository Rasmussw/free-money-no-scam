package com.example.freemoneynoscam.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class EmailRepository {

     Connection con;

    public void connectDB()
    {
        try
        {
            String url = "jdbc:mysql://localhost:3306/test_db";
            con = DriverManager.getConnection(url,);
            System.out.println("Ok, we have a connection.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getAllEmailFromDB() throws SQLException {
        connectDB();
        ArrayList<String> emails = new ArrayList<>();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM new_table");
        ResultSet rs=ps.executeQuery();

        while (rs.next()) {
            emails.add(rs.getString(2));

        }
        return emails;
    }


    public String fetchSingleEmail() throws SQLException {
        ArrayList<String> emails = getAllEmailFromDB();
        String email = "";

        Random random = new Random();
        int randomNumber = random.nextInt(emails.size());

        email = emails.get(randomNumber);

        return email;
    }

    public static void main(String[] args) throws SQLException {
        EmailRepository emailRepository = new EmailRepository();
        emailRepository.connectDB();
        System.out.println(emailRepository.getAllEmailFromDB());
        System.out.println(emailRepository.fetchSingleEmail());
    }
}