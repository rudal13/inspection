package carSales;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

@Entity
@Table(name="Inspection_table")
public class Inspection {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long carId;
    private Integer carYear;
    private Integer carAccidentCnt;

    @PostPersist
    public void onPostPersist(){
        Inspected inspected = new Inspected();
        BeanUtils.copyProperties(this, inspected);
        inspected.publishAfterCommit();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Integer getCarYear() {
        return carYear;
    }

    public void setCarYear(Integer carYear) {
        this.carYear = carYear;
    }
    public Integer getCarAccidentCnt() {
        return carAccidentCnt;
    }

    public void setCarAccidentCnt(Integer carAccidentCnt) {
        this.carAccidentCnt = carAccidentCnt;
    }


}
