package lk.ijse.easy.service;

import lk.ijse.easy.dto.IncomeDTO;

import java.util.ArrayList;

public interface IncomeService {
    ArrayList<IncomeDTO> dailyIncome();
    ArrayList<IncomeDTO> monthlyIncome();
    ArrayList<IncomeDTO> AnnuallyIncome();
}
