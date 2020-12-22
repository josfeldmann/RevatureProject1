package com.ex.Tests;

import com.ex.DAO.UserDao;
import com.ex.Models.Reimbursement;
import com.ex.Models.User;
import org.junit.jupiter.api.*;

import java.util.List;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class TestDao {

    static UserDao loginDao;

    @BeforeAll
    public static void SetUp(){
        loginDao = new UserDao();
    }

    private static String dummyUserName = "test123@gmail.com";
    private static String dummyPassword = "a";
    private static String dummyFirstName = "Dummy";
    private static String dummyLastName = "User";
    private static User currentUser;
    private static Reimbursement currentReimbursement;
    private static String newFirstName = "Joe";
    @Test
    public void aTestAddUserWorks(){
            Assertions.assertEquals(loginDao.UserNameExists(dummyUserName), false);
            loginDao.CreateEmployee(dummyUserName,dummyPassword,dummyFirstName, dummyLastName);
            Assertions.assertEquals(loginDao.UserNameExists(dummyUserName), true);
            currentUser = loginDao.GetUser(dummyUserName);
            Assertions.assertEquals(currentUser.getFirstName().equals(dummyFirstName), true);
    }

    @Test
    public void bTestEmployeeList(){
        List<User> users = loginDao.GetEmployees();
        int userid = currentUser.getId();
        currentUser = null;
        for (User u: users) {
            if (u.getId() == userid) {
                currentUser = u;
            }
        }
        Assertions.assertNotEquals(currentUser, null);
        currentUser = loginDao.validate(currentUser.getUsername(), currentUser.getPassword());
        Assertions.assertEquals(currentUser.getId(), userid);
    }

    @Test
    public void bTestUpdateUser(){

        currentUser.setFirstName(newFirstName);
        loginDao.UpdateUser(currentUser.getId(),  currentUser.getUsername(), currentUser.getPassword(), currentUser.getFirstName(), currentUser.getLastName());
        currentUser = loginDao.GetUser(currentUser.getId());
        Assertions.assertEquals(currentUser.getFirstName(), newFirstName);

    }

    @Test
    public void cTestAddingReimbursement(){

        loginDao.ApplyForReimbursement(currentUser.getId(),"stuff", 0);
        List<Reimbursement> reimbursements = loginDao.GetReimbursementsForUser(currentUser.getId());
        Assertions.assertEquals(reimbursements.size(), 1);
        currentReimbursement = reimbursements.get(0);

    }

    @Test
    public void dTestApprovingAndDenying(){

        int rID = currentReimbursement.getId();
        List<Reimbursement> allReimbs = loginDao.GetAllPendingReimbursements();
        currentReimbursement = null;
        for (Reimbursement r: allReimbs) {
            if (r.getId() == rID) {
                currentReimbursement = r;
            }
        }
        Assertions.assertNotEquals(currentReimbursement, null);
        loginDao.ApproveReimbursement(currentReimbursement.getId(), 100);
        currentReimbursement = loginDao.GetReimbursement(rID);
        Assertions.assertEquals(currentReimbursement.getStatus(), Reimbursement.APPROVED);
        loginDao.DenyReimbursement(currentReimbursement.getId(),100);
        currentReimbursement = loginDao.GetReimbursement(rID);
        Assertions.assertEquals(currentReimbursement.getStatus(), Reimbursement.DENIED);

    }




    @AfterAll
    public static void CleanUp(){
        int userID = currentUser.getId();
        loginDao.ClearReimbursementsFor(userID);
        loginDao.RemoveUserName(dummyUserName);
    }

}
