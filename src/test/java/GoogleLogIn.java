import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.util.Scanner;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.byText;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * Created by dmitriy on 25.05.15.
 */
public class GoogleLogIn {

    @Test
    public void logIn() {

        String recipientEmail = "dmitriy.strashko@gmail.com";

        SelenideElement recipientBox = $(By.name("to"));
        SelenideElement subjectBox = $(By.name("subjectbox"));
        SelenideElement textBox = $("[role='textbox']");

        open("http://www.gmail.com");
        $("#Email").setValue(Config.login).pressEnter();
        $("#Passwd").setValue(Config.password).pressEnter();
        $("[gh='cm']").waitUntil(visible, 12000);
        $("[gh='cm']").click();


        recipientBox.setValue(recipientEmail);
        subjectBox.setValue("Auto test");
        textBox.setValue("test test 123");
        $(byText("Send")).click();

//      String content = new Scanner(new File("file:/home/dstrashko/GmailTest/emails.txt")).useDelimiter("\\Z").next();


    }

    public static void main(String[] args) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("emails.txt")));
    }






}
