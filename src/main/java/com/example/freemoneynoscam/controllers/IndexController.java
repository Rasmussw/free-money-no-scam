package com.example.freemoneynoscam.controllers;

import com.example.freemoneynoscam.repository.EmailRepository;
import com.example.freemoneynoscam.services.ValidateEmailServic;
import com.example.freemoneynoscam.services.saveInDB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.tags.form.ButtonTag;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class IndexController {
    private EmailRepository emailRepository = new EmailRepository();

    @GetMapping("/")
    public String index(Model getOneEmail) throws SQLException{
        String email = emailRepository.fetchSingleEmail();

        getOneEmail.addAttribute("oneEmail", email);

        return "index";
    }

    @GetMapping("/emails")
    public String mail(Model getAllEmails) throws SQLException {
        ArrayList<String> emails = emailRepository.getAllEmailFromDB();

        getAllEmails.addAttribute("allEmails", emails);
        return "email";
    }

    @GetMapping("/succes")
    public String succes(){
        return "succes";
    }


        @PostMapping("/test")
    public String test(WebRequest dataFromForm){
        dataFromForm.getParameter("email");

        saveInDB.connectDB();
        saveInDB.insertMail(dataFromForm.getParameter("email"),
                ValidateEmailServic.isEmailValid1(dataFromForm.getParameter("email")));
        return "redirect:/succes";
    }
}