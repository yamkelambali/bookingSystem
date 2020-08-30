package com.startup.Repository.impl;

import com.startup.Repository.IRepository;
import com.startup.entity.Bill;

import java.util.Set;

/**
 * @author Michael Bezuidenhout	 * @author Michael Bezuidenhout
 */
public interface BillRepository extends IRepository<Bill, String> {
    Set<Bill> getAll();
}
