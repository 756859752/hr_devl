package service;

import java.util.List;

import pojo.SalaryStandardDetails;

public interface SalaryStandardDetailsService{
	public void addSalaryStandardDetails(SalaryStandardDetails SalaryStandardDetailsDetail);
	public void removeSalaryStandardDetails(short id);
	public void alterSalaryStandardDetails(SalaryStandardDetails SalaryStandardDetailsDetail);
	public SalaryStandardDetails findSalaryStandardDetailsById(short id);
	public List<SalaryStandardDetails> findAllSalaryStandardDetails();
}
