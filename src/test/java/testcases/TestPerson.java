package testcases;


import com.rd.manwoman.Man;
import com.rd.manwoman.Person;
import com.rd.manwoman.Woman;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class TestPerson {
    SoftAssert softAssert = new SoftAssert();
    @Test
    @Parameters({"firstNameMan", "lastNameMan", "genderMan", "ageMan", "partnerMan", "expectedGetterFirstName", "expectedGetterLastName", "expectedGetterGender", "expectedGetterAge", "expectedGetterPartner"})
    public void testGetterCreateObject(String firstNameMan, String lastNameMan, String genderMan, int ageMan, String partnerMan, String expectedGetterFirstName, String expectedGetterLastName, String expectedGetterGender, int expectedGetterAge, String expectedGetterPartner){
        Man man = new Man(firstNameMan, lastNameMan, genderMan, ageMan, partnerMan);
        softAssert.assertEquals(man.getFirstName(), expectedGetterFirstName, "Problems with first names getter");
        softAssert.assertEquals(man.getLastName(), expectedGetterLastName, "Problems with last names getter");
        softAssert.assertEquals(man.getGender(), expectedGetterGender, "Problems with genders getter");
        softAssert.assertEquals(man.getAge(), expectedGetterAge, "Problems with age getter");
        softAssert.assertEquals(man.getPartner(), expectedGetterPartner, "Problems with partners getter");
        softAssert.assertAll();
    }
    @Test
    @Parameters({"firstNameMan", "lastNameMan", "genderMan", "ageMan", "partnerMan", "setFirstName", "setLastName", "setGender", "setAge", "setPartner", "expectedSetterFirstName", "expectedSetterLastName", "expectedSetterGender", "expectedSetterAge", "expectedSetterPartner"})
    public void testSetterCreateObject(String firstNameMan, String lastNameMan, String genderMan, int ageMan, String partnerMan, String setFirstName, String setLastName, String setGender, int setAge, String setPartner, String expectedSetterFirstName, String expectedSetterLastName, String expectedSetterGender, int expectedSetterAge, String expectedSetterPartner ){
        Man man = new Man(firstNameMan, lastNameMan, genderMan, ageMan, partnerMan);
        man.setFirstName(setFirstName);
        softAssert.assertEquals(man.getFirstName(), expectedSetterFirstName, "Problems with setter of first name");
        man.setLastName(setLastName);
        softAssert.assertEquals(man.getLastName(), expectedSetterLastName, "Problems with setter of last name");
        man.setGender(setGender);
        softAssert.assertEquals(man.getGender(), expectedSetterGender, "Problems with setter of gender");
        man.setAge(setAge);
        softAssert.assertEquals(man.getAge(), expectedSetterAge, "Problems with setter of age");
        man.setPartner(setPartner);
        softAssert.assertEquals(man.getPartner(), expectedSetterPartner, "Problems with setter of Partner");
        softAssert.assertAll();
    }
    @Test
    @Parameters({"firstNameWoman", "lastNameWoman", "genderWoman", "ageWoman", "partnerWoman", "firstNameMan", "lastNameMan", "genderMan", "ageMan", "partnerMan"})
    public void testRegisterPartnership (String firstNameWoman, String lastNameWoman, String genderWoman, int ageWoman, String partnerWoman, String firstNameMan, String lastNameMan, String genderMan, int ageMan, String partnerMan){
        Woman woman = new Woman(firstNameWoman, lastNameWoman, genderWoman, ageWoman, partnerWoman);
        Man man = new Man(firstNameMan, lastNameMan, genderMan, ageMan, partnerMan);
        woman.registerPartnership(man);
        Assert.assertEquals(man.getLastName(), woman.getLastName(), "Problems with register partnership method");
    }
    @Test
    @Parameters({"firstNameWoman", "lastNameWoman", "genderWoman", "ageWoman", "partnerWoman", "firstNameMan", "lastNameMan", "genderMan", "ageMan", "partnerMan"})
    public void testDeregisterPartnership (String firstNameWoman, String lastNameWoman, String genderWoman, int ageWoman, String partnerWoman, String firstNameMan, String lastNameMan, String genderMan, int ageMan, String partnerMan){
        Woman woman = new Woman(firstNameWoman, lastNameWoman, genderWoman, ageWoman, partnerWoman);
        Man man = new Man(firstNameMan, lastNameMan, genderMan, ageMan, partnerMan);
        String previousLastName = lastNameWoman;
        woman.registerPartnership(man);
        woman.deregisterPartnership();
        Assert.assertEquals(woman.getLastName(), previousLastName, "Problems with deregister of partnership method");
    }

    @Test
    @Parameters({"firstNameMan", "lastNameMan", "genderMan", "ageMan", "partnerMan"})
    public void testSetRetired(String firstNameMan, String lastNameMan, String genderMan, int ageMan, String partnerMan){
        Man man = new Man(firstNameMan, lastNameMan, genderMan, ageMan, partnerMan);
        Assert.assertTrue(man.isRetired(), "Problems with retired setter method");
    }
}
