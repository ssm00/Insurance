package ServerIF;

import Domain.Compensation;

import java.rmi.Remote;
import java.util.ArrayList;

public interface CompensationIF extends Remote {
    Compensation createCompensation(int compensationId, int compensationMoney, int damage, int evaluation);
    //Data
    void createCompensation(Compensation compensation);
    void updateCompensation(Compensation beforeCompensation, Compensation afterCompensation);
    void deleteCompensation(Compensation compensation);
    ArrayList<Compensation> retrieveAllCompensation();
    Compensation retrieveCompensation();
}
