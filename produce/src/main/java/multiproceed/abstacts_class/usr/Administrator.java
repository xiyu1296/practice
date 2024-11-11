package multiproceed.abstacts_class.usr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Administrator extends User {
    private static final Logger logger = LoggerFactory.getLogger(Administrator.class);

    public Administrator(String username, String password) {
        super(username, password, 0);
    }

    @Override
    public void showMenu() {
        try {
            logger.info("Administrator Menu: 1. Manage users 2. System Settings");
        } catch (Exception e) {
            logger.error("Error showing menu: {}", e.getMessage(), e);
        }
    }

    public void changeUserInfo() {
        try {
            logger.info("Changing user info...");
        } catch (Exception e) {
            logger.error("Error changing user info: {}", e.getMessage(), e);
        }
    }

    public void deleteUser() {
        try {
            logger.info("Deleting a user...");
        } catch (Exception e) {
            logger.error("Error deleting user: {}", e.getMessage(), e);
        }
    }

    public void addUser() {
        try {
            logger.info("Adding a user...");
        } catch (Exception e) {
            logger.error("Error adding user: {}", e.getMessage(), e);
        }
    }

    public void listUser() {
        try {
            logger.info("Listing a user...");
        } catch (Exception e) {
            logger.error("Error listing user: {}", e.getMessage(), e);
        }
    }
}
