import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;

public class ParserHTML {
    public static void main(String[] args) throws IOException {
        File html = new File("test_html.html");
        Document document = Jsoup.parse(html, "UTF-8");
        document.outputSettings().syntax(Document.OutputSettings.Syntax.html);
        Element fullNameElements = document.selectFirst("p.full_name");

        String[] fullName = fullNameElements.text().split(" ");

        if (fullName.length < 4) successfullyPrint(fullName);
        else unsuccessfullyPrint();

    }

    private static void successfullyPrint(String... fullName) {
        String surname, firstname, patronymic;

        System.out.print("Ура! Мы нашли ");
        switch (fullName.length) {
            case (1) :
                firstname = fullName[0];
                System.out.printf("имя: %s!", firstname);
                break;
            case (2) :
                surname = fullName[0];
                firstname = fullName[1];
                System.out.printf("фамилию: %s, имя: %s!", surname, firstname);
                break;
            case (3) :
                surname = fullName[0];
                firstname = fullName[1];
                patronymic = fullName[2];
                System.out.printf("фамилию: %s, имя: %s, отчество: %s!", surname, firstname, patronymic);
                break;
        }
    }

    private static void unsuccessfullyPrint() {
        System.out.println("Упс! Кажется, что-то слишком сложное :(");
    }
}
