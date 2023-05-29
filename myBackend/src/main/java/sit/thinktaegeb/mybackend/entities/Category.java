package sit.thinktaegeb.mybackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "categoryId")
    private Integer categoryId;

    @Column(name = "categoryName", nullable = false)
    private String categoryName;




}
