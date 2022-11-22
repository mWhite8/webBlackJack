package uta.cse3310;

public class ServerEvent {
    //PlayerType YouAre; 
    int GameId;
    


    public enum UserEventType {
        NAME, STAND, HIT, CALL;

        private UserEventType() {
        }
    };

    UserEventType event;
    int playerID;
    String name;

    public ServerEvent() {
    }




}
