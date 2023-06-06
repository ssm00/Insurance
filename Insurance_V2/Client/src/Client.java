import Domain.*;
import ServerIF.*;
import utils.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Client {
    InsuranceIF insuranceServer;
    UwIF uwServer;
    CompensationIF compensationServer;
    DemandIF demandServer;
    CustomerIF customerServer;
    ContractIF contractServer;
    SaleIF saleServer;
    public Client() throws MalformedURLException, NotBoundException, RemoteException {
        insuranceServer = (InsuranceIF) Naming.lookup("//localhost:1010/InsuranceServer");
        uwServer = (UwIF) Naming.lookup("//localhost:3030/UwServer");
        compensationServer = (CompensationIF) Naming.lookup("//localhost:2020/CompensationServer");
        demandServer = (DemandIF) Naming.lookup("//localhost:5050/DemandServer");
        customerServer = (CustomerIF) Naming.lookup("//localhost:6060/CustomerServer");
        contractServer = (ContractIF) Naming.lookup("//localhost:8080/ContractServer");
        saleServer = (SaleIF) Naming.lookup("//localhost:9090/SaleServer");

    }
    public static void main(String[] args) throws NotBoundException, IOException {
        BufferedReader objectReader = new BufferedReader(new InputStreamReader(System.in));
        Client client = new Client();
        try {
            while (true) {
                client.printMenu();
                String sChoice = objectReader.readLine().trim();
                switch (sChoice) {
                    case "1":
                        client.printContractMenu(objectReader);
                        break;
                    case "2":
                        client.printCompensationMenu(objectReader);
                        break;
                    case "3":
                        client.printMarketingMenu(objectReader);
                        break;
                    case "4":
                        client.createDemand(objectReader);
                        break;
                    case "x":
                        return;
                    default:
                        System.out.println("Invaild choice !!!");
                }
            }
        } catch (IOException | SaveFailedException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createDemand(BufferedReader objectReader) throws IOException, SaveFailedException {

        System.out.println("*********************MENU********************");
        System.out.println("1. 보험금 청구");
        System.out.println("x. 나가기");
        String sChoice = objectReader.readLine().trim();
        try{
            switch(sChoice) {
                case "1":
                    System.out.println("가입한 보험ID를 입력해주세요.");
                    String demandID = objectReader.readLine().trim();
                    System.out.println("고객 이름을 입력해주세요.");
                    String customerName = objectReader.readLine().trim();
                    System.out.println("사고 날짜를 입력해주세요.");
                    String accidentDate = objectReader.readLine().trim();
                    System.out.println("사고 종류를 입력해주세요.");
                    String accidentType = objectReader.readLine().trim();
                    System.out.println("세부사항을 입력해주세요.");
                    String details = objectReader.readLine().trim();
                    System.out.println("신분증를 첨부해주세요.");
                    String copyofIdentification = objectReader.readLine().trim();
                    System.out.println("진단서를 첨부해주세요.");
                    String diagnosis = objectReader.readLine().trim();
                    System.out.println("증빙서류를 첨부해주세요.");
                    String documentaryEvidence = objectReader.readLine().trim();
                    System.out.println("병원이름을 입력해주세요.");
                    String treatmentHospital = objectReader.readLine().trim();
                    System.out.println("계좌번호를 입력해주세요.");
                    String accountNumber = objectReader.readLine().trim();
                    System.out.println("은행명을 입력해주세요.");
                    String bank = objectReader.readLine().trim();
                    System.out.println("예금주를 입력해주세요.");
                    String information = objectReader.readLine().trim();

                    if(demandID.isEmpty() || accidentDate.isEmpty()|| accidentType.isEmpty()|| copyofIdentification.isEmpty()|| details.isEmpty()
                            || diagnosis.isEmpty()|| documentaryEvidence.isEmpty()|| treatmentHospital.isEmpty()|| customerName.isEmpty()
                            || bank.isEmpty()|| information.isEmpty())
                        throw new EmptyValueException("모든 내용을 빠짐없이 입력해주세요.");
                    else{
                        demandServer.createDemand(demandID,Integer.parseInt(accidentDate),accidentType,Integer.parseInt(copyofIdentification),
                                details,diagnosis,Integer.parseInt(documentaryEvidence),treatmentHospital, customerName, accountNumber, bank, information);
                        System.out.println("정보를 저장했습니다.");
                    }
                    break;
                case "x":
                    break;
            }
        }catch (NumberFormatException e){
            throw new SaveFailedException();
        } catch (SQLException | EmptyValueException e) {
            throw new RuntimeException(e);
        }


    }

    private void printCompensationMenu(BufferedReader objectReader) {
        try {
            while (true) {
                System.out.println("1. 보상관리");
                System.out.println("2. 보상평가");
                System.out.println("3. 손해조사");
                System.out.println("4. 보상심사");

                System.out.println("x. 나가기");
                String userInput = objectReader.readLine().trim();
                switch (userInput) {
                    case "1":
                        manageCompensation(objectReader);
                        break;
                    case "2":
                        examineCompensation(objectReader);
                        break;
                    case "3":
                        investigateDamage(objectReader);
                        break;
                    case "4":
                        evaluateCompensation(objectReader);
                    case "x":
                        return;
                    default:
                        System.out.println("Invaild choice !!!");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void printMarketingMenu(BufferedReader objectReader) {
          try {
            while (true) {
                System.out.println("1. 고객정보관리");
                System.out.println("2. 회원가입");
                System.out.println("3. 영업활동관리");
                System.out.println("x. 나가기");
                String sChoice = objectReader.readLine().trim();
                switch (sChoice) {
                    case "1":
                        manageCustomers(objectReader);
                        break;
                    case "2":
                        registerCustomer(objectReader);
                        registerCustomer(objectReader);
                        break;
                    case "3":
                        manageSale(objectReader);
                        break;
                    case "x":
                        return;
                    default:
                        System.out.println("Invaild choice !!!");
                }
            }
        } catch (IOException | SaveFailedException | EmptyValueException e) {
            System.out.println(e.getMessage());
        }
            System.out.println("프로그램 종료");
    }
    private void printContractMenu(BufferedReader objectReader) {
        try {
            while (true) {
                System.out.println("1. 상품개발");
                System.out.println("2. UW");
                System.out.println("3. 계약관리");
                System.out.println("4. 계약통계");
                System.out.println("x. 나가기");
                String sChoice = objectReader.readLine().trim();
                switch (sChoice) {
                    case "1":
                        designInsurance(objectReader);
                        break;
                    case "2":
                        uwStarted(objectReader);
                        break;
                    case "3":
                        manageContracts(objectReader);
                        break;
                    case "4":
                        contractStatics(objectReader);
                        break;
                    case "x":
                        return;
                    default:
                        System.out.println("Invaild choice !!!");
                }
            }
        } catch (IOException | InvalidInputException | SaveFailedException | EmptyValueException |
                 NoExpiredContractException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private void designInsurance(BufferedReader objectReader) throws IOException, InvalidInputException {
        while (true) {
            System.out.println("1. 보장내용 입력");
            System.out.println("2. 요율 산출");
            System.out.println("3. 상품 인가");
            System.out.println("x. 나가기");
            String choiceInsuranceMenu = objectReader.readLine().trim();
            try {
                switch (choiceInsuranceMenu) {
                    case "1":
                        Insurance insurance = createInsurance(objectReader);
                        authorizeORSave(objectReader, insurance);
                        break;
                    case "2":
                        showPremiumRateMenu(objectReader);
                        break;
                    case "3":
                        authorizeInsurance(objectReader);
                        break;
                    case "x":
                        return;
                    default:
                        throw new InvalidInputException("입력은 1,2,3중 하나 입니다.");
                }
                break;
            } catch (InvalidInputException | EmptyValueException | ConnectErrorException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private void showPremiumRateMenu(BufferedReader objectReader) throws IOException, InvalidInputException {
        System.out.println("1. 상품 리스트");
        System.out.println("2. 직접 산출");
        String choiceInsuranceMenu = objectReader.readLine().trim();
        if (choiceInsuranceMenu.equals("1")) {
            showInsuranceList();
            Integer choiceNumber = readIntegerInput(objectReader, "상품번호를 입력해주세요");
            Insurance choiceInsurance = insuranceServer.retrieveAllInsurance().get(choiceNumber - 1);
            float rate = insuranceServer.calculateRate(choiceInsurance);
            printPremiumRate(rate);
        } else if (choiceInsuranceMenu.equals("2")) {
            Integer coverageAmount = readIntegerInput(objectReader, "보장금액: ");
            Integer coveragePeriod = readIntegerInput(objectReader, "보장기간: ");
            System.out.print("보장대상: ");
            String coverageTarget = objectReader.readLine().trim();
            System.out.print("보장사건: ");
            String coverageEvent = objectReader.readLine().trim();
            Integer insuranceFee = readIntegerInput(objectReader, "보험료: ");
            PremiumRate premiumRate = insuranceServer.createPremiumRate(1, coverageAmount, coverageEvent, coveragePeriod, coverageTarget, insuranceFee);
            float rate = insuranceServer.calculate(premiumRate);
            printPremiumRate(rate);
        }
    }
    private void printPremiumRate(float rate) throws RemoteException {
        System.out.println("요율은 ("+Math.round(rate*10.0)/10.0+"%) 입니다.");
    }
    private void showInsuranceList() {
        int cnt = 1;
        try {
            for (Insurance insurance : insuranceServer.retrieveAllInsurance()) {
                System.out.println(cnt+" :  "+" Name : "+insurance.getInsuranceName());
                cnt++;
            }
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        }
    }
    private void showUnAuthorizeInsurance() {
        int cnt = 1;
        try {
            for (Insurance insurance : insuranceServer.retrieveAllInsurance()) {
                if (!insurance.isAuthorize()) {
                    System.out.println(cnt+" :  "+" Name : "+insurance.getInsuranceName());
                    cnt++;
                }
            }
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        }
    }
    private void authorizeORSave(BufferedReader objectReader, Insurance insurance) throws IOException, EmptyValueException {
        while (true) {
            System.out.println("1. 상품 인가");
            System.out.println("2. 상품 임시저장");
            String authorizeChoice =  objectReader.readLine().trim();
            try {
                if(authorizeChoice.equals("1")) {
                    boolean authorized = insuranceServer.authorize(insurance);
                    if (authorized) {
                        System.out.println("상품이 인가되었습니다");
                        insuranceServer.createInsurance(insurance);
                    }
                    break;
                }
                else if(authorizeChoice.equals("2")) {
                    System.out.println("임시 상품명: ");
                    String temporalName = objectReader.readLine().trim();
                    insuranceServer.setInsuranceName(temporalName, insurance);
                    insuranceServer.createInsurance(insurance);
                    System.out.println("임시저장이 완료되었습니다.");
                    break;
                } else {
                    throw new InvalidInputException("입력은 1,2중 하나 입니다.");
                }
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            } catch (ConnectErrorException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void authorizeInsurance(BufferedReader objectReader) throws InvalidInputException, IOException, EmptyValueException, ConnectErrorException {
        showInsuranceList();
        Integer choiceNumber = readIntegerInput(objectReader, "상품번호를 입력해주세요");
        Insurance choiceInsurance = insuranceServer.retrieveAllInsurance().get(choiceNumber - 1);
        boolean authorizeState = insuranceServer.authorize(choiceInsurance);
        if (authorizeState) {
            System.out.println("상품이 인가되었습니다");
        }
    }
    private Insurance createInsurance(BufferedReader objectReader) throws IOException, InvalidInputException, EmptyValueException {
        while (true) {
            try {
                Integer insuranceID = readIntegerInput(objectReader, "보험ID: ");
                System.out.print("보장대상: ");
                String coverageTarget = objectReader.readLine().trim();
                System.out.print("보장사건: ");
                String coverageEvent = objectReader.readLine().trim();
                Integer coverageAmount = readIntegerInput(objectReader, "보상금액: ");
                Integer coveragePeriod = readIntegerInput(objectReader, "보장기간: ");
                Integer insuranceFee = readIntegerInput(objectReader, "보험료: ");
                System.out.print("보험명: ");
                String insuranceName = objectReader.readLine().trim();
                validateInsuranceInput(coverageTarget, coverageEvent, coverageAmount, coveragePeriod, insuranceFee, insuranceName);
                Insurance insurance = insuranceServer.createInsurance(insuranceID, insuranceName, coverageAmount, coverageEvent, coveragePeriod, coverageTarget, insuranceFee);
                PremiumRate premiumRate = insuranceServer.getPremiumRate(insurance);
                float rate = insuranceServer.calculate(premiumRate);
                printPremiumRate(rate);
                insuranceServer.createPremiumRate(insurance.getPremiumRate());
                return insurance;
            } catch (EmptyValueException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private void validateInsuranceInput(String coverageTarget, String coverageEvent, Integer coverageAmount, Integer coveragePeriod, Integer insuranceFee, String insuranceName) throws EmptyValueException {
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
    }
    private Integer readIntegerInput(BufferedReader objectReader, String message) throws IOException{
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(objectReader.readLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("숫자 형식으로 입력해야합니다. 다시 입력해주세요.");
            }
        }
    }
    private void manageContracts(BufferedReader objectReader) throws IOException, SaveFailedException, EmptyValueException {
        showContractsList();
        String sChoice = objectReader.readLine().trim();
        Contract selectedContract = contractServer.getContractList().get(Integer.parseInt(sChoice) - 1);
        editContract(objectReader, selectedContract);
    }
    private void registerCustomer(BufferedReader objectReader) throws IOException, EmptyValueException, NumberFormatException, SaveFailedException {
        System.out.println("ID를 입력해주세요.");
        String newCustomerID = objectReader.readLine().trim();
        System.out.println("이름을 입력해주세요.");
        String newCustomerName = objectReader.readLine().trim();
        System.out.println("주소를 입력해주세요.");
        String newCustomerAddress = objectReader.readLine().trim();
        System.out.println("직업을 입력해주세요.");
        String newCustomerJob = objectReader.readLine().trim();
        System.out.println("성별을 입력해주세요.");
        String newCustomerGender = objectReader.readLine().trim();
        System.out.println("나이를 입력해주세요.");
        String newCustomerAge = objectReader.readLine().trim();
        try{
            if(newCustomerID.isEmpty() || newCustomerName.isEmpty()
                    ||newCustomerAddress.isEmpty() || newCustomerJob.isEmpty()
                    ||newCustomerGender.isEmpty() || newCustomerAge.isEmpty()){
                throw new EmptyValueException("모든 내용을 빠짐없이 입력해주세요.");
            }else{
                customerServer.createCustomer(Integer.parseInt(newCustomerID), newCustomerName,
                        newCustomerAddress,Integer.parseInt(newCustomerAge),
                        newCustomerGender, newCustomerJob);
                System.out.println("회원가입에 성공했습니다.");
            }
        }
        catch (NumberFormatException e){
            throw new SaveFailedException();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void uwStarted(BufferedReader objectReader) throws RemoteException, IOException, InvalidInputException {
        showInsuranceList();
        Integer choiceNumber = readIntegerInput(objectReader, "상품번호를 입력해주세요");
        Insurance choiceInsurance = insuranceServer.retrieveAllInsurance().get(choiceNumber - 1);
        System.out.println("----UW 업무를 선택하세요----");
        System.out.println("1. 인수심사");
        System.out.println("2. 재보험처리");
        System.out.println("3. 손해율관리");
        UW uw = uwServer.createUW();
        String sChoice = objectReader.readLine().trim();
        switch (sChoice) {
            case "1": //인수심사
                System.out.println("인수 심사를 진행합니다.");
                boolean isAccepted = uwServer.doUnderWriting(uw, choiceInsurance);
                System.out.println("----청약서 확인----");
                System.out.println("----증권 확인----");
                if (isAccepted) {
                    System.out.println("보험 " + choiceInsurance.getInsuranceName() + "에 대한 인수 심사가 성공했습니다.");
                }
                else {
                    System.out.println("보험 " + choiceInsurance.getInsuranceName() + "에 대한 인수 심사에 실패했습니다.");
                }
                System.out.println(choiceInsurance.getInsuranceName() + ": 인수 심사가 완료되었습니다.");
                break;
            case "2"://재보험처리
                System.out.println("재보험 처리를 진행합니다.");
                boolean isValidate = uwServer.validateReinsurance(choiceInsurance);
                if (isValidate) {
                    double reinsuranceFee = uwServer.reinsuranceProcessSign(uw, choiceInsurance);
                    System.out.println(choiceInsurance.getInsuranceName() + ": 재보험 승인이 성공되었습니다. ");
                    System.out.println(choiceInsurance.getInsuranceName() + " 재보험료 : " + reinsuranceFee);
                } else {
                    System.out.println(choiceInsurance.getInsuranceName() + ": 재보험 승인에 실패했습니다. ");
                }
                System.out.println(choiceInsurance.getInsuranceName() + ": 재보험 처리가 완료되었습니다.");
                break;
            case "3"://손해율관리
                System.out.println("계산을 위한 데이터를 입력해주세요.");
                System.out.println("사고 종류 : ");
                String accidentType = objectReader.readLine().trim();
                Integer coverageLimit = readIntegerInput(objectReader, "보상한도 : ");
                Integer insuranceFee = readIntegerInput(objectReader, "보험료 : ");
                Integer paidAmount = readIntegerInput(objectReader, "지급된 보상액 : ");
                float lossRate = uwServer.calculateLossRate(accidentType,coverageLimit,insuranceFee,paidAmount);
                System.out.println("계산된 손해액은 : " + lossRate +" 입니다.");
                break;
            case "x":
                return;
            default:
                System.out.println("Invaild choice!");
        }
    }
    private void printMenu() {
        System.out.println("*********************MENU********************");
        System.out.println("1. 계약");
        System.out.println("2. 보상");
        System.out.println("3. 마케팅");
        System.out.println("4. 보험금 청구");
        System.out.println("x. 종료하기");
    }
    private void contractStatics(BufferedReader objectReader) throws IOException, NoExpiredContractException, SQLException {
        showContractsList();
        System.out.println("*********************MENU********************");
        System.out.println("1. 만료된 계약 찾기");
        System.out.println("x. 나가기");
        String sChoice = objectReader.readLine().trim();
        switch(sChoice){
            case "1":
                showExpiredContract();
                break;
            case "x":
                return;
            default:
                System.out.println("올바르지 않은 입력입니다.");
                break;
        }
    }
    private  void manageSale(BufferedReader objectReader) throws IOException, EmptyValueException, NumberFormatException, SaveFailedException {
        System.out.println("*********************MENU********************");
        System.out.println("1. 영업활동 내역서 작성");
        System.out.println("x. 나가기");
        String sChoice = objectReader.readLine().trim();
        try{
            switch(sChoice) {
                case "1":
                    System.out.println("고객ID를 입력해주세요.");
                    String customerID = objectReader.readLine().trim();
                    System.out.println("직원ID를 입력해주세요.");
                    String employeeID = objectReader.readLine().trim();
                    System.out.println("보험ID를 입력해주세요.");
                    String insuranceID = objectReader.readLine().trim();
                    if(customerID.isEmpty() || employeeID.isEmpty()|| insuranceID.isEmpty())
                        throw new EmptyValueException("모든 내용을 빠짐없이 입력해주세요.");
                    else{
                        saleServer.createSale(Integer.parseInt(customerID), employeeID,
                                Integer.parseInt(insuranceID));
                        System.out.println("정보를 저장했습니다.");
                    }
                    break;
                case "x":
                    break;
            }
        }catch (NumberFormatException e){throw new SaveFailedException();} catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void showExpiredContract() throws NoExpiredContractException, SQLException, RemoteException {
        boolean checkExpired = false;
        int count = 1;
        System.out.println("--------------만료된 계약---------------------");
        for(Contract contract: contractServer.getExpiredContractList()){
            System.out.println(count + ".");
            System.out.println("계약ID: "+contract.getContractID());
            System.out.println("보험ID: "+contract.getInsuranceID());
            System.out.println("보험료: "+contract.getInsuranceFee());
            System.out.println("보험만료일: "+contract.getExpirationDate());
            System.out.println("보험보장 세부사항: "+contract.getCoverageDetails());
            System.out.println("-------------------------------------------------------------");
            checkExpired = true;
            ++count;
        }
        if(!checkExpired){throw new NoExpiredContractException();}
    }
    private  void manageCustomers(BufferedReader objectReader) throws IOException, EmptyValueException, IndexOutOfBoundsException, NumberFormatException, SaveFailedException {
        showCustomerList();
        String sChoice = objectReader.readLine().trim();
        Customer selectedCustomer = customerServer.getCustomerList().get(Integer.parseInt(sChoice) - 1);
        editCustomer(objectReader, selectedCustomer);
    }
    private void editCustomer(BufferedReader objectReader, Customer selectedCustomer) throws IOException, EmptyValueException, SaveFailedException {
        System.out.println("ID: "+selectedCustomer.getCustomerID());
        System.out.println("이름: "+selectedCustomer.getCustomerName());
        System.out.println("주소: "+selectedCustomer.getAddress());
        System.out.println("직업: "+selectedCustomer.getJob());
        System.out.println("성별: "+selectedCustomer.getGender());
        System.out.println("나이: "+selectedCustomer.getAge());
        System.out.println("*********************MENU********************");
        System.out.println("1. 고객 정보 수정");
        System.out.println("x. 나가기");
        String sChoice = objectReader.readLine().trim();
        try{
            switch(sChoice){
                case "1":
                    System.out.println("수정할 이름 입력해주세요.");
                    String newCustomerName = objectReader.readLine().trim();
                    System.out.println("수정할 주소를 입력해주세요.");
                    String newCustomerAddress = objectReader.readLine().trim();
                    System.out.println("수정할 직업을 입력해주세요.");
                    String newCustomerJob = objectReader.readLine().trim();
                    System.out.println("수정할 성별을 입력해주세요.");
                    String newCustomerGender = objectReader.readLine().trim();
                    System.out.println("수정할 나이를 입력해주세요.");
                    String newCustomerAge = objectReader.readLine().trim();

                    if(newCustomerName.isEmpty()
                            ||newCustomerAddress.isEmpty() || newCustomerJob.isEmpty()
                            ||newCustomerGender.isEmpty() || newCustomerAge.isEmpty()){
                        throw new EmptyValueException("모든 내용을 빠짐없이 입력해주세요.");
                    }else{
                        customerServer.updateCustomer(selectedCustomer.getCustomerID(),
                                0, newCustomerName,
                                newCustomerAddress,Integer.parseInt(newCustomerAge),
                                newCustomerGender, newCustomerJob);
                        System.out.println("고객정보를 저장했습니다.");
                    }
                    break;
                case "x":
                    return;
                default:
                    System.out.println("올바르지 않은 입력입니다.");
                    break;
            }
        }catch (NumberFormatException e){throw new SaveFailedException();}
        catch (SQLException e) {throw new RuntimeException(e);}
    }
    private void editContract(BufferedReader objectReader, Contract selectedContract) throws IOException, EmptyValueException, SaveFailedException {
        System.out.println("계약ID: " + selectedContract.getContractID());
        System.out.println("보험ID: " + selectedContract.getInsuranceID());
        System.out.println("보험료: " + selectedContract.getInsuranceFee());
        System.out.println("보험만료일: " + selectedContract.getExpirationDate());
        System.out.println("보험보장 세부사항: " + selectedContract.getCoverageDetails());
        System.out.println("*********************MENU********************");
        System.out.println("1. 계약 정보 수정하기");
        System.out.println("x. 나가기");
        String sChoice = objectReader.readLine().trim();
        switch (sChoice) {
            case "1":
                System.out.println("수정할 보험료를 입력해주세요.");
                String newInsuranceFee = objectReader.readLine().trim();
                System.out.println("수정할 보험만료일(yyyyMMdd)을 입력해주세요.");
                String newExpirationDate = objectReader.readLine().trim();
                System.out.println("수정할 보험보장 세부사항을 입력해주세요.");
                String newCoverageDetails = objectReader.readLine().trim();
                try {
                    if (newInsuranceFee.isEmpty()
                            || newCoverageDetails.isEmpty() || newExpirationDate.isEmpty()) {
                        throw new EmptyValueException("모든 내용을 빠짐없이 입력해주세요.");
                    } else {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                        contractServer.updateContract(selectedContract.getContractID(),
                                0, 0,Integer.parseInt(newInsuranceFee),
                                simpleDateFormat.parse(newExpirationDate), newCoverageDetails);
                        System.out.println("계약정보를 저장했습니다.");
                    }
                    break;
                } catch (NumberFormatException | ParseException e) {System.out.println("저장에 실패했습니다. 다시 시도해주세요.");} catch (
                        SQLException e) {
                    throw new RuntimeException(e);
                }
            case "x":
                return;
            default:
                System.out.println("올바르지 않은 입력입니다.");
                break;}
    }
    private void showContractsList() throws RemoteException {
        int count = 1;
        System.out.println("-------------------------계약 목록---------------------------");
        for(Contract contract: contractServer.getContractList()){
            System.out.println(count + ".");
            System.out.println("계약ID: "+contract.getContractID());
            System.out.println("보험ID: "+contract.getInsuranceID());
            System.out.println("보험료: "+contract.getInsuranceFee());
            System.out.println("-------------------------------------------------------------");
            ++count;
        }
    }
    private void showCustomerList() throws RemoteException {
        int count = 1;
        System.out.println("-------------------------고객 목록---------------------------");
        for(Customer customer: customerServer.getCustomerList()){
            System.out.println(count + ".");
            System.out.println("ID: "+customer.getCustomerID());
            System.out.println("이름: "+customer.getCustomerName());
            System.out.println("-------------------------------------------------------------");
            ++count;}
    }
    private void evaluateCompensation(BufferedReader objectReader) throws ConnectErrorException, IOException, EmptyValueException, SQLException {
        try {
            showCompensationList();
            System.out.println("===========보상 심사============");
        } catch (ConnectErrorException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n원하는 보상의 번호를 입력하시오: ");
        String compensationNumber = objectReader.readLine().trim();
        Compensation selectedCompensation = compensationServer.retrieveAllCompensation().get(Integer.parseInt(compensationNumber) - 1);
        try {
            System.out.println("\n=============선택된 보상============");
            System.out.println("보상금: " + selectedCompensation.getCompensationMoney());
            System.out.println("손해액: " + selectedCompensation.getDamage());
        } catch (NullPointerException e) {
            throw new EmptyValueException("해당 자동차 보험에 대하여 산정된 보상 내역이 존재하지 않습니다.");
        }
        System.out.println("1. 결제 요청");
        System.out.println("x. 취소");
        String userInput = objectReader.readLine().trim();
        switch (userInput) {
            case "1":
                confirm(objectReader, selectedCompensation);
                break;
            case "x":
                return;
            default:
                System.out.println("잘못된 입력입니다.");
        }
    }
    private void confirm(BufferedReader objectReader, Compensation selectedCompensation) throws IOException, ConnectErrorException, EmptyValueException, SQLException {
        System.out.println("해당 자동차 보험에 대한 심사 결재를 요청드립니다.");
        System.out.println("-------------------------------------------------------------");
        System.out.println("보상 ID: " + selectedCompensation.getCompensationId());
        System.out.println("보상금: " + selectedCompensation.getCompensationMoney());
        System.out.println("손해액: " + selectedCompensation.getDamage());
        System.out.println("1. 심사 승인 후 결재 확인");
        System.out.println("2. 거절");
        System.out.println("x. 취소");
        String userInput = objectReader.readLine().trim();
        switch (userInput) {
            case "1":
                System.out.println("보상 심사가 완료되었습니다. 확인 부탁드립니다.");
                payCompensation(objectReader);
                break;
            case "2":
                System.out.println("보상 심사가 거절되었습니다.");
            case "x":
                return;
            default:
                System.out.println("잘못된 입력입니다.");
        }
    }
    private void payCompensation(BufferedReader objectReader) throws ConnectErrorException, IOException, SQLException {
        System.out.println("==========보상금 지급===========");
        Demand demand = demandServer.getDemandList().get(0);
        System.out.println("고객명" + demand.getCustomerName());
        System.out.println("계좌번호" + demand.getAccountNumber());
        System.out.println("은행명" + demand.getBank());
        System.out.println("예금주 정보" + demand.getInformation());
        System.out.println("1. 보상금 지급");
        System.out.println("x. 취소");
        String userInput = objectReader.readLine().trim();
        if (userInput == "1") {
            System.out.println("청구된 보상금이 입금되었습니다.");
            return;
        }
        if (userInput == "x") {
            System.out.println("모든 변경 사항을 취소합니다.\n확인");
            return;
        }
    }
    private void investigateDamage(BufferedReader objectReader) throws ConnectErrorException, IOException {
        System.out.println("==============손해 조사===============");
        int count = 1;
        System.out.println("-------------접수 목록--------------");
        try {
            for (Demand demand: demandServer.getDemandList()) {
                System.out.println(count + ". ");
                System.out.println("ID: " + demand.getDemandId());
                System.out.println("고객 이름: " + demand.getCustomerName());
                System.out.println("사고 유형: " + demand.getAccidentType());
                System.out.println("사고 날짜(yyyymmdd): " + demand.getAccidentDate());
                System.out.println("진단명: " + demand.getDiagnosis());
                System.out.println("치료 병원: " + demand.getTreatmentHospital());
                System.out.println("###############################################\n");
                ++count;
            }
        } catch (NullPointerException e) {
            throw new ConnectErrorException("시스템에 장애가 발생하였습니다. 관리자에게 문의하십시오.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("지급책임이 있습니까?");
        System.out.println("1. 예");
        System.out.println("2. 아니오");
        String userInput = objectReader.readLine().trim();
        if (userInput == "1") {
            System.out.println("지급 금액을 입력하십시오");
            String compensation = objectReader.readLine().trim();
            System.out.println(compensation + "원을 지급합니다.");
            System.out.println("신청하신 사고 내역의 손해 조사 및 보험금 산정이 완료되었습니다.");
            return;
        }
        if (userInput == "2") {
            System.out.println("지급 불가 사유를 입렧하십시오");
            String denial = objectReader.readLine().trim();
            System.out.println(denial + " 사유로 인하여 보험금 지급이 불가합니다.");
            return;
        }
    }
    private void examineCompensation(BufferedReader objectReader) throws ConnectErrorException, IOException {
        System.out.println("==============보상 평가===============");
        showCompensationList();
        System.out.println("\n평가할 보상의 번호를 입력하시오: ");
        String compensationNumber = objectReader.readLine().trim();
        Compensation selectedCompensation = compensationServer.retrieveAllCompensation().get(Integer.parseInt(compensationNumber) - 1);
        System.out.println("\n=============선택된 보상, 변경 전============");
        System.out.println("점수: " + selectedCompensation.getEvaluation());
        System.out.println("점수를 입력하십시오.(0~10)");
        int newEvaluation = Integer.parseInt(objectReader.readLine().trim());
        if (newEvaluation <= 10 && newEvaluation >= 0) {
            Compensation afterCompensation = compensationServer.createCompensation(selectedCompensation.getCompensationId(),
                    selectedCompensation.getCompensationMoney(), selectedCompensation.getDamage(), newEvaluation);
            compensationServer.updateCompensation(selectedCompensation,afterCompensation);
        } else {
            System.out.println("유효하지 않은 입력입니다.");
        }
    }
    private void manageCompensation(BufferedReader objectReader) throws ConnectErrorException, IOException {
        System.out.println("==============보상 관리===============");
        showCompensationList();
        System.out.println("\n==============원하시는 작업을 선택하시오.===============");
        System.out.println("1. 보상 수정");
        System.out.println("2. 보상 폐기");
        System.out.println("x. 나가기");
        String userInput = objectReader.readLine().trim();
        switch (userInput) {
            case "1":
                editCompensation(objectReader);
                System.out.println("수정 완료");
                showCompensationList();
                break;
            case "2":
                deleteCompensation(objectReader);
                System.out.println("폐기 완료");
                showCompensationList();
                break;
            case "x":
                return;
            default:
                System.out.println("잘못된 입력입니다.");
        }
    }
    private void editCompensation(BufferedReader objectReader) throws IOException, ConnectErrorException {
        System.out.println("\n관리할 보상의 번호를 입력하시오: ");
        String compensationId = objectReader.readLine().trim();
        Compensation selectedCompensation = compensationServer.retrieveAllCompensation().get(Integer.parseInt(compensationId) - 1);
        System.out.println("\n=============선택된 보상, 변경 전============");
        System.out.println("보상금: " + selectedCompensation.getCompensationMoney());
        System.out.println("손해액: " + selectedCompensation.getDamage());
        System.out.println("\n=============선택된 보상, 변경 후============");
        System.out.println("보상금: ");
        int newCompensationMoney = Integer.parseInt(objectReader.readLine().trim());
        System.out.println("손해액: ");
        int newDamage = Integer.parseInt(objectReader.readLine().trim());
        System.out.println("1. 수정");
        System.out.println("2. 취소");
        String userInput = objectReader.readLine().trim();
        if (userInput.equals("1")) {
            Compensation updateCompensation = compensationServer.createCompensation(selectedCompensation.getCompensationId(), newCompensationMoney,
                    newDamage, selectedCompensation.getEvaluation());
            compensationServer.updateCompensation(selectedCompensation,updateCompensation);
            return;
        }
        if (userInput.equals("2")) {
            System.out.println("모든 변경 사항을 취소합니다.\n확인");
            manageCompensation(objectReader);
            return;
        }
    }
    private void deleteCompensation(BufferedReader objectReader) throws IOException {
        Integer compensationNumber = readIntegerInput(objectReader, "폐기할 보상의 번호를 입력하세요 : ");
        Compensation compensation = compensationServer.retrieveAllCompensation().get(compensationNumber - 1);
        compensationServer.deleteCompensation(compensation);
    }
    private void showCompensationList() throws ConnectErrorException {
        int count = 1;
        System.out.println("-------------보상 목록--------------");
        try {
            for (Compensation compensation: compensationServer.retrieveAllCompensation()) {
                System.out.println(count + ". ");
                System.out.println("보상 ID: " + compensation.getCompensationId());
                System.out.println("보상금: " + compensation.getCompensationMoney());
                System.out.println("손해액: " + compensation.getDamage());
                System.out.println("###############################################\n");
                ++count;
            }
        } catch (NullPointerException e) {
            throw new ConnectErrorException("불러오기에 실패했습니다.\n확인");
        }
    }
    private void showList(ArrayList<?> dataList) throws RemoteException {
        String list = "";
        for(int i=0; i<dataList.size(); i++) {
            list += dataList.get(i) + "\n";
        }
        System.out.println(list);
    }
}
