import java.util.List;

public class Zoo {
   private List<Animals1> animalsList;

    public List<Animals1> getAnimalsList() {
        return animalsList;
    }

    public void setAnimalsList(List<Animals1> animalsList) {
        this.animalsList = animalsList;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "animalsList=" + animalsList +
                '}';
    }
}
