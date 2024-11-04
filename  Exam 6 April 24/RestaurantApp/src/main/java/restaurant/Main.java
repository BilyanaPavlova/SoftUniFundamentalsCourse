package restaurant;

import restaurant.core.Controller;
import restaurant.core.ControllerImpl;
import restaurant.core.Engine;
import restaurant.core.EngineImpl;
import restaurant.models.waiter.FullTimeWaiter;
import restaurant.models.waiter.Waiter;

public class Main {

    public static void main(String[] args) {
        //TODO
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();


    }
}
