import java.util.HashMap;
import java.util.Random;

interface Player {
    void chosenAgent(String agent);
    void mission();
}

class AttackingSide implements Player {
    String agentName;
    final String task;

    public AttackingSide() {
        task = "Planting spike...";
    }


    @Override
    public void chosenAgent(String agent) {
        this.agentName = agent;
    }

    @Override
    public void mission() {
        System.out.println("Player " + agentName + " is " + task);
    }
}

class DefendingSide implements Player{
    String agentName;
    final String task;

    public DefendingSide() {
        task = "Defusing spike...";
    }


    @Override
    public void chosenAgent(String agent) {
        this.agentName = agent;
    }

    @Override
    public void mission() {
        System.out.println("Player " + agentName + " is " + task);
    }
}

class createPlayer {
    private static HashMap<String, Player> hm = new HashMap<>();

    public static Player getPlayer(String type) {
        Player p = null;

        if (hm.containsKey(type)) {
            p = hm.get(type);
        } else {
            switch (type) {
                case "Attacking":
                    System.out.println("Attacking Player created");
                    p = new AttackingSide();
                    break;
                case "Defending":
                    System.out.println("Defending Player created");
                    p = new DefendingSide();
                    break;
            }

            hm.put(type, p);
        }

        return p;
    }
}

class Main {
    private static String[] agents = {"Sage", "Cypher", "Jett", "Neon", "Yoru", "Brimstone", "Viper"};

    static String getRandomAgent() {
        Random r = new Random();

        int rand = r.nextInt(agents.length);

        return agents[rand];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Player p = createPlayer.getPlayer("Attacking");

            p.chosenAgent(getRandomAgent());

            p.mission();
        }

        for (int i = 0; i < 5; i++) {
            Player p = createPlayer.getPlayer("Defending");

            p.chosenAgent(getRandomAgent());

            p.mission();
        }
    }
}