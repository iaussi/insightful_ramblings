package selenium;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="NewUserInfo")
public class NewUserInfo {
    
	@XmlElement(name = "FirstName")
    String FirstName;
	@XmlElement(name = "LastName")
    String LastName;
	@XmlElement(name = "Gender")
    String Gender;
	@XmlElement(name = "Country")
    String Country;
	@XmlElement(name = "Phone")
    String Phone;
	@XmlElement(name = "Email")
    String Email;
	@XmlElement(name = "Password")
    String Password;


    public String getFName() {
        return FirstName;
    }


    public void setFName(String FirstName) {
        this.FirstName = FirstName;
    }
    
    public String getLName() {
        return LastName;
    }
    
    public void setLName(String LastName) {
        this.LastName = LastName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }
    
    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }
    
    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
    
    
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
   // public String toString() {
   // 	return this.toString();
   // }
} 