package task_1.test;

import com.epam.training.olga_glovatska.task_1.page.PasteBinMainPage;
import com.epam.training.olga_glovatska.task_1.page.PasteBinResultPage;
import org.junit.jupiter.api.Test;

import static com.epam.training.olga_glovatska.task_1.util.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasteBinMainPageTest extends BaseTest{

    @Test
    public void createNewPasteTest(){
        PasteBinMainPage page = new PasteBinMainPage(webDriver);

        PasteBinResultPage result = page.openPage()
                .setPasteText(PASTE_TEXT)
                .selectPasteExpiration(PASTE_EXPIRATION)
                .setPasteTitle(PASTE_TITLE)
                .createNewPaste();

        assertEquals(PASTE_TEXT, result.getPasteText());
        assertEquals(PASTE_TITLE, result.getPasteTitle());
        assertEquals(EXPECTED_EXPIRATION, result.getExpiration());
    }
}
