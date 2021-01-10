package com.devsuperior.dsdelivery.dto;

import java.io.Serializable;

import com.devsuperior.dsdelivery.entities.Product;

public class ProductDto implements Serializable{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
    private String name;
    private Double price;
    private String description;
    private String imageUri;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUri() {
		return this.imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}


    public ProductDto(){}

    public ProductDto(Long id, String name, Double price, String description, String imageUri){
        this.id= id;
        this.name =name;
        this.price = price;
        this.description = description;
        this.imageUri  =imageUri;
    }

    public ProductDto(Product entity){
        id=entity.getId();
        description=entity.getDescription();
        imageUri =entity.getImageUri();
        name =entity.getName();
        price=entity.getPrice();
    }
}
