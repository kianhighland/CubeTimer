public class Constants{

    public static final String normalText = (char)27 + "[0;40;37m";
    public static final String runner = "Runner";
    public static final String slash = "/";
    public static final String c = "c";
    public static final String q = "q";
    public static final String quit = "/q";
    public static final String chatMode = (char)27 + "[1;35m" + runner
        + "|chat> " + (char)27 + "[33m";
    public static final String commandMode = (char)27 + "[1;35m" + runner
        + "|command> " + normalText + (char)27 + "[33m";
    public static final String runnerChat = normalText + (char)27 + "[33m";
    public static final String runnerActions = normalText + (char)27 + "[31m";
    public static final String actionsPrompts = (char)27 + "[1;31m";
}
