package de.marshal.booking.dao;

import de.marshal.booking.api.RoomDAO;
import de.marshal.booking.api.RoomType;
import de.marshal.booking.dto.Room;

import java.util.*;

public class MemoryRoomDAO implements RoomDAO {
    /*
    rooms               room_types
    | id | type_id |    | id | name      | price |
    ----------------    --------------------------
    | 1  | 1       | => | 1  | STANDARD  | 50    |
    | 2  | 1       | => |    |           |       |
    | 3  | 2       | => | 2  | SUPERIOR  | 75    |
    ----------------    --------------------------

    SELECT
        r.id,
        t.name,
        t.price
    FROM
        rooms r
            INNER JOIN room_types t ON t.id = r.typeId
     */

    private class Row {
        long id;
        long type_id;
    }

    /*
                id  type_id
        1 =>  | 1  | 1      |
        2 =>  | 2  | 1      |
        3 =>  | 3  | 2      |

        id => Row
        id => | id | * |
     */
    private Map<Long, Row> DB = new HashMap<>();

    @Override
    public Room getById(long id) {
        return convertRowToEntity(DB.get(id));
    }

    @Override
    public List<Room> findAll() {
        List<Room> list = new ArrayList<>();

        for (Row row : DB.values()) {
            list.add(convertRowToEntity(row));
        }

        return list;
    }

    @Override
    public void add(Room room) {
        Row row = convertEntityToRow(room);

        DB.put(row.id, row);
    }

    private Room convertRowToEntity(Row row) {
        if (row == null) {
            return null;
        }

        return new Room(row.id, RoomType.ofTypeId(row.type_id));
    }

    private Row convertEntityToRow(Room room) {
        Objects.requireNonNull(room);

        if (room.getId() == null) {
            room.setId(getNextId());
        }

        Row row = new Row();

        row.id = room.getId();
        row.type_id = room.getRoomType().getId();

        return row;
    }

    private Long getNextId() {
        Long max = 0L;

        for (Long key : DB.keySet()) {
            if (key > max) {
                max = key;
            }
        }

        return max + 1L;
    }
}
