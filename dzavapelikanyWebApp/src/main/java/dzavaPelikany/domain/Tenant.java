package dzavaPelikany.domain;


import java.util.UUID;

public class Tenant extends User {

    private UUID AssigmentId;

    public UUID getAssigmentId() {
        return AssigmentId;
    }

    public void setAssigmentId(UUID assigmentId) {
        AssigmentId = assigmentId;
    }

    public Tenant(){}


    public Tenant(String login) {
        super(login);
    }
}
