package com.ekonopaka.examples;

import com.ekonopaka.entity.Employee;
import com.ekonopaka.services.EmployeeService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Eugene Konopaka <dev@pritle.com>
 * @version 16-12-2016
 * @see © 2016 Pritle Holding B.V. - All Rights Reserved
 * See LICENSE file or http://pritle.com for further details
 */
public class EmployeeTest {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("H2PersistenceUnit");
        EntityManager manager = factory.createEntityManager();
        EmployeeService service = new EmployeeService(manager);

        service.createEmployee(122, "", 1L);

        Employee emp = service.findEmployee(122);
        System.out.println(emp);

        manager.close();
        factory.close();
    }
}
