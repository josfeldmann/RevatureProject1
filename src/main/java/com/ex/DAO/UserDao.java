package com.ex.DAO;

import com.ex.Models.Reimbursement;
import com.ex.Models.User;
import com.ex.Utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;


public class UserDao {


    //Employee Methods

    /**
     * Creates user object and adds it to the database via hibernate
     * @param userName email string
     * @param password password unhashed
     *
     * @param firstName user first name
     * @param lastName use last name
     * @return
     */
    public boolean CreateEmployee(String userName, String password, String firstName, String lastName){
        Transaction transaction = null;
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAccountType(1);

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save user object
            session.save(user);

            //close
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Returns a list of all current employees
     * @return
     */
    public List<User> GetEmployees(){
        Transaction transaction = null;
        List<User> users = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            users = session.createCriteria(User.class).list();

            return users;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return users;
    }

    /**
     * Checks if a given user exists in the database
     * @param userName
     * @return
     */
    public boolean UserNameExists(String userName){


        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = (User) session.createQuery("FROM User U WHERE U.username = :userName").setParameter("userName", userName)
                    .uniqueResult();
            if (user == null) {
                return false;
            } else return true;



        } catch (Exception e) {
            if (transaction != null) {

            }
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Changes the user's information in the database
     * @param id identifies user
     * @param userName new username
     * @param password password, leave blank or null to not change
     * @param firstName new first name
     * @param lastName new last name
     */
    public void UpdateUser(int id, String userName, String password, String firstName, String lastName){

        Transaction transaction = null;

        User currentUser = GetUser(id);
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            currentUser.setUsername(userName);
            if (password != null && password != "") {
                currentUser.setPassword(password);
            }
            currentUser.setFirstName(firstName);
            currentUser.setLastName(lastName);
            session.update(currentUser);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Get user based on id
     * @param id
     * @return
     */
    public User GetUser(int id) {

        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = (User) session.createQuery("FROM User U WHERE U.id = :id").setParameter("id", id)
                    .uniqueResult();

            if (user != null) {
                return user;
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get user based on username
     * @param userName
     * @return
     */
    public User GetUser(String userName) {

        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = (User) session.createQuery("FROM User U WHERE U.username = :userName").setParameter("userName", userName)
                    .uniqueResult();

            if (user != null) {
                return user;
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Makes sure username and password combination exists in the database
     * @param userName
     * @param password
     * @return
     */
    public User validate(String userName, String password) {

        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = (User) session.createQuery("FROM User U WHERE U.username = :userName").setParameter("userName", userName)
                    .uniqueResult();

            if (user != null && user.getPassword().equals(password)) {
                return user;
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    //Reimbursement

    /**
     * Gets all reimbursements for a user specified by a user ID
     * @param id user id
     * @return
     */
    public List<Reimbursement> GetReimbursementsForUser(int id){
        Transaction transaction = null;
        List r = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            r =  session.createQuery("FROM Reimbursement R WHERE R.owner_id = :id").setParameter("id", id).getResultList();

            if (r != null) {
                return r;
            }

        } catch (Exception e) {
            if (transaction != null) {
                //transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets all reimbursements with the pending status in the db
     * @return
     */
    public List<Reimbursement> GetAllPendingReimbursements(){
        Transaction transaction = null;
        List r = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            r =  session.createQuery("FROM Reimbursement R WHERE R.status = :status").setParameter("status", Reimbursement.PENDING).getResultList();

            if (r != null) {
                return r;
            }

        } catch (Exception e) {
            if (transaction != null) {
                //transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets a specific Reimbursement based on a transaction id
     * @param id transaction id
     * @return
     */
    public Reimbursement GetReimbursement(int id){
        Transaction transaction = null;
        Reimbursement rem = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            rem = (Reimbursement) session.createQuery("FROM Reimbursement R WHERE R.id = :id").setParameter("id", id)
                    .uniqueResult();

            if (rem != null) {
                return rem;
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Approves a specific reimbursement by changing its status to Approved
     * @param transactionID
     * @param managerID
     * @return
     */
    public boolean ApproveReimbursement(int transactionID, int managerID){

        Transaction transaction = null;

        Reimbursement rem = GetReimbursement(transactionID);
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            rem.setStatus(Reimbursement.APPROVED);
            rem.setManagerID(managerID);
            session.update(rem);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Denies a specific reimbursement by changing its status to Denied
     * @param transactionID
     * @param managerID
     * @return
     */
    public boolean DenyReimbursement(int transactionID, int managerID){

        Transaction transaction = null;

        Reimbursement rem = GetReimbursement(transactionID);
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            rem.setStatus(Reimbursement.DENIED);
            rem.setManagerID(managerID);
            session.update(rem);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Create a new Reimbursement of status pending
     * @param ownerid user id of owner
     * @param purpose string that describes purpose of the reimbursement
     * @param amount amount in dollars of the reimbursement
     * @return
     */
    public boolean ApplyForReimbursement(int ownerid, String purpose, float amount){
        Transaction transaction = null;
        Reimbursement r = new Reimbursement();
        r.setManagerID(-1);
        r.setOwnerID(ownerid);
        r.setPurpose(purpose);
        r.setAmount(amount);
        r.setStatus(Reimbursement.PENDING);

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save user object
            session.save(r);

            //close
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    //Testing

    /**
     * Deletes all reimbursements for a specific user
     * @param id
     */
    public void ClearReimbursementsFor(int id){
        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            Query query = session.createQuery("delete Reimbursement where owner_id = :id");
            query.setParameter("id", id);
            int result = query.executeUpdate();
            transaction.commit();
        }
    }

    /**
     * Deletes a user from the database
     * @param userName
     */
    public void RemoveUserName(String userName) {

        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            Query query = session.createQuery("delete User where username = :user");
            query.setParameter("user", userName);
            int result = query.executeUpdate();
            transaction.commit();
        }
    }

}