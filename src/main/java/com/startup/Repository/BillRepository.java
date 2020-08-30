package com.startup.Repository;
/**
 * @author Michael Bezuidenhout
 */

import com.startup.entity.Account;
import com.startup.entity.Bill;

import java.util.Set;

public interface BillRepository extends IRepository<Bill, String> {
    Set<Bill> getAll();
}
