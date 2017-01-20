package blog.services;

/**
 * Created by Jonelezhang on 1/18/17.
 */
public interface NotificationService {
    void addInfoMessage(String msg);
    void addErrorMessage(String msg);
}
