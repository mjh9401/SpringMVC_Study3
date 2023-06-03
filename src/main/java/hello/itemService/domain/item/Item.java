package hello.itemService.domain.item;

import lombok.Data;

import java.util.List;


@Data
//@ScriptAssert(lang = "javascript", script="_this.price * _this.quantity >=10000",message = "총합이 10000원 넘게 입력해주세요")
public class Item {

//    @NotNull(groups = UpdateCheck.class)
    private Long id;
//    @NotBlank(groups = {SaveCheck.class, UpdateCheck.class})
    private String itemName;
//    @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
//    @Range(min=1000,max=1000000, groups = {SaveCheck.class, UpdateCheck.class})
    private Integer price;
//    @Max(value = 9999, groups = {SaveCheck.class})
//    @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
    private Integer quantity;

    private Boolean open;// 판매여부
    private List<String> regions; // 등록지역
    private ItemType itemType; // 상품종류
    private String deliveryCode;// 배송 방식

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
