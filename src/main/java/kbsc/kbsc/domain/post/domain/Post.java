package kbsc.kbsc.domain.post.domain;

import kbsc.kbsc.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/*
* ***Entity 클래스를 절대 request/response 클래스로 사용하면 안된다. ***
* */

@Getter //클래스내 모든 필드의 getter 메소드 자동생성
@NoArgsConstructor //기본 생성자 자동 추가, public Post()와 같은 효과
@Entity //**entity 클래스에는 절대 setter 메소드 만들지 않음
@Table(name="post")
public class Post { //실제 db와 매칭될 클래스, 보통 entity 클래스라고 함
    @Id //해당 테이블의 pk 값
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk 생성 규칙
    private Long postId;

   /* //1:N일 때 외래키는 항상 N쪽에 존재
    @ManyToOne
    //같은 키를 관리하기 때문에 문제 발생 가능성 존재 -> 읽기만 가능하도록 설정
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;*/


    @Column(length = 30, nullable = false)
    private String title;

    @Column(nullable = false, length = 30)
    private String category;
    /*
    @Column(nullable = false)
    private LocalDateTime purchaseDate;
    private String purchasedAt;

    @Column(nullable = false)
    private LocalDateTime  openedDate;
    private LocalDateTime  shelfLife;

    @Column(nullable = false)
    private int expirationDate =15;

    @Column(nullable = false, length = 20)
    private String storageMethod;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private int sharingPlace_x;

    @Column(nullable = false)
    private int sharingPlace_y;

    @Column(nullable = false)
    private String detailedLocation;

    @Column(nullable = false)
    private LocalDateTime  createdAt;
    private LocalDateTime  updatedAt;

    @Column(nullable = false)
    private int totalHearts=0;
    private String receiptImgUrl;

    @Column(nullable = false)
    private int seenNumber=0;*/

    @Builder //해당 클래스의 빌더 패턴 클래스 생성, 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함 //생성자 대신 사용
    public Post(String title, String category){//, LocalDateTime purchaseDate, String purchasedAt, LocalDateTime openedDate, LocalDateTime shelfLife, int expirationDate, String storageMethod, String contents, int sharingPlace_x, int sharingPlace_y, String detailedLocation, LocalDateTime createdAt, LocalDateTime updatedAt, int totalHearts, String receiptImgUrl, int seenNumber) {
        this.title = title;
        this.category = category;
        /*
        this.purchaseDate = purchaseDate;
        this.purchasedAt = purchasedAt;
        this.openedDate = openedDate;
        this.shelfLife = shelfLife;
        this.expirationDate = expirationDate;
        this.storageMethod = storageMethod;
        this.contents = contents;
        this.sharingPlace_x = sharingPlace_x;
        this.sharingPlace_y = sharingPlace_y;
        this.detailedLocation = detailedLocation;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.totalHearts = totalHearts;
        this.receiptImgUrl = receiptImgUrl;
        this.seenNumber = seenNumber;
        this.post_hashtag= post_hashtag; */
    }

    public void update(String title, String category) {
        this.title = title;
        this.category = category;
    }
}