package com.example.demo;

import java.io.File;
import java.util.Objects;
import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
    private Long id;
	private Long parent_id;
    private String name;
//    private File image;
//    private Category parent;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Product> products;

    public Category() {
    	
    }
    public Category(String name) {
        this.name = name;
    }

    public Category(Long id,  String name, Long parent_id) {
        this.id = id;
        this.parent_id = parent_id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public File getImage() {
//        return image;
//    }

//    public void setImage(File image) {
//        this.image = image;
//    }

//    public Category getParent() {
//        return parent;
//    }

//    public void setParent(Category parent) {
//        this.parent = parent;
//    }

    @Override
    public String toString() {
        return name;
    }
}
