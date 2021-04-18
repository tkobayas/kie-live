package com.sample;

import org.drools.core.reteoo.ReteDumper;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsTest2 {

    public static void main(String[] args) {

        System.setProperty("drools.metric.logger.enabled", "true");
        System.setProperty("drools.metric.logger.threshold", "500"); // microseconds

        KieServices ks = KieServices.Factory.get();
        KieContainer kcontainer = ks.getKieClasspathContainer();
        KieBase kbase = kcontainer.getKieBase();
//        ReteDumper.dumpRete(kbase);
        
        KieSession ksession = kbase.newKieSession();

//              ksession.addEventListener(new DebugRuleRuntimeEventListener());
//              ksession.addEventListener(new DebugAgendaEventListener());

        for (int i = 0; i < 1000; i++) {
            Customer customer = new Customer("customer" + i, i * 10);
            ksession.insert(customer);
            Order order = new Order(i, i *10);
            ksession.insert(order);
        }

        // Customer goldCustomer = new Customer("John", 1000);
        // ksession.insert(goldCustomer);
        // Order specialOrder = new Order(5000, goldCustomer, 5000);
        // ksession.insert(specialOrder);

        ksession.fireAllRules();

        System.out.println("---- finish");

        ksession.dispose();

    }
}
