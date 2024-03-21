/*==============================================================*/

DROP TABLE IF EXISTS occupancy;
DROP TABLE IF EXISTS hotel;

/*==============================================================*/
/* Table: hotel                                                 */
/*==============================================================*/
CREATE TABLE hotel
(
  id      INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
  category int NOT NULL ,
  name    TEXT NOT NULL,
  owner   TEXT NOT NULL,
  contact TEXT NOT NULL,
  address TEXT NOT NULL,
  city    TEXT NOT NULL,
  zip     TEXT NOT NULL,
  phone   TEXT NOT NULL,
  rooms   int  not null,
  beds    int  not null
);

CREATE TABLE occupancy
(
    occupancy_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    id INT,
    rooms int NOT NULL,
    usedrooms int NOT NULL,
    beds int NOT NULL,
    usedbeds int NOT NULL,
    year int NOT NULL,
    month int NOT NULL,
    constraint fk_hotel foreign key (id) references hotel(id)
);
