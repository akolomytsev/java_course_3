package hib;


import lombok.Data;

@Data
@Entity(table = "dogs")
public class Dog {
    @Column(name = "id")
    private Long id;
    @Column(name = "dog_name")
    private String name;
    @Column(name = "age")
    private Integer age;

}
