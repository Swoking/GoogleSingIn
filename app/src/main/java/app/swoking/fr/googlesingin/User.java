package app.swoking.fr.googlesingin;

import app.swoking.fr.googlesingin.Game.Character;

public class User {

    private String  email;
    private boolean hasCharacter;

    public User(){
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean HasCharacter() {
        return hasCharacter;
    }

    public void setHasCharacter(boolean hasCharacter) {
        this.hasCharacter = hasCharacter;
    }
}
