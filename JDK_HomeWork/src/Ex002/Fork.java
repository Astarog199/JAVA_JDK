package Ex002;

public class Fork {
    public Action action;
    public enum Action{
        used, notUsed
    }

    public Action getAction(){
        return action;
    }
}
