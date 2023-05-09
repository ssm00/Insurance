package utils;

public class LoadingTimeException extends Exception {
    public LoadingTimeException() {
        super("시스템에 장애가 발생하였습니다. 관리자에게 문의 하십시오.");
    }

}
