// Step 1: Observer Interface
import java.util.*;

interface Observer {
    void update();
}

// Step 2: Subject Interface
interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers();
}

// Step 3: ConcreteSubject (Publisher)
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String subjectState;

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

    public String getState() {
        return subjectState;
    }

    public void setState(String state) {
        this.subjectState = state;
        notifyObservers();  // Important: notify when state changes
    }
}

// Step 4: ConcreteObserver (Subscriber)
class ConcreteObserver implements Observer {
    private String observerState;
    private ConcreteSubject subject;

    public ConcreteObserver(ConcreteSubject subject) {
        this.subject = subject;
        subject.attach(this); // Auto-attach to subject
    }

    @Override
    public void update() {
        // Sync with subject’s state
        this.observerState = subject.getState();
        System.out.println("Observer updated, new state: " + observerState);
    }
}

// Step 5: Demo
public class ObserverPatternDemo {
    public static void main(String[] args) {
        // Create subject
        ConcreteSubject subject = new ConcreteSubject();

        // Create observers
        Observer obs1 = new ConcreteObserver(subject);
        Observer obs2 = new ConcreteObserver(subject);

        // Change subject state
        subject.setState("State A");
        subject.setState("State B");
    }
}
