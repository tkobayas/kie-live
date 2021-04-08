package com.sample;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsTestWithControlFact {

    public static void main(String[] args) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kcontainer = ks.getKieClasspathContainer();
        KieBase kbase = kcontainer.getKieBase();
        KieSession ksession = kbase.newKieSession();
        
    //    ksession.addEventListener(new DebugRuleRuntimeEventListener());
    //    ksession.addEventListener(new DebugAgendaEventListener());

        Order order = new Order(1, "Guitar", 6000, 0);
        

        ksession.insert(order);
        ksession.insert(new ControlFact());

        ksession.fireAllRules();


        System.out.println("==== Rule finished");
        
        ksession.dispose();

    }
}
