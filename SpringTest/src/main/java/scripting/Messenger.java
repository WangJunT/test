package scripting;

import org.springframework.beans.factory.annotation.Required;

import javax.annotation.PostConstruct;

public class Messenger {
    public Messenger() {
        System.out.println("构造");
    }

    private void init() {
        System.out.println("初始化");
    }

    @Required
    private void postCa() {
        System.out.println("postCa");
    }

}
