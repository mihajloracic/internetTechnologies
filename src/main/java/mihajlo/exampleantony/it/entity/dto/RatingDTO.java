package mihajlo.exampleantony.it.entity.dto;

public class RatingDTO {
    public Long userId;
    public Long placeId;
    public int value;

    public RatingDTO(Long userId, Long placeId, int value) {
        this.userId = userId;
        this.placeId = placeId;
        this.value = value;
    }

    public RatingDTO() {
    }
}
