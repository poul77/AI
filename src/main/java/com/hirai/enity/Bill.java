package com.hirai.enity;

import jakarta.persistence.*;
//import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "bills")
//@Data // Lombok for getters/setters
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many Bills belong to One Farmer
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farmer_id", nullable = false)
    private Farmer farmer;

    @Column(nullable = false)
    private String commodityName; // e.g., "Soya Bean" or "Chana"

    @Column(precision = 10, scale = 2)
    private BigDecimal totalWeight; // in Quintals

    @Column(precision = 10, scale = 2)
    private BigDecimal dailyRate; // Rate at time of purchase

    @Column(precision = 12, scale = 2)
    private BigDecimal totalAmount; // (Weight * Rate)

    @Column(precision = 10, scale = 2)
    private BigDecimal commissionAmount; // Shop's cut

    @Column(precision = 12, scale = 2)
    private BigDecimal finalPayable; // Amount given to Farmer

    @Column(updatable = false)
    private LocalDateTime billDate;

    @PrePersist
    protected void onCreate() {
        this.billDate = LocalDateTime.now();
        // Concept: Business logic inside Entity (optional but handy)
        this.totalAmount = totalWeight.multiply(dailyRate);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Farmer getFarmer() {
		return farmer;
	}

	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public BigDecimal getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(BigDecimal totalWeight) {
		this.totalWeight = totalWeight;
	}

	public BigDecimal getDailyRate() {
		return dailyRate;
	}

	public void setDailyRate(BigDecimal dailyRate) {
		this.dailyRate = dailyRate;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getCommissionAmount() {
		return commissionAmount;
	}

	public void setCommissionAmount(BigDecimal commissionAmount) {
		this.commissionAmount = commissionAmount;
	}

	public BigDecimal getFinalPayable() {
		return finalPayable;
	}

	public void setFinalPayable(BigDecimal finalPayable) {
		this.finalPayable = finalPayable;
	}

	public LocalDateTime getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDateTime billDate) {
		this.billDate = billDate;
	}
    
    
}
