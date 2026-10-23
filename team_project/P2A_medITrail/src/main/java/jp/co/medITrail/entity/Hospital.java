package jp.co.medITrail.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hospitals")
public class Hospital {

    @Id
    @Column(name="hos_id")
    private Integer hosId;
    
    @Column(name="hos_name")
    private String hosName;

	public Integer getHosId() {
		return hosId;
	}

	public void setHosId(Integer hosId) {
		this.hosId = hosId;
	}

	public String getHosName() {
		return hosName;
	}

	public void setHosName(String hosName) {
		this.hosName = hosName;
	}

}