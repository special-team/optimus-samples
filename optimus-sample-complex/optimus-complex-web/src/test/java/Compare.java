import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class Compare {

    private static final String DIR = System.getProperty("user.dir");
    private static final String FILE_PATH = "/optimus-client-web/src/main/webapp/portal/";
    private static final String REFERENCE_FILE_CREATE = "/optimus-client-web/src/main/webapp/template/create.html";
    private static final String REFERENCE_FILE_UPDATE = "/optimus-client-web/src/main/webapp/template/update.html";
    private static final String REFERENCE_FILE_DETAIL = "/optimus-client-web/src/main/webapp/template/detail.html";
    private static final String REFERENCE_FILE_BROWSE = "/optimus-client-web/src/main/webapp/template/browse.html";
    private static final String REFERENCE_FILE_UNKNOW = "/optimus-client-web/src/main/webapp/template/sample.html";
    //@formatter:off
    private static final String IGNORE_BEGIN_STYLES = "<!-- BEGIN PAGE STYLES -->";
    private static final String IGNORE_END_STYLES = "<!-- END PAGE STYLES -->";
    private static final String IGNORE_BEGIN_PAGE_CONTENT = "<!-- BEGIN OPTIMUS CONTENT -->";
    private static final String IGNORE_END_PAGE_CONTENT = "<!-- END OPTIMUS CONTENT -->";
    private static final String IGNORE_BEGIN_MODAL = "<!-- BEGIN MODAL -->";
    private static final String IGNORE_END_MODAL = "<!-- END MODAL -->";
    private static final String IGNORE_BEGIN_PLUGINS = "<!-- BEGIN PAGE PLUGINS -->";
    private static final String IGNORE_END_PLUGINS = "<!-- END PAGE PLUGINS -->";
    private static final String IGNORE_BEGIN_SCRIPT = "<!-- BEGIN PAGE SCRIPT -->";
    private static final String IGNORE_END_SCRIPT = "<!-- END PAGE SCRIPT -->";
    private static final String IGNORE_BEGIN_SCRIPT_FUNCTION = "<!-- BEGIN SCRIPT FUNCTION -->"; // X
    private static final String IGNORE_END_SCRIPT_FUNCTION = "<!-- END SCRIPT FUNCTION -->";   // X
    private static final String IGNORE_BEGIN_SCRIPT_JQUERY = "<!-- BEGIN SCRIPT JQUERY -->";   // X
    private static final String IGNORE_END_SCRIPT_JQUERY = "<!-- END SCRIPT JQUERY -->";     // X
    //
    private static final String TYPE_CREATE = "<!-- BEGIN HEAD | CREATE -->";
    private static final String TYPE_UPDATE = "<!-- BEGIN HEAD | UPDATE -->";
    private static final String TYPE_DETAIL = "<!-- BEGIN HEAD | DETAIL -->";
    private static final String TYPE_BROWSE = "<!-- BEGIN HEAD | BROWSE -->";
    //@formatter:on

    public static void main(String[] args) throws Exception {
        Compare compare = new Compare();
        File file = new File(DIR + FILE_PATH);
        System.out.println(file.getAbsolutePath());
        compare.compare(file);
    }

    private static String encode(boolean t) {
        if (t) {
            return "[O        ]";
        } else {
            return "[X =======]";
        }
    }

    private void compare(File file) throws Exception {
        if (file.isDirectory()) {
            //noinspection ConstantConditions
            for (File f : file.listFiles()) {
                compare(f);
            }
        } else if (file.isFile()) {
            Strut s1 = read(file);
            Strut s0;
            switch (s1.type) {
                case TYPE_CREATE:
                    s0 = read(new File(DIR + REFERENCE_FILE_CREATE));
                    break;
                case TYPE_UPDATE:
                    s0 = read(new File(DIR + REFERENCE_FILE_UPDATE));
                    break;
                case TYPE_DETAIL:
                    s0 = read(new File(DIR + REFERENCE_FILE_DETAIL));
                    break;
                case TYPE_BROWSE:
                    s0 = read(new File(DIR + REFERENCE_FILE_BROWSE));
                    break;
                default:
                    s0 = read(new File(DIR + REFERENCE_FILE_UNKNOW));
                    break;
            }
            System.out.println(encode(Objects.equals(s0.content, s1.content)) + " :::: " + file);
        }
    }

    private Strut read(File file) {
        StringBuilder content = new StringBuilder();
        String type = "UNKNOW";
        try {
            List<String> lines = Files.readAllLines(Paths.get(file.toURI()));
            for (String temp : lines) {
                boolean ignore = false;
                temp = temp.trim();
                if (Objects.equals(temp, TYPE_CREATE) || Objects.equals(temp, TYPE_UPDATE) || Objects.equals(temp, TYPE_DETAIL) || Objects.equals(temp, TYPE_BROWSE)) {
                    type = temp;
                }
                if (Objects.equals(temp, IGNORE_BEGIN_PLUGINS)
                    || Objects.equals(temp, IGNORE_BEGIN_STYLES)
                    || Objects.equals(temp, IGNORE_BEGIN_SCRIPT)
                    || Objects.equals(temp, IGNORE_BEGIN_SCRIPT_FUNCTION)
                    || Objects.equals(temp, IGNORE_BEGIN_SCRIPT_JQUERY)) {
                    ignore = true;
                    //continue
                }
                if (Objects.equals(temp, IGNORE_END_STYLES)
                    || Objects.equals(temp, IGNORE_END_PAGE_CONTENT)
                    || Objects.equals(temp, IGNORE_END_MODAL)
                    || Objects.equals(temp, IGNORE_END_PLUGINS)
                    || Objects.equals(temp, IGNORE_END_SCRIPT)
                    || Objects.equals(temp, IGNORE_END_SCRIPT_FUNCTION)
                    || Objects.equals(temp, IGNORE_END_SCRIPT_JQUERY)) {
                    ignore = false;
                    //continue
                }
                if (!ignore) {
                    content.append(temp).append("\n");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("文件异常", e);
        }
        return new Strut(type, content.toString());
    }

    private class Strut {

        private String type;
        private String content;

        Strut(String type, String content) {
            this.type = type;
            this.content = content;
        }
    }
}
