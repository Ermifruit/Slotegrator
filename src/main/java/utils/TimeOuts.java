package utils;

public class TimeOuts {
    public static final int PAGE_LOAD_TIMEOUT = Integer.parseInt(PropertyHelper.getProperty("timeouts.page"));
    public static final int ELEMENT_TIMEOUT = Integer.parseInt(PropertyHelper.getProperty("timeouts.element"));
}
