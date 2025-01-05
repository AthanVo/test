package Bai12;

import java.io.Serializable;

public class TaiKhoan implements Serializable {
    private String username;
    private String password;

    // Constructor
    public TaiKhoan(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // To String Method
    @Override
    public String toString() {
        return this.getUsername() + "-" + this.getPassword();
    }

    // Kiểm tra tài khoản
    public boolean checkAccount(TaiKhoan tk) {
        if (this.username.equals(tk.getUsername()) && this.password.equals(tk.getPassword())) {
            return true; // Nếu username và password trùng khớp
        }
        return false; // Nếu không trùng khớp
    }
}
