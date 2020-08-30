package com.startup.Repository.impl.impl;
/**
 * @author Michael Bezuidenhout
 */

import com.startup.Repository.impl.IRepository;
import com.startup.entity.Bill;

import java.util.Set;

public interface BillRepository extends IRepository<Bill, String> {
    Set<Bill> getAll();
}
