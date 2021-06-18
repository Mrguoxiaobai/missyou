package com.lin.missyou.model;

import com.lin.missyou.utils.MapAndJson;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Map;

/**
 * @ClassName: User
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-17 16:13
 * @Version: 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Builder
@Where( clause = "delete_time is null")
public class User extends Base{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String openid;
    private String nickname;
    private Long unifyUid;
    private String email;
    private String password;
    private String mobile;
    @Convert(converter = MapAndJson.class)
    private Map<String,Object> wxProfile;

}
