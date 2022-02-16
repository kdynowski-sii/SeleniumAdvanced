package models;


import enums.PolUsa;

public class User {
    private boolean offersFromPartners, dataPrivacy, newsletter, owu;
    private String socialTitle, firstName, lastName, email, password, birthDate, address, city, zipCode;
    private PolUsa country; //stores country values - ie. 14 for poland and 21 for usa

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getSocialTitle() {
        return socialTitle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public boolean isOffersFromPartners() {
        return offersFromPartners;
    }

    public boolean isDataPrivacy() {
        return dataPrivacy;
    }

    public boolean isNewsletter() {
        return newsletter;
    }

    public boolean isOwu() {
        return owu;
    }

    public PolUsa getCountry() {
        return country;
    }

    public static final class UserBuilder{
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String birthDate;
        private boolean offersFromPartners, dataPrivacy, newsletter, owu;
        private String socialTitle;
        private String address = "TestAddress", city = "TestCity", zipCode = "88-123";
        private PolUsa country = PolUsa.POLAND;


        public UserBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public UserBuilder setZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public UserBuilder setCountry(PolUsa country) {
            this.country = country;
            return this;
        }

        public UserBuilder setSocialTitle(String socialTitle) {
            this.socialTitle = socialTitle;
            return this;
        }

        public UserBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setBirthDate(String birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public UserBuilder setOffersFromPartners(boolean offersFromPartners) {
            this.offersFromPartners = offersFromPartners;
            return this;
        }

        public UserBuilder setDataPrivacy(boolean dataPrivacy) {
            this.dataPrivacy = dataPrivacy;
            return this;
        }

        public UserBuilder setNewsletter(boolean newsletter) {
            this.newsletter = newsletter;
            return this;
        }

        public UserBuilder setOwu(boolean owu) {
            this.owu = owu;
            return this;
        }

        public User build(){
            User user = new User();
            user.socialTitle = this.socialTitle;
            user.firstName = this.firstName;
            user.lastName = this.lastName;
            user.email = this.email;
            user.password = this.password;
            user.birthDate = this.birthDate;
            user.offersFromPartners = this.offersFromPartners;
            user.dataPrivacy = this.dataPrivacy;
            user.newsletter = this.newsletter;
            user.owu = this.owu;
            user.address = this.address;
            user.city = this.city;
            user.zipCode = this.zipCode;
            user.country = this.country;
            return user;
        }
    }
}
