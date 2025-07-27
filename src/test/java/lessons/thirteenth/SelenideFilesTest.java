package lessons.thirteenth;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class SelenideFilesTest {


    //ЕСЛИ В КНОПКЕ ЭЛЕМЕНТЕ ЕСТЬ href - 99% случаев
    @Test
    void selenideDownloadTest() throws Exception {
        open("https://github.com/junit-team/junit-framework/blob/main/README.md");
        File downloadedFile = $("[data-testid=raw-button]").download();
//        InputStream inputStream = new FileInputStream(downloadedFile); //Дискрипторы файлов нужно закрывать,
        try (InputStream inputStream = new FileInputStream(downloadedFile);) { // ТрайВизРесурсес, закрое автоматом ИнпутСтрим в случае ошибки
            byte[] bytes = inputStream.readAllBytes();
            String textContent = new String(bytes, StandardCharsets.UTF_8);
            assertThat(textContent).contains("This repository is the home of JUnit Platform, Jupiter, and Vintage.");
        }
//        finally {
//            inputStream.close();
//        }
    }

//    ЕСЛИ В КНОПКЕ ЭЛЕМЕНТЕ НЕТ href
//    static {
//        Configuration.fileDownload = FileDownloadMode.PROXY;
//        //Поднимается прокси сервер между тестами и драйвером, в Селенойде не получится!
//        Configuration.downloadsFolder = "";
//        //Указание папки для загрузки
//    }

    @Test
    void selenideUploadTest() {
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/upload-download");
//        $("input[type='file']")
//                .uploadFile(new File("build/downloads/b76e898a-2cd3-44ec-9066-d473879de5cb/README.md"));
//        Так делать не надо! Все файла - часть проекта в resources!!!
        $("input[type='file']").uploadFromClasspath("example/test.jpg");
//        Загрузка из ресурсов проекта
        $("#uploadedFilePath").shouldHave(Condition.text("test.jpg"));
    }

}
