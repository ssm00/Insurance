package utils;

public class NoExpiredContract extends Exception{
    public NoExpiredContract() {
        super("만료된 계약이 없습니다.");
    }
}
