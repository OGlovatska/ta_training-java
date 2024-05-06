package task_2.util;

public class TestData {
    public static final String PASTE_TEXT = """
            git config --global user.name  "New Sheriff in Town"
            git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
            git push origin master --force""";
    public static final String SYNTAX_HIGHLIGHTING = "Bash";
    public static final String PASTE_TITLE = "how to gain dominance among developers";
    public static final String PASTE_EXPIRATION = "10 Minutes";
    public static final String PAGE_TITLE = PASTE_TITLE + " - Pastebin.com";
}
