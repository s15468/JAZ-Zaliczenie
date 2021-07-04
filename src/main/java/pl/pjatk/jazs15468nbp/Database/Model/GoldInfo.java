package pl.pjatk.jazs15468nbp.Database.Model;

import pl.pjatk.jazs15468nbp.Database.Enums.MineralType;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class GoldInfo
{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private MineralType mineraltype;
    private LocalDate startdate;
    private LocalDate enddate;
    private double mineralvalue;
    private LocalDateTime requestdate;

    public int getId() {
        return id;
    }

    public double getMineralvalue() {
        return mineralvalue;
    }

    public LocalDate getEnddate() {
        return enddate;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public LocalDateTime getRequestdate() {
        return requestdate;
    }

    public String getMineraltype() {
        return mineraltype.toString();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }

    public void setMineraltype(MineralType mineraltype) {
        this.mineraltype = mineraltype;
    }

    public void setMineralvalue(double mineralvalue) {
        this.mineralvalue = mineralvalue;
    }

    public void setRequestdate(LocalDateTime requestdate) {
        this.requestdate = requestdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }
}
