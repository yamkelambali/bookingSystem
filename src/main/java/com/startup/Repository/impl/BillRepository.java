package com.startup.Repository.impl;
/**
 * @author Michael Bezuidenhout
 */

import com.startup.Repository.IRepository;
import com.startup.entity.Bill;

import java.util.Set;

public interface BillRepository extends IRepository<Bill, String> {
    Set<Bill> getAll();
}