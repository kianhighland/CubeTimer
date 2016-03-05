public class Constants{

    public static final String normalText = (char)27 + "[0m" + (char)27
        + "[40m" + (char)27 + "[37m";
    public static final String runner = "Runner";
    public static final String slash = "/";
    public static final String q = "q";
    public static final String quit = "/q";
    public static final String chatMode = (char)27 + "[35m" + (char)27 + "[1m"
        + runner + "|chat> " + (char)27 + "[33m";
    public static final String commandMode = (char)27 + "[35m" + (char)27
        + "[1m" + runner + "|command> " + normalText + (char)27 + "[33m";
    public static final String runnerChat = (char)27 + "[33m";
    public static final String runnerActions = (char)27 + "[31m";
    public static final String actionsPrompts = (char)27 + "[31m" + (char)27
        + "[1m";
}
