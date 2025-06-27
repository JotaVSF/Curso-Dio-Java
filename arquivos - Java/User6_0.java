import java.util.Objects;

public class User {

    private int id;

    private String name;

    public User() {
    }

    public User(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format("{'id':%s, 'name': %s", id, name);
    }

    @Override
    // equals Verifica se dois objetos são realmente "iguais"
    public boolean equals(final Object obj){
        if (obj == this) return true;
        if (obj == null || !(obj instanceof User)) return false;

        User user = (User) obj;
        return this.id == user.getId() && Objects.equals(user.getName(), this.name);
    }

    @Override
    public int hashCode(){ // hashCode Localiza rapidamente um objeto em estruturas como HashSet
        return Objects.hash(this.id, this.name);
    }
}