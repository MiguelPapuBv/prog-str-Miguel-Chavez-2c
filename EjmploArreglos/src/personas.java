public class personas {
    private int id;
    private String name;

    public personas() {
    }

    public int getId() {
        return id;
    }

    public personas(int id, String name) {
        this.id = id;
        this.name = name;
        this.isActive=true;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    private boolean isActive;

    @Override
    public String toString() {
        return "personas{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public boolean getisActive() {
        return true;
    }
}

