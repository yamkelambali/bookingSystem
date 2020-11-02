
package com.startup.Repository.impl;

import com.startup.entity.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface ReceptionistRepository extends JpaRepository<Receptionist, String>{}
