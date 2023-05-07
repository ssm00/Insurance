package insurance;

import utils.ConnectErrorException;
import utils.EmptyValueException;
import utils.InvalidInputException;

import java.util.*;

public class Insurance {

	private int coverageAmount;
	private String coverageEvent;
	private int coveragePeriod;
	private String coverageTarget;
	private int insuranceFee;
	private int insuranceID;
	private String insuranceName;
	private PremiumRate premiumRate;

	public Insurance(int coverageAmount, String coverageEvent, int coveragePeriod, String coverageTarget, int insuranceFee, String insuranceName) throws EmptyValueException{
		this.coverageAmount = coverageAmount;
		this.coverageEvent = coverageEvent;
		this.coveragePeriod = coveragePeriod;
		this.coverageTarget = coverageTarget;
		this.insuranceFee = insuranceFee;
		this.insuranceName = insuranceName;
		this.insuranceID = UUID.randomUUID().hashCode();
		List<String> missingFields = new ArrayList<>();
		if (coverageAmount <= 0) {
			missingFields.add("보상금액");
		}
		if (coveragePeriod <= 0) {
			missingFields.add("보장기간");
		}
		if (coverageEvent == null || coverageEvent.isEmpty()) {
			missingFields.add("보장사건");
		}
		if (coverageTarget == null || coverageTarget.isEmpty()) {
			missingFields.add("보장대상");
		}
		if (insuranceFee <= 0) {
			missingFields.add("보험료");
		}
		if (insuranceName == null || insuranceName.isEmpty()) {
			missingFields.add("상품명");
		}
		if (!missingFields.isEmpty()) {
			String message = String.format("%s 정보를 입력하지 않았습니다.", String.join(", ", missingFields));
			throw new EmptyValueException(message);
		}
		//checkEmptyValue(coverageAmount, coverageEvent, coveragePeriod, coverageTarget, insuranceFee, insuranceName);
	}


	public boolean authorize() throws InvalidInputException, ConnectErrorException, EmptyValueException {
		System.out.println("1. 인가하기");
		System.out.println("2. 임시저장하기");
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		if (line.equals("1")) {
			System.out.println("1. 연결성공");
			System.out.println("2. 연결실패");
			String connection = scanner.nextLine();
			if (connection == null || insuranceName.isEmpty()) {
				throw new EmptyValueException("정보를 입력하지 않았습니다.");
			}
			if (connection.equals("1")) {
				System.out.println("상품이 인가되었습니다");
				return true;
			} else if (connection.equals("2")) {
				throw new ConnectErrorException("금융감독원과의 연결이 되지않았습니다. 다시 시도하십시오.");
			}else {
				throw new InvalidInputException("입력은 1 혹은 2 입니다.");
			}
		} else if (line.equals("2")) {
			//임시저장
			return true;
		} else {
			throw new InvalidInputException("입력은 1 혹은 2 입니다.");
		}
	}

	public float calculateRate(){
		this.premiumRate = new PremiumRate(coverageAmount,coverageEvent,coveragePeriod, coverageTarget, insuranceFee);
		return premiumRate.calculate();
	}

	/**
	 * refactoring 질문
	 */
//	private static void checkEmptyValue(int coverageAmount, String coverageEvent, int coveragePeriod, String coverageTarget, int insuranceFee, String insuranceName) throws EmptyValueException {
//		List<String> missingFields = new ArrayList<>();
//		if (coverageAmount <= 0) {
//			missingFields.add("보상금액");
//		}
//		if (coveragePeriod <= 0) {
//			missingFields.add("보장기간");
//		}
//		if (coverageEvent == null || coverageEvent.isEmpty()) {
//			missingFields.add("보장사건");
//		}
//		if (coverageTarget == null || coverageTarget.isEmpty()) {
//			missingFields.add("보장대상");
//		}
//		if (insuranceFee <= 0) {
//			missingFields.add("보험료");
//		}
//		if (insuranceName == null || insuranceName.isEmpty()) {
//			missingFields.add("상품명");
//		}
//		if (!missingFields.isEmpty()) {
//			String message = String.format("%s 정보를 입력하지 않았습니다.", String.join(", ", missingFields));
//			throw new EmptyValueException(message);
//		}
//	}

}
