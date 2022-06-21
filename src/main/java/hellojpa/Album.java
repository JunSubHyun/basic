package hellojpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")              //Defalut = Entity 명
public class Album extends Item{

    private String artist;

}
