class ProgUtil {
    static void handleException(Exception e) {
        ProgUtil.print("Error:");
        ProgUtil.print(e.toString());
        ProgUtil.print("Stack Trace:");
        ProgUtil.print(e.fillInStackTrace().toString());
    }

    static <T> void print(T printThis) {
        System.out.println(printThis);
    }
}
