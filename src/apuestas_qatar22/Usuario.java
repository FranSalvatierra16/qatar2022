package apuestas_qatar22;

import java.util.Objects;

public class Usuario {
    private String user;
    private String password;
    private String email;
    private String dni;
    private Wallet billetera;

    public Usuario(String user, String password, String email, String dni) {
        this.user = user;
        this.password = password;
        this.email = email;
        this.dni = dni;
    }

    public Wallet getBilletera() {
        return this.billetera;
    }

    public void setBilletera(Wallet billetera) {
        this.billetera = billetera;
    }

    public String getUser() {
        return this.user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return this.dni;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(user, usuario.user) && Objects.equals(password, usuario.password) && Objects.equals(email, usuario.email) && Objects.equals(dni, usuario.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, password, email, dni);
    }

    @Override
    public String toString() {
        return "{" +
            " user='" + getUser() + "'" +
            ", password='" + getPassword() + "'" +
            ", email='" + getEmail() + "'" +
            ", dni='" + getDni() + "'" +
            "}";
    }

}
