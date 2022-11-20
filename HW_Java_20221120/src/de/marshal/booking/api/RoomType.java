package de.marshal.booking.api;

public enum RoomType {
    /*
    room_types
    | id | name      | price | fc  |
    -------------------------------
    | 1  | STANDARD  | 50    | 20  |
    | 2  | SUPERIOR  | 75    | 10  |
    | 3  | DELUXE    | 100   | 0   |
    | 4  | PRESIDENT | 150   | 0   |

    Чтобы не делать еще один DAO, сделаем фиксированную версию
     */

    STANDARD(1, 50L, 20L),
    SUPERIOR(2, 75L, 10L),
    DELUXE(3, 100L, 0L),
    PRESIDENT(4, 150L, 0L);

    public static RoomType ofTypeId(long id){
        for (RoomType roomType : RoomType.values()) {
            if (id == roomType.id){
                return roomType;
            }
        }

        throw new IllegalArgumentException("Id " + id + " does not map to a room type");
    }

    private long id;
    // Цена за ночь
    private long roomPrice;
    // Фиксированная цена за доступ в FC на время пребывания
    private long fcPrice;

    RoomType(long id, long roomPrice, long fcPrice) {
        this.id = id;
        this.roomPrice = roomPrice;
        this.fcPrice = fcPrice;
    }

    public long getId() {
        return id;
    }

    public long getRoomPrice() {
        return roomPrice;
    }

    public long getFcPrice() {
        return fcPrice;
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "id=" + id +
                ", roomPrice=" + roomPrice +
                ", fcPrice=" + fcPrice +
                "} " + super.toString();
    }
}
