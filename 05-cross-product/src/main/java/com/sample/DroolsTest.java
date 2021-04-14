package com.sample;

import org.drools.core.reteoo.ReteDumper;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsTest {

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
            ksession.insert(new Customer("customer" + i, i));
        }
        for (int i = 0; i < 1000; i++) {
            ksession.insert(new Product("product" + i, i * 10));
        }
        
        Order order = new Order(1, 6000);

        ksession.insert(order);

        ksession.fireAllRules();

        System.out.println("---- finish");

        ksession.dispose();

    }
}
