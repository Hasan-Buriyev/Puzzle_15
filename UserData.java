package Project.Puzzle_15;

import javax.annotation.processing.Generated;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserData {
    private final UUID id = UUID.randomUUID();
    private String username;
    private int skill;
    private int remainingOpportunity;
    private String today;

    public UserData(String username, int skill, int remainingOpportunity, String today) {
        this.username = username;
        this.skill = skill;
        this.remainingOpportunity = remainingOpportunity;
        this.today = today;
    }

    public static boolean write(String url, UserData data) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(url))) {
            List<UserData> userData = read(url);
            if (userData == null) {
                userData = new ArrayList<>();
            }
            userData.add(data);
            outputStream.writeObject(userData);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static List<UserData> read(String url) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(url))) {
            return (List<UserData>) inputStream.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getRemainingOpportunity() {
        return remainingOpportunity;
    }

    public void setRemainingOpportunity(int remainingOpportunity) {
        this.remainingOpportunity = remainingOpportunity;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }

    @Override
    public String toString() {
        return ", username = '" + username +
                ", skill = " + skill +
                ", remainingOpportunity = " + remainingOpportunity +
                ", today = '" + today;
    }
}
