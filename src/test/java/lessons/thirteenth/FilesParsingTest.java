package lessons.thirteenth;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class FilesParsingTest {

    @Test
    void pdfParseTest() throws Exception {
        open("https://docs.junit.org/current/user-guide/");
        File downloadedPdf = $("a[href='junit-user-guide-5.13.4.pdf']").download();
        try (InputStream inputStream = new FileInputStream(downloadedPdf)) {
            PDF content = new PDF(downloadedPdf);
            assertThat(content.author).contains("Sam Brannen");
        }
    }

    ClassLoader cl = FilesParsingTest.class.getClassLoader(); // Механизм для чтения классов/файлов из ресурсов

    @Test
    void xlsxParseTest() throws Exception {
        try (InputStream resourceAsStream = cl.getResourceAsStream("Сводка по г. Волгограду.xlsx")) {
            XLS content = new XLS(resourceAsStream);
//            System.out.println(content.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue());
            assertThat(content.excel
                    .getSheetAt(0)
                    .getRow(1)
                    .getCell(1)
                    .getStringCellValue()
                    .contains("Количество сообщений сводки за выбранные сутки, если \"Вид преступления\"=\"Убийство\" и \"Раскрытие\"=\"Не раскрыто\"\n"));

        }
    }

    @Test
    void csvParseTest() throws Exception {
        try (
                InputStream resourceAsStream = cl.getResourceAsStream("example/qa_guru.csv");
                CSVReader reader = new CSVReader(new InputStreamReader(resourceAsStream)); // В одном блоке трай открыто два блока
        ) {
            List<String[]> content = reader.readAll();
            assertThat(content.get(0)[1].contains("lesson"));
        }
    }

    @Test
    void jsonParseTest() throws Exception {
        Gson gson = new Gson();
        try (
                InputStream resource = cl.getResourceAsStream("example/glossary.json");
                InputStreamReader reader = new InputStreamReader(resource)
        ) {
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            assertThat(jsonObject.get("title").getAsString()).isEqualTo("example glossary");
            assertThat(jsonObject.get("GlossDiv").getAsJsonObject().get("title").getAsString()).isEqualTo("S");
        }
    }
}
