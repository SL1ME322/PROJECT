    package com.example.projectup.models;
    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.util.Date;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name = "Tag")
    public class TagModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID_Tag")
        private Long id;

        @Column(name = "Tag_Name")
        private String tagName;
    }