package secure.legit.data;

public enum Action {
    CREATION("created"),
    DELETION("deleted");
    public String value;

    Action(String value) {
        this.value = value;
    }
}
