package com.example.grading;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Scanner;
import java.io.*;

@RestController
public class MainController {

    @RequestMapping("/")
    public String showGrade(){
        String response = "";
        try {
            File gradesFile = new File ("/home/student/IdeaProjects/grading/src/main/resources/StudentGrades");
            FileReader fileReader = new FileReader(gradesFile);
            BufferedReader reader = new BufferedReader(fileReader);
/*            String expectedGrade = "";
            Scanner keyboard = new Scanner(System.in);
            expectedGrade = keyboard.nextLine();
            System.out.println();
            System.out.println(reader.readLine());
            response = "I expect to get " + expectedGrade;*/
            StringBuffer rpt = new StringBuffer();
            String line = null;

            while ( (line = reader.readLine()) != null) {
                rpt.append(line + "<br/>");
            }
//            response = reader.readLine();
            response = rpt.toString();
//            System.out.println(response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return response;
    }
}

