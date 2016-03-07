public class Constants{

    public static final String normalText = (char)27 + "[0;40;37m";
    public static final String corp = "Corp";
    public static final String slash = "/";
    public static final String q = "q";
    public static final String quit = "/q";
    public static final String chatMode = (char)27 + "[35m" + corp + "|chat> "
        + (char)27 + "[32m";
    public static final String commandMode = (char)27 + "[35m" + corp
        + "|command> " + (char)27 + "[33m";
    public static final String corpChat = normalText + (char)27 + "[36m";
    public static final String corpActions = normalText + (char)27 + "[34m";
    public static final String actionPronpts = (char)27 + "[1;34m";
}
