package com.epam.training.olga_glovatska.task_2;

import com.epam.training.olga_glovatska.task_2.page.PasteBinMainPage;
import com.epam.training.olga_glovatska.task_2.page.PasteBinResultPage;
import org.testng.annotations.Test;

import static com.epam.training.olga_glovatska.task_2.util.TestData.*;
import static org.testng.Assert.assertEquals;

public class PasteBinMainPageTest extends BaseTest {

    @Test
    public void createNewPasteTest(){
        PasteBinMainPage page = new PasteBinMainPage(webDriver);

        PasteBinResultPage result = page.openPage()
                .setPasteText(PASTE_TEXT)
                .selectPasteSyntaxHighlighting(SYNTAX_HIGHLIGHTING)
                .selectPasteExpiration(PASTE_EXPIRATION)
                .setPasteTitle(PASTE_TITLE)
                .createNewPaste();

        assertEquals(PAGE_TITLE, result.getPageTitle());
        assertEquals(SYNTAX_HIGHLIGHTING, result.syntaxHighlighting());
        assertEquals(PASTE_TEXT, result.getPasteText());
    }
}
