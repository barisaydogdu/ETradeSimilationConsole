public class User {
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private boolean confirmed;
        private String confirmCode;


        public User()
        {

        }

        public User(String firstName, String lastName, String email, String password) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.email = email;
                this.password = password;
        }


        public String getFirstName() {

                return firstName;
        }

        public void setFirstName(String firstName) {
                if(firstName.length()<2 ){
                        throw  new IllegalArgumentException("Ad en az iki karakterden oluşmalıdır");
                }
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                if (lastName.length() < 2) {
                        throw new IllegalArgumentException("Soyad en az 2 karakterden oluşmalıdır.");
                }
                this.lastName = lastName;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }
        public void isConfirmed(boolean confirmed)
        {
                this.confirmed=confirmed;
        }
        public void setConfirmed(boolean confirmed)
        {
                this.confirmed=confirmed;
        }
        public String getConfirmed()
        {
                return  confirmCode;
        }
        public void setConfirmCode(String confirmCode)
        {
                this.confirmCode=confirmCode;
        }


}
