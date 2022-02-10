package models;

public class User {
    private String socialTitle, firstName, lastName, email, password, birthDate;
    private boolean offersFromPartners, dataPrivacy, newsletter, owu;
    public static final class UserBuilder{
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String birthDate;
        private boolean offersFromPartners, dataPrivacy, newsletter, owu;
        private String socialTitle;


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
            return user;
        }
    }
}
