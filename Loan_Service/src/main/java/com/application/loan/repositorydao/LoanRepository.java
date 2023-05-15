package com.application.loan.repositorydao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.application.loan.model.Loan_Details;


/* For update, delete or drop queries @Modifying & @Transactional annotation 
 * need to be used along with @Query */
public interface LoanRepository extends JpaRepository<Loan_Details, Long>
{}
