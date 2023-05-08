package utils;

public class NoExpiredContractException extends Exception{
    public NoExpiredContractException() {
        super("만료된 계약이 없습니다.");
    }
}
