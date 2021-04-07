package com.sample;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsTest {

    public static void main(String[] args) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kcontainer = ks.getKieClasspathContainer();
        KieBase kbase = kcontainer.getKieBase();
        KieSession ksession = kbase.newKieSession();
        
       ksession.addEventListener(new DebugRuleRuntimeEventListener());
       ksession.addEventListener(new DebugAgendaEventListener());

        // Person john = new Person("John", 800, 1);
       Person john = new Person("John", 1000, 1);
        
        System.out.println("--- before rule firing");
        System.out.println(john);

        ksession.insert(john);

        ksession.fireAllRules();

        System.out.println();
        System.out.println("--- after rule firing");
        System.out.println(john);

        ksession.dispose();

    }
}
