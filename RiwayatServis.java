import java.util.ArrayList;
import java.util.List;
class RiwayatServis {
    private List<Servis> servisList;

    public RiwayatServis() {
        this.servisList = new ArrayList<>();
    }

    public void tambahServis(Servis servis) {
        servisList.add(servis);
    }

    public List<Servis> getServisList() {
        return servisList;
    }
}