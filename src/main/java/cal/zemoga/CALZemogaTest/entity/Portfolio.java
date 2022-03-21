package cal.zemoga.CALZemogaTest.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="portfolio")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idportfolio;
    private String description;
    private String experience_summary;
    private Integer id;
    private String image_url;
    private String last_names;
    private String names;
    private String tittle;
    private String twitter_user_id;
    private String twitter_user_name;
    private String user_id;
    private String address;
    private String email;
    private String experience;
    private String image_path;
    private String name;
    private String phone;
    private String twitter_user;
    private String zip_code;
    private String title;
}
