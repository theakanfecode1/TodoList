package com.daniel.TodoList.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "todo")
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Todo {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id",updatable = false,nullable = false)
    private UUID id;


    private String username;

    @Column(updatable = false)
    private LocalDateTime createdDate;

    @Column(insertable = false)
    private LocalDateTime updatedDate;

    private String contentText;

    private LocalDateTime dueTime;

    @PrePersist
    public void onCreate(){
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate(){
        updatedDate = LocalDateTime.now();
    }


}
