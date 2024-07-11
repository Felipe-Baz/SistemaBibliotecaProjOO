package com.library.model.composite;

import java.util.ArrayList;
import java.util.List;

public class BookCategoryComposite {
    private String id;
    private String name;
    private List<BookCategoryComposite> subCategories;

    // Construtor padrão
    public BookCategoryComposite() {
        this.subCategories = new ArrayList<>();
    }

    // Construtor com parâmetros
    public BookCategoryComposite(String id, String name) {
        this.id = id;
        this.name = name;
        this.subCategories = new ArrayList<>();
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookCategoryComposite> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<BookCategoryComposite> subCategories) {
        this.subCategories = subCategories;
    }

    // Método para adicionar subcategoria
    public void addSubCategory(BookCategoryComposite subCategory) {
        this.subCategories.add(subCategory);
    }

    // Método para remover subcategoria
    public void removeSubCategory(BookCategoryComposite subCategory) {
        this.subCategories.remove(subCategory);
    }

    // Método para buscar subcategoria por ID
    public BookCategoryComposite findSubCategoryById(String id) {
        if (this.id.equals(id)) {
            return this;
        }
        for (BookCategoryComposite subCategory : subCategories) {
            BookCategoryComposite result = subCategory.findSubCategoryById(id);
            if (result != null) {
                return result;
            }
        }
        return null;
    }
}
