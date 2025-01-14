package kbsc.kbsc.domain.post.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/*
* ***Entity 클래스를 절대 request/response 클래스로 사용하면 안된다. ***
* */

@Getter //클래스내 모든 필드의 getter 메소드 자동생성
@NoArgsConstructor //기본 생성자 자동 추가, public Post()와 같은 효과
@Entity
@Setter //사용하면 안되는데..
public class Post {
    @Id //해당 테이블의 pk 값
    @Column(name = "postIdx") //꼭 필요할까...? 객체명과 DB 컬럼명을 다르게 하고 싶은 경우, DB 컬럼명으로 설정할 이름을 name 속성으로 적는다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk 생성 규칙
    private Long postId;
    @Column(name = "userIdx")
    private Long userId;

  /* //1:N일 때 외래키는 항상 N쪽에 존재
    @ManyToOne
    //같은 키를 관리하기 때문에 문제 발생 가능성 존재 -> 읽기만 가능하도록 설정
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Long userId;*/

    @Column(length = 30)
    private String title;

    private String contents;

    @Column(length = 30)
    private String category;

    private LocalDateTime purchaseDate;
    private String purchasedAt;

    private LocalDateTime  openedDate;
    private LocalDateTime  shelfLife;

    private int expirationDate =15;

    @Column(length = 20)
    private String storageMethod;

    private int sharingPlace_x;

    private int sharingPlace_y;

    private String detailedLocation;

    private LocalDateTime  createdAt;
    private LocalDateTime  updatedAt;

    private int totalHearts=0;
    private String receiptImgUrl;

    private int seenNumber=0;

    @Builder //해당 클래스의 빌더 패턴 클래스 생성, 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함 //생성자 대신 사용
    public Post(Long postId, Long userId, String title, String contents, String category, LocalDateTime purchaseDate, String purchasedAt, LocalDateTime openedDate, LocalDateTime shelfLife, int expirationDate, String storageMethod, int sharingPlace_x, int sharingPlace_y, String detailedLocation, LocalDateTime createdAt, LocalDateTime updatedAt, int totalHearts, String receiptImgUrl, int seenNumber) {
        this.postId = postId;
        this.userId = userId;
        this.title = title;
        this.contents = contents;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.purchasedAt = purchasedAt;
        this.openedDate = openedDate;
        this.shelfLife = shelfLife;
        this.expirationDate = expirationDate;
        this.storageMethod = storageMethod;
        this.sharingPlace_x = sharingPlace_x;
        this.sharingPlace_y = sharingPlace_y;
        this.detailedLocation = detailedLocation;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.totalHearts = totalHearts;
        this.receiptImgUrl = receiptImgUrl;
        this.seenNumber = seenNumber;
    }

}
