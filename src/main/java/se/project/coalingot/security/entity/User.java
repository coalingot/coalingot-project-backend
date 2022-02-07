package se.project.coalingot.security.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "USERNAME", length = 50, unique = true)
    @NotNull
    protected String username;

    @Column(name = "PASSWORD", length = 100)
    @NotNull
    protected String password;

    @Column(name="EMAIL",length = 50)
    @NotNull
    protected String email;

    @Column(name = "FIRSTNAME", length = 50)
    @NotNull
    protected String firstname;

    @Column(name = "LASTNAME", length = 50)
    @NotNull
    protected String lastname;

    @Column(name = "ENABLED")
    @NotNull
    protected Boolean enabled;

    @Column(name = "LASTPASSWORDRESETDATE")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    protected Date lastPasswordResetDate;

	@Builder.Default
    @ManyToMany(fetch = FetchType.EAGER)
    protected List<Authority> authorities = new ArrayList<>();
}