package utils;

public class SaveFailedException extends Exception{
    public SaveFailedException(){super("저장에 실패했습니다. 다시 시도해주세요.");}
}
