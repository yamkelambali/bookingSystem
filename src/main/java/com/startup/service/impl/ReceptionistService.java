package com.startup.service.impl;

import com.startup.entity.Receptionist;
import com.startup.service.IService;

import java.util.Set;

/**
 * @author Michael Bezuidenhout
 */

public interface ReceptionistService extends IService<Receptionist, String> {
    Set<Receptionist> getAll();
}
