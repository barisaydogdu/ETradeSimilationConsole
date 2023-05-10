import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserManager {
    private List<User> userList;




    public UserManager() {
        userList = new ArrayList<>();

    }

    public void registerUser(String name, String surname, String email, String password) throws Exception {
        // TÜM ALANLARIN DOLU OLUP OLMADIĞINI KONTROL EDİYOR
        if (name.isBlank() || surname.isBlank() || email.isBlank() || password.isBlank()) {
            throw new Exception("Tüm alanlar zorunludur.");
        }

        // E-POSTA ADRESİNİN DOĞRULUĞUNU KONTROL EDİYOR
        if (!isValidEmailAddress(email)) {
            throw new Exception("Geçerli bir e-posta adresi giriniz.");
        }

        // PAROLANIN UZUNLUĞU KONTROL EDİLİR
        if (password.length() < 6) {
            throw new Exception("Parola en az 6 karakterden oluşmalıdır.");
        }

        // KULLANICININ DAHA ÖNCE KAYIT EDİLİP EDİLMEDİĞİ KONTROL EDİLİR
        if (isUserRegistered(email)) {
            throw new Exception("Bu e-posta adresi zaten kayıtlı.");
        }

        // BÜTÜN KONTROLLER SAĞLANDIKTAN SONRA KULLANICI KAYIT EDİLİR
        try
        {
            User user = new User(name, surname, email, password);
            userList.add(user);
            System.out.println("Kullanıcı kaydedildi.");
        }
        catch (Exception e){
            throw new Exception("Bir hata oluştu");
        }



    }

    private String generateVerificationCode() {
        // DOĞRULAMA KODUNU OLUŞTURAN ALGORİTMALAR BURADA YER ALACAK
        // ÖRNEK OLARAK UUID SINIFINI KULLANILDI
        return UUID.randomUUID().toString();
    }

    private void sendVerificationEmail(User user) {
        String email = user.getEmail();
        String code = user.getConfirmed();
    }
    public boolean isUserRegistered(String email) {
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidEmailAddress(String email) {
        String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "douloop\\.com$";
        return email.matches(emailPattern);
    }
}
